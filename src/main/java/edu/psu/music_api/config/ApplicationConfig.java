package edu.psu.music_api.config;

import edu.psu.music_api.client.GeniusClient;
import edu.psu.music_api.client.GeniusClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean(name = "geniusClient")
    public GeniusClient geniusClient(
            @Value("${application.api.url}") String apiUrl,
            @Value("${application.api.token}") String token
    ) {
        return GeniusClientFactory.client(apiUrl, token);
    }
}
