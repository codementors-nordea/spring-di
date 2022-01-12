package pl.codementors.springdi.airports.provider;

import pl.codementors.springdi.airports.model.Airport;

import java.util.Optional;

public interface AirportProvider {

    Optional<Airport> getAirport(String iata);

}
