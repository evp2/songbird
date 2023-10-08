package edu.psu.music_api.client.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import edu.psu.music_api.client.model.response.Song;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonComponent
public class SongDeserializer extends JsonDeserializer<Song> {
    private static final String FORMAT = "html";

    @Override
    public Song deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode jsonNode = parser.getCodec().readTree(parser);
        JsonNode edge = jsonNode.get("response").get("song");
        Song song = new Song(
                edge.get("id").asText(),
                edge.get("title").asText(),
                edge.get("primary_artist").get("name").asText(),
                extractFeaturedArtists(edge),
                edge.get("album").get("name").asText(),
                edge.get("release_date_with_abbreviated_month_for_display").asText(),
                edge.get("song_art_image_thumbnail_url").asText(),
                extractDescription(edge)
        );
        return song;
    }

    private List<String> extractDescription(JsonNode edge) {
        if (FORMAT.equals("html")) {
            return List.of(edge.get("description").get("html").asText());
        } else
            return null;
    }

    private List<String> extractFeaturedArtists(JsonNode result) {
        if (result == null || !result.has("featured_artists")) {
            return null;
        }

        JsonNode featuredArtists = result.get("featured_artists");
        List<String> _featuredArtists = new ArrayList<>();

        if (featuredArtists != null && featuredArtists.isArray()) {
            for (JsonNode artist : featuredArtists) {
                String artistName = artist.get("name").asText();
                _featuredArtists.add(artistName);
            }
        }

        return _featuredArtists;
    }

}
