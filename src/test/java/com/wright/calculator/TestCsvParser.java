package com.wright.calculator;

import com.wright.model.*;
import com.wright.parser.CsvParser;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCsvParser {
    @Test
    public void testAddOneEpisode() {
        CsvParser csvParser = new CsvParser();
        UserToShowContainer userToShowContainer = csvParser.getAllUserEpisodeViewings("user-viewings-small.csv");
        final Map<Integer, UserViewings> userIdToUserViewingMap = userToShowContainer.getUserIdToUserViewingMap();

        long distinctUserCount = userIdToUserViewingMap.keySet().stream().distinct().count();

        final List<Show> showsForUser = userIdToUserViewingMap.get(1).getShowsForUser();
        Show show1 = showsForUser.get(0);

        final List<Season> seasons = show1.getAllSeasonsSorted();

        Season season1 = seasons.get(0);

        List<Episode> episodes = season1.getEpisodesSorted();

        assertEquals(1, distinctUserCount);
        assertEquals(season1.getSeasonNumber(), 1);
        assertEquals(4, episodes.size());
        assertEquals(1677760703000L, episodes.get(0).getTimestamp());
        assertEquals(1677807503000L, episodes.get(episodes.size() - 1).getTimestamp());
    }

    @Test
    public void testAddMultipleEpisodes() {
        CsvParser csvParser = new CsvParser();
        UserToShowContainer userToShowContainer = csvParser.getAllUserEpisodeViewings("user-viewings.csv");
        final Map<Integer, UserViewings> userIdToUserViewingMap = userToShowContainer.getUserIdToUserViewingMap();

        long distinctUserCount = userIdToUserViewingMap.keySet().stream().distinct().count();

        final List<Show> showsForUserOne = userIdToUserViewingMap.get(1).getShowsForUser();
        Show show1User1 = showsForUserOne.get(0);

        final List<Season> seasons = show1User1.getAllSeasonsSorted();

        Season season1User1 = seasons.get(0);
        Season season3User1 = seasons.get(2);

        List<Episode> season1Episodes = season1User1.getEpisodesSorted();
        List<Episode> season3Episodes = season3User1.getEpisodesSorted();

        assertEquals(6, distinctUserCount);
        assertEquals(season1User1.getSeasonNumber(), 1);
        assertEquals(season3User1.getSeasonNumber(), 3);
        assertEquals(4, season1Episodes.size());
        assertEquals(4, season3Episodes.size());
        assertEquals(1677865103000L, season3Episodes.get(0).getTimestamp());
        assertEquals(1677868103000L, season3Episodes.get(season3Episodes.size() - 1).getTimestamp());
    }
}
