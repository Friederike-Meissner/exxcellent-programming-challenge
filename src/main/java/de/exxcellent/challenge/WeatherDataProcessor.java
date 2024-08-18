package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WeatherDataProcessor {

    private List<WeatherData> allWeatherData = new ArrayList<>();
    private String[] columnsWithIntegerValues = {"Day","MxT","MnT"}; // for checking if they are integers
    private List<String> columnNames = new ArrayList<>();

    public void loadData(String path, String separator) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // to skip the first line (headlines)
            this.columnNames = Arrays.asList(line.split(separator));
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(separator);


                WeatherData weatherData = new WeatherData(Integer.parseInt(values[getIndexOfColumn("Day")]), Integer.parseInt(values[getIndexOfColumn("MnT")]), Integer.parseInt(values[getIndexOfColumn("MxT")]));

                this.allWeatherData.add(weatherData);
            }
        }

        catch (Exception e) {
            e.getMessage();
        }    
    }

    public int getDayWithSmallestTempSpread() {
        WeatherData weatherDataWithSmallestTempSpread = null;      

        for (WeatherData weatherData : this.allWeatherData) {
            if (weatherDataWithSmallestTempSpread == null || weatherData.getTempSpread() < weatherDataWithSmallestTempSpread.getTempSpread()) {
                weatherDataWithSmallestTempSpread = weatherData;
            }
        }

        return weatherDataWithSmallestTempSpread.getDay();
    }

    public int getIndexOfColumn(String SearchdeColumnName) {
        // is used in case the order of columns in the csv changed
        return this.columnNames.indexOf(SearchdeColumnName);
    }
}