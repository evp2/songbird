package edu.psu.music_api.client.model.response;

import java.util.List;


public class Record {
    private final String artistName;
    private final String songTitle;
    private final String releaseDate;
    private final String thumbnail;
    private final String songId;
    private final String artistId;

    private final List<String> featuredArtists;

    public Record(
            String artistName,
            String songTitle,
            String releaseDate,
            String thumbnail,
            String songId, String artistId, List<String> featuredArtists) {
        this.artistName = artistName;
        this.songTitle = songTitle;
        this.releaseDate = releaseDate;
        this.thumbnail = thumbnail;
        this.songId = songId;
        this.artistId = artistId;
        this.featuredArtists = featuredArtists;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongTitle() {
        return songTitle;
    }


    public String getReleaseDate() {
        return releaseDate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getSongId() {
        return songId;
    }

    public List<String> getFeaturedArtists() {
        return featuredArtists;
    }

    @Override
    public String toString() {
        return "Song{" +
                "artistName='" + artistName + '\'' +
                ", songTitle='" + songTitle + '\'' +
                ", releaseDate=" + releaseDate +
                ", thumbnail='" + thumbnail + '\'' +
                ", songId='" + songId + '\'' +
                ", artistId='" + artistId + '\'' +
                ", featuredArtists=" + featuredArtists +
                '}';
    }
}
