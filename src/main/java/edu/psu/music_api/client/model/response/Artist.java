package edu.psu.music_api.client.model.response;

import java.util.List;

public class Artist {
    private final String name;
    private final String facebookName;
    private final String instagramName;
    private final String twitterName;
    private final List<String> description;
    private final String alternateNames;
    private final String id;
    private final String imageUrl;

    public Artist(
            String name,
            String facebookName,
            String instagramName,
            String twitterName,
            List<String> description,
            String alternateNames,
            String id,
            String imageUrl) {
        this.name = name;
        this.facebookName = facebookName;
        this.instagramName = instagramName;
        this.twitterName = twitterName;
        this.description = description;
        this.alternateNames = alternateNames;
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getFacebookName() {
        return facebookName;
    }

    public String getInstagramName() {
        return instagramName;
    }

    public String getTwitterName() {
        return twitterName;
    }

    public List<String> getDescription() {
        return description;
    }

    public String getAlternateNames() {
        return alternateNames;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "ArtistInfo{" +
                "name='" + name + '\'' +
                ", facebookName='" + facebookName + '\'' +
                ", instagramName='" + instagramName + '\'' +
                ", twitterName='" + twitterName + '\'' +
                ", alternateNames='" + alternateNames + '\'' +
                ", id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
