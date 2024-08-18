package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        weatherDataProcessor.loadData("/home/rike/programming-challenge/src/test/java/testResources/wheaterTest.csv", ",");
        int dayWithSmallestTempSpread = weatherDataProcessor.getDayWithSmallestTempSpread();

        assertEquals(2, dayWithSmallestTempSpread, "Did not find the day with the smallest temperature spread.");
    }


    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

}