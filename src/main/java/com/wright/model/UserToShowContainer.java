package com.wright.model;

import java.util.*;

public class UserToShowContainer {
    private final Map<Integer, UserViewings> userIdToUserViewingMap = new HashMap<>();

    public void addFoundEpisodeToShow(Episode episode) {
        if (userIdToUserViewingMap.containsKey(episode.getUserId())) {
            userIdToUserViewingMap.get(episode.getUserId()).addEpisodeToShow(episode);
        } else {
            UserViewings newUserViewings = new UserViewings(episode.getUserId());
            newUserViewings.addEpisodeToShow(episode);
            userIdToUserViewingMap.put(episode.getUserId(), newUserViewings);
        }
    }

    public Map<Integer, UserViewings> getUserIdToUserViewingMap() {
        return userIdToUserViewingMap;
    }
}
