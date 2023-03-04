package com.wright.calculator;

import com.wright.model.Episode;
import com.wright.model.Season;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestSeasonsWatchedInOrder {
    @Test
    public void testOneSeasonWasWatchedInOrder() {
        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        Season seasonOne = new Season(1);
        seasonOne.addEpisode(new Episode(timestamp, episodeId, seasonId, showId, userId));

        ShowsWatchedInOrderCalculator calculator = new ShowsWatchedInOrderCalculator();
        boolean wasSeasonWatchedInOrder = calculator.wasSeasonWatchedInOrder(seasonOne);
        assertTrue(wasSeasonWatchedInOrder);
    }

    @Test
    public void testOneSeasonWasNotWatchedInOrder() {
        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 2;
        long timestamp = 1234;

        Season seasonOne = new Season(1);
        seasonOne.addEpisode(new Episode(timestamp, episodeId, seasonId, showId, userId));

        ShowsWatchedInOrderCalculator calculator = new ShowsWatchedInOrderCalculator();
        boolean wasSeasonWatchedInOrder = calculator.wasSeasonWatchedInOrder(seasonOne);
        assertFalse(wasSeasonWatchedInOrder);
    }

    @Test
    public void testOneSeasonWithMultipleEpisodesWatchedInOrder() {
        List<Episode> episodes = new ArrayList<>();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));

        episodeId = 2;
        timestamp = 2345;
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));

        episodeId = 3;
        timestamp = 3456;
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));

        episodeId = 4;
        timestamp = 4567;
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));

        Season seasonOne = new Season(1);
        seasonOne.addEpisodes(episodes);

        ShowsWatchedInOrderCalculator calculator = new ShowsWatchedInOrderCalculator();
        boolean wasSeasonWatchedInOrder = calculator.wasSeasonWatchedInOrder(seasonOne);
        assertTrue(wasSeasonWatchedInOrder);
    }

    @Test
    public void testOneSeasonWithMultipleEpisodesNotWatchedInOrder() {
        List<Episode> episodes = new ArrayList<>();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));

        episodeId = 2;
        timestamp = 2345;
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));

        episodeId = 3;
        timestamp = 4567;
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));

        episodeId = 4;
        timestamp = 3456;
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));

        Season seasonOne = new Season(1);
        seasonOne.addEpisodes(episodes);

        ShowsWatchedInOrderCalculator calculator = new ShowsWatchedInOrderCalculator();
        boolean wasSeasonWatchedInOrder = calculator.wasSeasonWatchedInOrder(seasonOne);
        assertFalse(wasSeasonWatchedInOrder);
    }
}
