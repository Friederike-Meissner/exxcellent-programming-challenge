package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.List;

import de.exxcellent.challenge.interfaces.DataProcessor;
import de.exxcellent.challenge.models.FootballData;


public class FootballDataProcessor implements DataProcessor {

    private List<FootballData> allFootballData = new ArrayList<>();

    public void loadData(String path, String separator) {
    }

    public String getTeamWithSmallestGoalSpread() {
        return "";
    }
}