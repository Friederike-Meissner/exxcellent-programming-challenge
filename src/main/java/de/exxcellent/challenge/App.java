package de.exxcellent.challenge;

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

        String type = args[0];
        String filePath = args[1];
        String separator = args[2];

        if ("--weather".equals(type)) {
            WeatherDataProcessor weatherDataProcessor = new WeatherDataProcessor();
            weatherDataProcessor.loadData(filePath, separator);
            int dayWithSmallestTempSpread = weatherDataProcessor.getDayWithSmallestTempSpread();
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        }

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
