package de.exxcellent.challenge;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.data.FootballDataProcessor;
import de.exxcellent.challenge.data.WeatherDataProcessor;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    // private String successLabel = "not successful";

    @BeforeEach
    void setUp() {
        // successLabel = "successful";
    }

    // @Test
    // void aPointlessTest() {
    //     assertEquals("successful", successLabel, "My expectations were not met");
    // }

    @Test
    void shouldGetDayWithSmallestTempSpread() {

        WeatherDataProcessor weatherDataProcessor = new WeatherDataProcessor();
        weatherDataProcessor.loadCSVData(Paths.get("src/test/java/testResources/wheaterTest.csv").toString(), ",");
        int dayWithSmallestTempSpread = weatherDataProcessor.getDayWithSmallestTempSpread();

        assertEquals(2, dayWithSmallestTempSpread, "Did not find the day with the smallest temperature spread.");
    }

    @Test
    void shouldBePossibleToUseAnotherSeparatorForCSV() {

        WeatherDataProcessor weatherDataProcessor = new WeatherDataProcessor();
        weatherDataProcessor.loadCSVData(Paths.get("src/test/java/testResources/wheaterTestWithOtherSeparator.csv").toString(), ";");
        int dayWithSmallestTempSpread = weatherDataProcessor.getDayWithSmallestTempSpread();

        assertEquals(2, dayWithSmallestTempSpread, "Did not find the day with the smallest temperature spread.");
    }

    @Test
    void shouldThrowAnErrorIfAValueCanNotBeParsedToInteger() {
        WeatherDataProcessor weatherDataProcessor = new WeatherDataProcessor();
        try {
            weatherDataProcessor.loadCSVData(Paths.get("src/test/java/testResources/wheaterTestWithNotNumericValue.csv").toString(), ",");
            fail("Expected an Error to be thrown");
        } catch (Error e) {
            assertEquals("Column MxT in line 1 should be an integer.", e.getMessage());
        } 
    }

    @Test
    void shouldGetTheFootballTeamWithSmallestGoalsSpread() {

        FootballDataProcessor footballDataProcessor = new FootballDataProcessor();
        footballDataProcessor.loadCSVData(Paths.get("src/test/java/testResources/footballTest.csv").toString(), ",");
        String teamWithSmallestGoalSpread = footballDataProcessor.getTeamWithSmallestGoalSpread();

        assertEquals("Leeds", teamWithSmallestGoalSpread, "Did not find the team with the smallest goal spread.");
    }

    @Test
    void runWeather() {
        App.main("--weather", Paths.get("src/main/resources/de/exxcellent/challenge/weather.csv").toString());
    }

    @Test
    void runFootball() {
        App.main("--football", Paths.get("src/main/resources/de/exxcellent/challenge/football.csv").toString());
    }

    @Test
    void runWeatherWithSeparator() {
        App.main("--weather", Paths.get("src/main/resources/de/exxcellent/challenge/weather.csv").toString(), ",");
    }

    @Test
    void runFootballWithSeparator() {
        App.main("--football", Paths.get("src/main/resources/de/exxcellent/challenge/football.csv").toString(), ",");
    }


}