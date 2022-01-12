package pl.codementors.springdi.airports.auditor;

import org.springframework.stereotype.Component;
import pl.codementors.springdi.airports.model.Airport;
import pl.codementors.springdi.airports.model.Continent;

@Component
public class DenySouthAmericaAuditor implements AirportAuditor {

    @Override
    public boolean accepts(Airport airport) {
        return airport.getContinent() != Continent.SA;
    }
}
