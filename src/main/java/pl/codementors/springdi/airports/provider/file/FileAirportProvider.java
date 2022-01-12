package pl.codementors.springdi.airports.provider.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.codementors.springdi.airports.model.Airport;
import pl.codementors.springdi.airports.model.Continent;
import pl.codementors.springdi.airports.provider.AirportProvider;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class FileAirportProvider implements AirportProvider {

    public static final Path AIRPORTS_PATH = Paths.get("airports.csv");

    private final Map<String, Airport> airports = new HashMap<>();

    @PostConstruct
    void init() throws IOException {
        Files.readAllLines(AIRPORTS_PATH)
                .stream()
                .map(line -> line.split(","))
                .map(line -> new Airport(line[0], line[1], Continent.valueOf(line[2])))
                .forEach(airport -> airports.put(airport.getIata(), airport));
    }

    @Override
    public Optional<Airport> getAirport(String iata) {
        return Optional.ofNullable(airports.get(iata));
    }
}
