package pl.codementors.springdi.airports.auditor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.codementors.springdi.airports.model.Airport;
import pl.codementors.springdi.configuration.properties.AuditorProperties;

@Component
@RequiredArgsConstructor
public class ForbiddenIataAuditor implements AirportAuditor {

    private final AuditorProperties auditorProperties;

    @Override
    public boolean accepts(Airport airport) {
        return !auditorProperties.getForbiddenIata().contains(airport.getIata());
    }
}
