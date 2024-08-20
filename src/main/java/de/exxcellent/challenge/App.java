package de.exxcellent.challenge;

import de.exxcellent.challenge.data.FootballDataProcessor;
import de.exxcellent.challenge.data.WeatherDataProcessor;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        String separator = ",";

        String type = args[0];
        String filePath = args[1];
        if (args.length == 3) {
            separator = args[2];
        }

        if ("--weather".equals(type)) {
            WeatherDataProcessor weatherDataProcessor = new WeatherDataProcessor();
            weatherDataProcessor.loadCSVData(filePath, separator);
            int dayWithSmallestTempSpread = weatherDataProcessor.getDayWithSmallestTempSpread();
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        }

        else if ("--football".equals(type)) {
            FootballDataProcessor footballDataProcessor = new FootballDataProcessor();
            footballDataProcessor.loadCSVData(filePath, separator);
            String teamWithSmallestGoalSpread = footballDataProcessor.getTeamWithSmallestGoalSpread();
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        }
    }
}
