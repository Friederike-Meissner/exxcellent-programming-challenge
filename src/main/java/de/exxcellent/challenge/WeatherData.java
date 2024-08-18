package de.exxcellent.challenge;

public class WeatherData {
    private int day;
    private int minTemp;
    private int maxTemp;

    public WeatherData(int day, int minTemp, int maxTemp) {
        this.day = day;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }  

    public int getDay() {
        return this.day;
    } 

    public int getMinTemp() {
        return this.minTemp;
    } 

    public int getMaxTemp() {
        return this.maxTemp;
    } 
}
