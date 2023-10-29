public class FactoryPatternDemo {
    public static WeatherObserver createObserver(String observerType) {
        if ("Display".equalsIgnoreCase(observerType)) {
            return new Display();
        } else if ("StatisticsDisplay".equalsIgnoreCase(observerType)) {
            return new StatisticsDisplay();
        }
        return null;
    }
}
