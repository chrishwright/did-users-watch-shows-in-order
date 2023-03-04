package com.wright.model;

import java.util.*;
import java.util.stream.Collectors;

public class UserViewings {
    Map<Integer, Show> showIdToSeasonMap = new HashMap<>();
    final int userId;

    public UserViewings(int userId) {
        this.userId = userId;
    }

    public void addEpisodeToShow(Episode episode) {
        int showId = episode.getShowId();
        if (showIdToSeasonMap.containsKey(showId)) {
            showIdToSeasonMap.get(showId).addEpisodeToSeason(episode);
        } else {
            Show newShow = new Show();
            newShow.addEpisodeToSeason(episode);
            showIdToSeasonMap.put(showId, newShow);
        }
    }

    public List<Show> getShowsForUser() {
        return showIdToSeasonMap.values().stream().collect(Collectors.toUnmodifiableList());
    }
}
