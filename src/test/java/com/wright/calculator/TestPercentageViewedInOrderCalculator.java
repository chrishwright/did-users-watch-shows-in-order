package com.wright.calculator;

import com.wright.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPercentageViewedInOrderCalculator {
    @Test
    public void testThatOneEpisodeWasWatchedInOrder() {
        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        Episode episodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        UserToShowContainer userToShowContainer = new UserToShowContainer();
        userToShowContainer.addFoundEpisodeToShow(episodeOne);

        int actual = PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(userToShowContainer);
        assertEquals(100, actual);
    }

    @Test
    public void testThatTwoEpisodeWasWatchedInOrder() {
        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        Episode episodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 2;
        timestamp = 2345;

        Episode episodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        UserToShowContainer userToShowContainer = new UserToShowContainer();
        userToShowContainer.addFoundEpisodeToShow(episodeOne);
        userToShowContainer.addFoundEpisodeToShow(episodeTwo);

        int actual = PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(userToShowContainer);
        assertEquals(100, actual);
    }

    @Test
    public void testThatTwoUsersWatchedInOrder() {
        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        Episode userOneEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 2;
        timestamp = 2345;

        Episode userOneEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        userId = 2;
        episodeId = 1;
        timestamp = 1234;

        Episode userTwoEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 2;
        timestamp = 2345;

        Episode userTwoEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        UserToShowContainer userToShowContainer = new UserToShowContainer();
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userTwoEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userTwoEpisodeTwo);

        int actual = PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(userToShowContainer);
        assertEquals(100, actual);
    }

    @Test
    public void testThatOneOfTwoUsersWatchedInOrder() {
        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        Episode userOneEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 2;
        timestamp = 2345;

        Episode userOneEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        userId = 2;
        timestamp = 1234;

        Episode userTwoEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 1;
        timestamp = 2345;

        Episode userTwoEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        UserToShowContainer userToShowContainer = new UserToShowContainer();
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userTwoEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userTwoEpisodeTwo);

        int actual = PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(userToShowContainer);
        assertEquals(50, actual);
    }

    @Test
    public void testThatOneOfThreeUsersWatchedInOrder() {
        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        Episode userOneEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 2;
        timestamp = 2345;

        Episode userOneEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        userId = 2;
        timestamp = 1234;

        Episode userTwoEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 1;
        timestamp = 2345;

        Episode userTwoEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        userId = 3;
        episodeId = 2;
        timestamp = 1234;

        Episode userThreeEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 1;
        timestamp = 2345;

        Episode userThreeEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        UserToShowContainer userToShowContainer = new UserToShowContainer();
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userTwoEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userTwoEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userThreeEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userThreeEpisodeTwo);

        int actual = PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(userToShowContainer);
        assertEquals(33, actual);
    }

    @Test
    public void testThatOneUsersWatchedInOrderListOutOfOrder() {
        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 1234;

        Episode userOneEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 2;
        timestamp = 2345;

        Episode userOneEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        UserToShowContainer userToShowContainer = new UserToShowContainer();
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeOne);

        int actual = PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(userToShowContainer);
        assertEquals(100, actual);
    }

    @Test
    public void testThatOneUsersWatchedInOrderListOutOfOrderForSeason() {
        int userId = 1;
        int showId = 1;
        int seasonId = 2;
        int episodeId = 1;
        long timestamp = 2345;

        Episode userOneEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        seasonId = 1;
        timestamp = 1234;

        Episode userOneEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        UserToShowContainer userToShowContainer = new UserToShowContainer();
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeOne);

        int actual = PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(userToShowContainer);
        assertEquals(100, actual);
    }

    @Test
    public void testThatOneUsersWatchedOutOfOrderListOutOfOrderForSeason() {
        int userId = 1;
        int showId = 1;
        int seasonId = 1;
        int episodeId = 1;
        long timestamp = 2345;

        Episode userOneEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        seasonId = 2;
        timestamp = 1234;

        Episode userOneEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        UserToShowContainer userToShowContainer = new UserToShowContainer();
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userOneEpisodeOne);

        int actual = PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(userToShowContainer);
        assertEquals(0, actual);
    }

    @Test
    public void testThatUsersWatchedInOrder() {
        int userId = 1;
        int showId = 1;
        int seasonId = 2;
        int episodeId = 2;
        long timestamp = 6789;

        Episode userSeasonTwoEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 1;
        timestamp = 5678;

        Episode userSeasonTwoEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 2;
        timestamp = 2345;
        seasonId = 1;

        Episode userSeasonOneEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 1;
        timestamp = 1234;

        Episode userSeasonOneEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);


        UserToShowContainer userToShowContainer = new UserToShowContainer();
        userToShowContainer.addFoundEpisodeToShow(userSeasonTwoEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userSeasonTwoEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userSeasonOneEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userSeasonOneEpisodeOne);

        int actual = PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(userToShowContainer);
        assertEquals(100, actual);
    }

    @Test
    public void testThatUsersWatchedOutOfOrder() {
        int userId = 1;
        int showId = 1;
        int seasonId = 2;
        int episodeId = 2;
        long timestamp = 6789;

        Episode userSeasonTwoEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 1;
        timestamp = 2345;

        Episode userSeasonTwoEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 2;
        timestamp = 3456;
        seasonId = 1;

        Episode userSeasonOneEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 1;
        timestamp = 1234;

        Episode userSeasonOneEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);


        UserToShowContainer userToShowContainer = new UserToShowContainer();
        userToShowContainer.addFoundEpisodeToShow(userSeasonTwoEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userSeasonTwoEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userSeasonOneEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userSeasonOneEpisodeOne);

        int actual = PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(userToShowContainer);
        assertEquals(0, actual);
    }

    @Test
    public void testThatSomeUsersWatchedInOrder() {
        int userId = 1;
        int showId = 1;
        int seasonId = 2;
        int episodeId = 2;
        long timestamp = 6789;

        Episode userSeasonTwoEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 1;
        timestamp = 2345;

        Episode userSeasonTwoEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 2;
        timestamp = 3456;
        seasonId = 1;

        Episode userSeasonOneEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 1;
        timestamp = 1234;

        Episode userSeasonOneEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        userId = 2;

        Episode userTwoSeasonOneEpisodeOne = new Episode(timestamp, episodeId, seasonId, showId, userId);

        episodeId = 2;
        timestamp = 2345;

        Episode userTwoSeasonOneEpisodeTwo = new Episode(timestamp, episodeId, seasonId, showId, userId);


        UserToShowContainer userToShowContainer = new UserToShowContainer();
        userToShowContainer.addFoundEpisodeToShow(userSeasonTwoEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userSeasonTwoEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userSeasonOneEpisodeTwo);
        userToShowContainer.addFoundEpisodeToShow(userSeasonOneEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userTwoSeasonOneEpisodeOne);
        userToShowContainer.addFoundEpisodeToShow(userTwoSeasonOneEpisodeTwo);

        int actual = PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(userToShowContainer);
        assertEquals(50, actual);
    }
}
