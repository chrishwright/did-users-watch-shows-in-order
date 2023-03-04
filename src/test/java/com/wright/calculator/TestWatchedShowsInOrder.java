package com.wright.calculator;

import com.wright.model.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestWatchedShowsInOrder {
    @Test
    public void testUserWatchedOneShowInOrder() {
        Show show = new Show();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        Episode newEp = new Episode(timestamp, episodeId, seasonId, showId, userId);
        show.addEpisodeToSeason(newEp);

        assertTrue(ShowsWatchedInOrderCalculator.wasShowWatchedInOrder(show));
    }

    @Test
    public void testUserWatchedOneShowOutOfOrder() {
        Show show = new Show();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 2;
        long timestamp = 1234;

        Episode newEp = new Episode(timestamp, episodeId, seasonId, showId, userId);
        show.addEpisodeToSeason(newEp);

        assertFalse(ShowsWatchedInOrderCalculator.wasShowWatchedInOrder(show));
    }

    @Test
    public void testUserWatchedMultipleEpisodesForShowInOrder() {
        Show show = new Show();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        Episode newEp = new Episode(timestamp, episodeId, seasonId, showId, userId);
        show.addEpisodeToSeason(newEp);

        timestamp = 2345;
        episodeId = 2;
        newEp = new Episode(timestamp, episodeId, seasonId, showId, userId);

        show.addEpisodeToSeason(newEp);

        assertTrue(ShowsWatchedInOrderCalculator.wasShowWatchedInOrder(show));
    }

    @Test
    public void testUserWatchedMultipleEpisodesInOrder() {
        Show show = new Show();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        Episode newEp = new Episode(timestamp, episodeId, seasonId, showId, userId);
        show.addEpisodeToSeason(newEp);

        timestamp = 2345;
        episodeId = 2;
        newEp = new Episode(timestamp, episodeId, seasonId, showId, userId);

        show.addEpisodeToSeason(newEp);

        timestamp = 3456;
        episodeId = 3;
        newEp = new Episode(timestamp, episodeId, seasonId, showId, userId);

        show.addEpisodeToSeason(newEp);

        assertTrue(ShowsWatchedInOrderCalculator.wasShowWatchedInOrder(show));
    }

    @Test
    public void testUserWatchedMultipleEpisodesOutOfOrder() {
        Show show = new Show();

        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        Episode newEp = new Episode(timestamp, episodeId, seasonId, showId, userId);
        show.addEpisodeToSeason(newEp);

        timestamp = 3456;
        episodeId = 2;
        newEp = new Episode(timestamp, episodeId, seasonId, showId, userId);

        show.addEpisodeToSeason(newEp);

        timestamp = 2345;
        episodeId = 3;
        newEp = new Episode(timestamp, episodeId, seasonId, showId, userId);

        show.addEpisodeToSeason(newEp);

        assertFalse(ShowsWatchedInOrderCalculator.wasShowWatchedInOrder(show));
    }
}
