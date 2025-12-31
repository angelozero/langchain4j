package com.angelozero.langchain4j.service;


import java.util.*;

public class ChampionshipService {

    private static final List<String> CLUBS = Arrays.asList(
            "Corinthians", "Santos", "Flamengo", "Bahia", "Ponte Preta"
    );

    public static Map<String, String> generateRandomTable() {
        List<String> shuffledClubs = new ArrayList<>(CLUBS);
        Collections.shuffle(shuffledClubs);

        Map<String, String> table = new HashMap<>();

        // Mocked points and wins for the top 5 positions
        int[] points = {70, 68, 66, 62, 58};
        int[] wins = {21, 20, 19, 18, 17};

        for (int i = 0; i < shuffledClubs.size(); i++) {
            String stats = String.format("%dº place - %d points (%d wins)",
                    (i + 1), points[i], wins[i]);
            table.put(shuffledClubs.get(i).toLowerCase(), stats);
        }
        return table;
    }
}
