package com.wright.model;

import java.util.*;

public class Season {
    private final List<Episode> episodes;
    private final int seasonNumber;

    public Season(int seasonNumber) {
        if (seasonNumber <= 0) {
            throw new IllegalArgumentException("Season number must be greater than 0.");
        }
        this.episodes = new ArrayList<>();
        this.seasonNumber = seasonNumber;
    }

    public void addEpisode(Episode episode) {
        this.episodes.add(episode);
    }

    public void addEpisodes(List<Episode> episodes) {
        this.episodes.addAll(episodes);
    }

    public List<Episode> getEpisodesSorted() {
        List<Episode> sortedEpisodes = new ArrayList<>(this.episodes);
        sortedEpisodes.sort(Comparator.comparingLong(Episode::getTimestamp));
        return sortedEpisodes;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }
}
