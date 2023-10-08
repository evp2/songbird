package edu.psu.music_api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.psu.music_api.client.GeniusClient;
import edu.psu.music_api.client.GeniusClientFactory;
import edu.psu.music_api.client.model.response.Artist;
import edu.psu.music_api.client.model.response.SearchResult;
import edu.psu.music_api.client.model.response.Song;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@JsonTest
public class MusicApiApplicationTests {
    private static GeniusClient geniusClient;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        String apiUrl = System.getenv("API-URL");
        String token = System.getenv("TOKEN");
        geniusClient = GeniusClientFactory.client(apiUrl, token);
    }
    @Test
    void contextLoads() {
        assertNotNull(objectMapper);
    }
    @Test
    public void queryTest() throws JsonProcessingException {
        String response = geniusClient.query("Kendrick Lamar");
        SearchResult searchResult = objectMapper.readValue(response, SearchResult.class);
        assertNotNull(searchResult);
    }

    @Test
    public void artistTest() throws JsonProcessingException {
        String response = geniusClient.artistInfo("1421", "html");
        Artist artist = objectMapper.readValue(response, Artist.class);
        assertNotNull(artist);
    }

    @Test
    public void songTest() throws JsonProcessingException {
        String response = geniusClient.songInfo("378195", "html");
        Song song = objectMapper.readValue(response, Song.class);
        assertNotNull(song);
    }
}
