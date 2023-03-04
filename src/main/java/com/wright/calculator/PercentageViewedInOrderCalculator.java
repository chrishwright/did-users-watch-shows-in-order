package com.wright.calculator;

import com.wright.model.*;

import java.util.Map;

public class PercentageViewedInOrderCalculator {
    public static int getPercentageOfUsersWhoWatchedInOrder(UserToShowContainer userToShowContainer) {
        Map<Integer, UserViewings> userIdToUserViewingMap = userToShowContainer.getUserIdToUserViewingMap();

        int numUsersWatchedInOrder = 0;
        for (int userId : userIdToUserViewingMap.keySet()) {
            UserViewings userViewings = userIdToUserViewingMap.get(userId);
            if (ShowsWatchedInOrderCalculator.didUserWatchShowsInOrder(userViewings)) {
                numUsersWatchedInOrder++;
            }
        }

        int totalDistinctUsers = (int) userIdToUserViewingMap.keySet().stream().distinct().count();

        return (int)((numUsersWatchedInOrder / (double)totalDistinctUsers) * 100);
    }
}
