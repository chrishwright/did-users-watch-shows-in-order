package com.wright.parser;

import com.wright.model.Episode;
import com.wright.model.UserToShowContainer;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class CsvParser {
    private static final String COMMA_DELIMITER = ",";
    private final UserToShowContainer userToShowContainer;

    public CsvParser() {
        userToShowContainer = new UserToShowContainer();
    }

    public UserToShowContainer getAllUserEpisodeViewings(String fileName) {
        try {
            this.parseCsv(fileName);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return this.userToShowContainer;
    }

    private void parseCsv(String fileName) throws IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }

        File file = new File(resource.toURI());

        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        // Remove header of CSV
        lines.remove(0);

        for (String line : lines) {
            String[] values = line.split(COMMA_DELIMITER);

            int userId = Integer.parseInt(values[0]);
            int showId = Integer.parseInt(values[1]);
            int seasonId = Integer.parseInt(values[2]);
            int episodeId = Integer.parseInt(values[3]);
            long timestamp = Long.parseLong(values[4]);

            Episode episode = new Episode(timestamp, episodeId, seasonId, showId, userId);
            userToShowContainer.addFoundEpisodeToShow(episode);
        }
    }
}
