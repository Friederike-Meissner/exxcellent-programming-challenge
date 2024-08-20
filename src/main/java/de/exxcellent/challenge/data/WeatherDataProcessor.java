package de.exxcellent.challenge.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.exxcellent.challenge.interfaces.DataProcessor;
import de.exxcellent.challenge.models.WeatherData;


public class WeatherDataProcessor implements DataProcessor {

    private List<WeatherData> allWeatherData = new ArrayList<>();
    private String[] columnsWithIntegerValues = {"Day","MxT","MnT"}; // for checking if they are integers
    private List<String> allColumnNames = new ArrayList<>();

    public void loadData(String path, String separator) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // to skip the first line (headlines)
            this.allColumnNames = Arrays.asList(line.split(separator));
            
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(separator);                
                checkIfLineValuesCanBeParsed(lineNumber, values, this.columnsWithIntegerValues, this.allColumnNames);
 
                WeatherData weatherData = new WeatherData(Integer.parseInt(values[getIndexOfColumn("Day", this.allColumnNames)]), Integer.parseInt(values[getIndexOfColumn("MnT", this.allColumnNames)]), Integer.parseInt(values[getIndexOfColumn("MxT", this.allColumnNames)]));

                this.allWeatherData.add(weatherData);

                lineNumber ++;
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
}