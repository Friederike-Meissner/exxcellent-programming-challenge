package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.exxcellent.challenge.interfaces.DataProcessor;
import de.exxcellent.challenge.models.FootballData;


public class FootballDataProcessor implements DataProcessor {

    private List<FootballData> allFootballData = new ArrayList<>();
    private String[] columnsWithIntegerValues = {"Goals","Goals Allowed"}; // for checking if they are integers
    private List<String> allColumnNames = new ArrayList<>();

    public void loadData(String path, String separator) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // to skip the first line (headlines)
            this.allColumnNames = Arrays.asList(line.split(separator));
            
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(separator);                
                checkIfLineValuesCanBeParsed(lineNumber, values, this.columnsWithIntegerValues, this.allColumnNames);
 
                FootballData footballData = new FootballData(values[getIndexOfColumn("Team", this.allColumnNames)], Integer.parseInt(values[getIndexOfColumn("Goals", this.allColumnNames)]), Integer.parseInt(values[getIndexOfColumn("Goals Allowed", this.allColumnNames)]));

                this.allFootballData.add(footballData);

                lineNumber ++;
            }
        }

        catch (Exception e) {
            e.getMessage();
        }   
    }

    public String getTeamWithSmallestGoalSpread() {
        FootballData weatherDataWithSmallestTempSpread = null;      

        for (FootballData weatherData : this.allFootballData) {
            if (weatherDataWithSmallestTempSpread == null || weatherData.getGoalSpread() < weatherDataWithSmallestTempSpread.getGoalSpread()) {
                weatherDataWithSmallestTempSpread = weatherData;
            }
        }

        return weatherDataWithSmallestTempSpread.getTeam();
    }
}