package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class WeatherDataProcessor {

    private List<WeatherData> allWeatherData = new ArrayList<>();

    public void loadData(String path, String separator) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // to skip the first line (headlines)

            while ((line = br.readLine()) != null) {
                String[] values = line.split(separator);
                WeatherData weatherData = new WeatherData(Integer.parseInt(values[0]), Integer.parseInt(values[2]), Integer.parseInt(values[1]));

                allWeatherData.add(weatherData);
            }
        }

        catch (Exception e) {
            e.getMessage();
        }    
    }

    public int getDayWithSmallestTempSpread() {
        return 0;
    }
}