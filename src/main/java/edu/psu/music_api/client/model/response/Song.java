package edu.psu.music_api.client.model.response;

import java.util.List;

public class Song {
    private final String id;
    private final String title;
    private final String primaryArtist;
    private final List<String> featuredArtists;
    private final String album;
    private final String releaseDate;
    private final String thumbnail;
    private final List<String> description;

    public Song(
            String id,
            String title,
            String primaryArtist,
            List<String> featuredArtists,
            String album,
            String releaseDate,
            String thumbnail,
            List<String> description
    ) {
        this.id = id;
        this.title = title;
        this.primaryArtist = primaryArtist;
        this.featuredArtists = featuredArtists;
        this.album = album;
        this.releaseDate = releaseDate;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public String getPrimaryArtist() {
        return primaryArtist;
    }

    public List<String> getFeaturedArtists() {
        return featuredArtists;
    }

    public String getAlbum() {
        return album;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public List<String> getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", primaryArtist='" + primaryArtist + '\'' +
                ", featuredArtists=" + featuredArtists +
                ", album='" + album + '\'' +
                ", releaseDate=" + releaseDate +
                ", thumbnail='" + thumbnail + '\'' +
                ", description=" + description +
                '}';
    }
}
