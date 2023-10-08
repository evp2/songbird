package edu.psu.music_api.client;

import edu.psu.music_api.client.filter.BearerAuthClientFilter;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeniusClient {
    public static Logger logger = LoggerFactory.getLogger(GeniusClient.class);
    private final String apiUrl;
    private final String token;

    /**
     * @param apiUrl
     * @param token
     */
    public GeniusClient(
            String apiUrl,
            String token
    ) {
        this.apiUrl = apiUrl;
        this.token = token;

    }

    public String query(String query) {
        WebTarget webTarget = JerseyClientBuilder.createClient().target(apiUrl);
        webTarget.register(new BearerAuthClientFilter(token), Priorities.HEADER_DECORATOR);
        webTarget = webTarget.path("/search").queryParam("q", query);
        String response = null;
        try {
            String searchResponse = webTarget.request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get(String.class);
            if (searchResponse != null && !searchResponse.isEmpty()) {
                response = searchResponse;
            }
        } catch (Exception e) {
            logger.error("Error message: {}", e.toString());
        }
        return response;
    }

    public String artistInfo(String id, String textFormat) {
        WebTarget webTarget = JerseyClientBuilder.createClient().target(apiUrl);
        webTarget.register(new BearerAuthClientFilter(token), Priorities.HEADER_DECORATOR);
        webTarget = webTarget.path("/artists/" + id).queryParam("text_format", textFormat);
        String response = null;
        try {
            String artistInfo = webTarget.request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get(String.class);
            if (artistInfo != null && !artistInfo.isEmpty()) {
                response = artistInfo;
            }
        } catch (Exception e) {
            logger.error("Error message: {}", e.toString());
        }
        return response;
    }

    public String songInfo(String id, String textFormat) {
        WebTarget webTarget = JerseyClientBuilder.createClient().target(apiUrl);
        webTarget.register(new BearerAuthClientFilter(token), Priorities.HEADER_DECORATOR);
        webTarget = webTarget.path("/songs/" + id).queryParam("text_format", textFormat);
        String response = null;
        try {
            String songInfo = webTarget.request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get(String.class);
            if (songInfo != null && !songInfo.isEmpty()) {
                response = songInfo;
            }
        } catch (Exception e) {
            logger.error("Error message: {}", e.toString());
        }
        return response;
    }
}
