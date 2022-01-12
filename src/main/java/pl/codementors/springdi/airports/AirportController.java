package pl.codementors.springdi.airports;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.codementors.springdi.airports.auditor.AirportAuditor;
import pl.codementors.springdi.airports.model.Airport;
import pl.codementors.springdi.airports.provider.AirportProvider;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AirportController {

    private final AirportProvider airportProvider;
    private final List<AirportAuditor> airportAuditors;

    @GetMapping("/api/airports/{iata}")
    public Optional<Airport> getAirport(@PathVariable String iata) {
        return airportProvider.getAirport(iata)
                .filter(this::canBeDisplayed);
    }

    private boolean canBeDisplayed(Airport airport) {
        return airportAuditors.stream().allMatch(airportAuditor -> airportAuditor.accepts(airport));
    }
}
