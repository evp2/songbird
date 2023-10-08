package edu.psu.music_api.client;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeniusClientFactory {
    private static final Logger logger = LoggerFactory.getLogger(GeniusClientFactory.class);

    /**
     * @param apiUrl
     * @param token
     * @return GeniusClient
     */
    public static GeniusClient client(
            String apiUrl,
            String token
    ) {
        Validate.notNull(apiUrl, "'%s' cannot be null", "apiUrl");
        Validate.notNull(token, "'%s' cannot be null", "token");

        logger.info("instantiating Genius client");

        return new GeniusClient(apiUrl, token);

    }
}
