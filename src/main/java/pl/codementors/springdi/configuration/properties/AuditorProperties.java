package pl.codementors.springdi.configuration.properties;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@Value
@ConstructorBinding
@ConfigurationProperties("airports.auditor")
public class AuditorProperties {
    List<String> forbiddenIata;
}
