package edu.psu.music_api.client.model.response;

import java.util.List;

public class SearchResult {
    private final List<Record> records;

    public SearchResult(List<Record> records) {
        this.records = records;
    }

    public List<Record> getSongs() {
        return records;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "songs=" + records +
                '}';
    }
}
