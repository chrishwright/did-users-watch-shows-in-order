package com.wright.calculator;

import com.wright.model.Episode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestEpisodesWatchedInOrder {
    @Test
    public void testThatOneEpisodeWasWatchedInOrder() {
        ShowsWatchedInOrderCalculator calculator = new ShowsWatchedInOrderCalculator();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        List<Episode> episodes = new ArrayList<>();
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));

        boolean wereEpisodesWatchedInOrder = calculator.wereEpisodesWatchedInOrder(episodes);
        assertTrue(wereEpisodesWatchedInOrder);
    }

    @Test
    public void testThatOneEpisodeWasNotWatchedInOrder() {
        ShowsWatchedInOrderCalculator calculator = new ShowsWatchedInOrderCalculator();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 2;
        long timestamp = 1234;

        List<Episode> episodes = new ArrayList<>();
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));

        boolean wereEpisodesWatchedInOrder = calculator.wereEpisodesWatchedInOrder(episodes);
        assertFalse(wereEpisodesWatchedInOrder);
    }

    @Test
    public void testThatTwoEpisodesWereWatchedInOrder() {
        ShowsWatchedInOrderCalculator calculator = new ShowsWatchedInOrderCalculator();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        int episodeTwoId = 2;
        long episodeTwoTimestamp = 2345;

        List<Episode> episodes = new ArrayList<>();
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));
        episodes.add(new Episode(episodeTwoTimestamp, episodeTwoId, seasonId, showId, userId));

        boolean wereEpisodesWatchedInOrder = calculator.wereEpisodesWatchedInOrder(episodes);
        assertTrue(wereEpisodesWatchedInOrder);
    }

    @Test
    public void testThatTwoEpisodesWereNotWatchedInOrder() {
        ShowsWatchedInOrderCalculator calculator = new ShowsWatchedInOrderCalculator();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 56789;

        int episodeTwoId = 2;
        long episodeTwoTimestamp = 12345;

        List<Episode> episodes = new ArrayList<>();
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));
        episodes.add(new Episode(episodeTwoTimestamp, episodeTwoId, seasonId, showId, userId));

        boolean wereEpisodesWatchedInOrder = calculator.wereEpisodesWatchedInOrder(episodes);
        assertFalse(wereEpisodesWatchedInOrder);
    }

    @Test
    public void testThatMultipleEpisodesWereWatchedInOrder() {
        ShowsWatchedInOrderCalculator calculator = new ShowsWatchedInOrderCalculator();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        int episodeTwoId = 2;
        long episodeTwoTimestamp = 2345;

        int episodeThreeId = 3;
        long episodeThreeTimestamp = 3456;

        List<Episode> episodes = new ArrayList<>();
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));
        episodes.add(new Episode(episodeTwoTimestamp, episodeTwoId, seasonId, showId, userId));
        episodes.add(new Episode(episodeThreeTimestamp, episodeThreeId, seasonId, showId, userId));

        boolean wereEpisodesWatchedInOrder = calculator.wereEpisodesWatchedInOrder(episodes);
        assertTrue(wereEpisodesWatchedInOrder);
    }

    @Test
    public void testThatMultipleEpisodesWereNotWatchedInOrder() {
        ShowsWatchedInOrderCalculator calculator = new ShowsWatchedInOrderCalculator();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        int episodeTwoId = 2;
        long episodeTwoTimestamp = 3456;

        int episodeThreeId = 3;
        long episodeThreeTimestamp = 2345;

        List<Episode> episodes = new ArrayList<>();
        episodes.add(new Episode(timestamp, episodeId, seasonId, showId, userId));
        episodes.add(new Episode(episodeTwoTimestamp, episodeTwoId, seasonId, showId, userId));
        episodes.add(new Episode(episodeThreeTimestamp, episodeThreeId, seasonId, showId, userId));

        boolean wereEpisodesWatchedInOrder = calculator.wereEpisodesWatchedInOrder(episodes);
        assertFalse(wereEpisodesWatchedInOrder);
    }
}
