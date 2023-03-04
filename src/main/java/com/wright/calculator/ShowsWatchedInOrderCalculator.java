package com.wright.calculator;

import com.wright.model.*;

import java.util.Comparator;
import java.util.List;

public class ShowsWatchedInOrderCalculator {

    public static boolean didUserWatchShowsInOrder(UserViewings userViewings) {
        for (Show show : userViewings.getShowsForUser()) {
            if (!wasShowWatchedInOrder(show)) {
                return false;
            }
        }
        return true;
    }

    public static boolean wasShowWatchedInOrder(Show show) {
        List<Season> seasonsForShow = show.getAllSeasonsSorted();

        seasonsForShow.sort(Comparator.comparingInt(Season::getSeasonNumber));

        Season previousSeason = seasonsForShow.get(0);
        if (!wasSeasonWatchedInOrder(previousSeason)) {
            return false;
        }

        for (int i = 1; i < seasonsForShow.size(); i++) {
            final Season currentSeason = seasonsForShow.get(i);
            previousSeason = seasonsForShow.get(i - 1);

            if (!wasSeasonWatchedInOrder(currentSeason)) {
                return false;
            }

            long currentSeasonFirstEpTimestamp = currentSeason.getEpisodesSorted().get(0).getTimestamp();
            long previousSeasonLastEpTimestamp =
                    previousSeason.getEpisodesSorted().get(previousSeason.getEpisodesSorted().size() - 1).getTimestamp();

            if (currentSeasonFirstEpTimestamp < previousSeasonLastEpTimestamp) {
                return false;
            }
        }

        return true;
    }

    public static boolean wasSeasonWatchedInOrder(Season season) {
        return wereEpisodesWatchedInOrder(season.getEpisodesSorted());
    }

    public static boolean wereEpisodesWatchedInOrder(List<Episode> episodes) {
        episodes.sort(Comparator.comparingLong(Episode::getTimestamp));

        if (episodes.get(0).getEpisodeId() != 1) {
            return false;
        }

        for (int i = 1; i < episodes.size(); i++) {
            Episode currentEpisode = episodes.get(i);
            Episode previousEpisode = episodes.get(i - 1);

            boolean isMoreThanOneEpisodeGap =
                    currentEpisode.getEpisodeId() - previousEpisode.getEpisodeId() > 1;
            boolean didWatchCurrentEpisodeBeforePrevious =
                    currentEpisode.getTimestamp() < previousEpisode.getTimestamp();
            if (isMoreThanOneEpisodeGap || didWatchCurrentEpisodeBeforePrevious) {
                return false;
            }
        }

        return true;
    }
}
