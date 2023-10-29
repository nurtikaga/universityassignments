import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        // Register observers using the factory
        WeatherObserver display = FactoryPatternDemo.createObserver("Display");
        WeatherObserver statisticsDisplay = FactoryPatternDemo.createObserver("StatisticsDisplay");

        weatherStation.registerObserver(display);
        weatherStation.registerObserver(statisticsDisplay);

        // Simulate weather data changes
        weatherStation.setWeatherData(25.5f, 60.0f, 1013.2f);
        weatherStation.setWeatherData(24.5f, 58.5f, 1012.5f);
    }
}
