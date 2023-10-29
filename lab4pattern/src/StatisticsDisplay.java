public class StatisticsDisplay implements WeatherObserver {
    private float maxTemperature = -Float.MAX_VALUE;
    private float minTemperature = Float.MAX_VALUE;
    private float temperatureSum = 0;
    private int numReadings = 0;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        temperatureSum += temperature;
        numReadings++;

        if (temperature > maxTemperature) {
            maxTemperature = temperature;
        }

        if (temperature < minTemperature) {
            minTemperature = temperature;
        }

        float averageTemperature = temperatureSum / numReadings;
        System.out.println("Statistics Display: Avg/Max/Min Temperature = " + averageTemperature + "°C/" + maxTemperature + "°C/" + minTemperature + "°C");
    }
}
