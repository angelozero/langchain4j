package com.angelozero.langchain4j.service;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AssistantTools {

    @Tool("Fetches the current ranking, points, and performance of a specific team in the Brazilian Fifa Cup.")
    public String getTeamRanking(String teamName) {
        Map<String, String> currentTable = ChampionshipService.generateRandomTable();
        String teamKey = teamName.toLowerCase().trim();

        if (currentTable.containsKey(teamKey)) {
            return String.format("Performance Analysis: %s is currently in %s.",
                    teamName, currentTable.get(teamKey));
        }

        return "I couldn't find recent data for " + teamName + " in the Série A standings.";
    }

    @Tool("Returns the list of the top 3 teams currently leading the championship.")
    public String getChampionshipLeaders() {
        Map<String, String> currentTable = ChampionshipService.generateRandomTable();

        String leaders = currentTable.entrySet().stream()
                .filter(e -> e.getValue().contains("1º") || e.getValue().contains("2º") || e.getValue().contains("3º"))
                .sorted(Map.Entry.comparingByValue())
                .map(e -> {
                    String capitalizedTeam = e.getKey().substring(0, 1).toUpperCase() + e.getKey().substring(1);
                    return String.format("%s (%s)", capitalizedTeam, e.getValue());
                })
                .collect(Collectors.joining(", "));

        return "The current leaders are: " + leaders;
    }
}
