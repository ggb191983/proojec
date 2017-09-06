package es.proojec;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ggb191983 on 06/09/2017.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {

    private String name;
    private String environment;

    // standard getters and setters

    public String getName() {
        return name;
    }

    public String getEnvironment() {
        return environment;
    }
}
