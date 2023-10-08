package edu.psu.music_api.client.model.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import edu.psu.music_api.client.model.response.Record;
import edu.psu.music_api.client.model.response.SearchResult;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@JsonComponent
public class SearchDeserializer extends JsonDeserializer<SearchResult> {
    private static final String DATE_PATTERN = "MMM. d, yyyy";

    @Override
    public SearchResult deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode jsonNode = parser.getCodec().readTree(parser);
        JsonNode hits = jsonNode.get("response").get("hits");
        List<Record> records = new ArrayList<>();
        if (hits.isArray()) {
            for (JsonNode node : hits) {
                JsonNode result = node.get("result");
                Record record = new Record(
                        result.get("primary_artist").get("name").asText(),
                        result.get("title").asText(),
                        extractDate(result),
                        result.get("song_art_image_thumbnail_url").asText(),
                        result.get("id").asText(),
                        result.get("primary_artist").get("id").asText(),
                        extractFeaturedArtists(result));
                records.add(record);
            }
        }
        return new SearchResult(records);
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

    private LocalDate extractDate(JsonNode result) {
        return LocalDate.parse(result.get("release_date_with_abbreviated_month_for_display").asText(), DateTimeFormatter.ofPattern(DATE_PATTERN));
    }
}
