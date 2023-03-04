package com.wright.model;

public class Episode {
    private final long timestamp;
    private final int episodeId;
    private final int seasonId;
    private final int showId;
    private final int userId;

    public Episode(long timestamp, int episodeId, int seasonId, int showId, int userId) {
        this.timestamp = validateGreaterThanZero(timestamp);
        this.episodeId = (int) validateGreaterThanZero(episodeId);
        this.seasonId = (int) validateGreaterThanZero(seasonId);
        this.showId = (int) validateGreaterThanZero(showId);
        this.userId = (int) validateGreaterThanZero(userId);
    }

    private long validateGreaterThanZero(long num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
        return num;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public int getShowId() {
        return showId;
    }

    public int getUserId() {
        return userId;
    }
}
