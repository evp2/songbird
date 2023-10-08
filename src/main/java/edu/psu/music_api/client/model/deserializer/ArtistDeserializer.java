package edu.psu.music_api.client.model.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import edu.psu.music_api.client.model.response.Artist;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

@JsonComponent
public class ArtistDeserializer extends JsonDeserializer<Artist> {
    private static String FORMAT = "html";

    @Override
    public Artist deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        JsonNode jsonNode = parser.getCodec().readTree(parser);
        JsonNode edge = jsonNode.get("response").get("artist");
        Artist artist = new Artist(
                edge.get("name").asText(),
                edge.get("facebook_name").asText(),
                edge.get("instagram_name").asText(),
                edge.get("twitter_name").asText(),
                extractDescription(edge),
                extractAlternateNames(edge),
                edge.get("id").asText(),
                edge.get("image_url").asText()
        );
        return artist;
    }

    private List<String> extractDescription(JsonNode edge) {
        if (FORMAT.equals("html")) {
            return List.of(edge.get("description").get("html").asText());
        } else
            return null;
    }

    private String extractAlternateNames(JsonNode edge) {

        if (edge == null || !edge.has("alternate_names")) {
            return "";
        }

        JsonNode alternateNames = edge.get("alternate_names");
        StringJoiner joiner = new StringJoiner(", ");

        if (alternateNames.isArray()) {
            for (JsonNode name : alternateNames) {
                joiner.add(name.asText());
            }
        }

        return joiner.toString();
    }

}
