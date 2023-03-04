package com.wright;

import com.wright.calculator.PercentageViewedInOrderCalculator;
import com.wright.model.UserToShowContainer;
import com.wright.parser.CsvParser;

public class App {
    public static void main(String[] args) {
        CsvParser csvParser = new CsvParser();
        final UserToShowContainer allUserEpisodeViewings = csvParser.getAllUserEpisodeViewings("user-viewings.csv");

        int percentage =
                PercentageViewedInOrderCalculator.getPercentageOfUsersWhoWatchedInOrder(allUserEpisodeViewings);
        System.out.printf("%n%d%% of users watched TV programs in order.%n", percentage);
    }
}
