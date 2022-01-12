package pl.codementors.springdi.airports.auditor;

import pl.codementors.springdi.airports.model.Airport;

public interface AirportAuditor {

    boolean accepts(Airport airport);
}
