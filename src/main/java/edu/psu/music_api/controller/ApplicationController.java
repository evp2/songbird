package edu.psu.music_api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.psu.music_api.client.GeniusClient;
import edu.psu.music_api.client.model.response.Artist;
import edu.psu.music_api.client.model.response.SearchResult;
import edu.psu.music_api.client.model.response.Song;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ApplicationController {
    private final ObjectMapper objectMapper;
    private final GeniusClient geniusClient;

    public ApplicationController(
            ObjectMapper objectMapper,
            GeniusClient geniusClient
    ) {
        this.objectMapper = objectMapper;
        this.geniusClient = geniusClient;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView home = new ModelAndView("index");
        return home;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(
            value = "/search"
    )
    public SearchResult search(@RequestParam() String query) throws JsonProcessingException {
        SearchResult result = null;
        if (query != null && !query.isEmpty()) {
            String response = geniusClient.query(query);
            if (response != null && !response.isEmpty()) {
                result = objectMapper.readValue(response, SearchResult.class);
            }
        }
        return result;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(
            value = "/artist/{id}"
    )
    public Artist artist(@PathVariable String id) throws JsonProcessingException {
        Artist artist = null;
        if (id != null && !id.isEmpty()) {
            String response = geniusClient.artistInfo(id, "html");
            if (response != null && !response.isEmpty()) {
                artist = objectMapper.readValue(response, Artist.class);
            }
        }
        return artist;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(
            value = "/songs/{id}"
    )
    public Song song(@PathVariable String id) throws JsonProcessingException {
        Song song = null;
        if (id != null && !id.isEmpty()) {
            String response = geniusClient.songInfo(id, "html");
            if (response != null && !response.isEmpty()) {
                song = objectMapper.readValue(response, Song.class);
            }
        }
        return song;
    }
}
