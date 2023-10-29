public class Display implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Display: Temperature is " + temperature + "°C, Humidity is " + humidity + "%, Pressure is " + pressure + " hPa");
    }
}
