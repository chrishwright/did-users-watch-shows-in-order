package com.wright.model;

import java.util.*;

public class Show {
    private final Map<Integer, Season> seasonIdToSeasonListMap = new HashMap<>();

    public void addEpisodeToSeason(Episode episode) {
        int seasonId = episode.getSeasonId();
        if (seasonIdToSeasonListMap.containsKey(seasonId)) {
            seasonIdToSeasonListMap.get(seasonId).addEpisode(episode);
        } else {
            Season season = new Season(seasonId);
            season.addEpisode(episode);
            seasonIdToSeasonListMap.put(seasonId, season);
        }
    }

    public List<Season> getAllSeasonsSorted() {
        List<Season> sorted = new ArrayList<>(seasonIdToSeasonListMap.values());
        sorted.sort(Comparator.comparingInt(Season::getSeasonNumber));
        return sorted;
    }
}
