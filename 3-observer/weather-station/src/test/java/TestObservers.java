import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestObservers {

    @Test
    public void testThreeObservers() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }

    @Test
    public void testRemoveObserver() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(62, 90, 28.1f);
    }

    @Test
    void testCurrentConditionsDisplayUpdate() {
        // Arrange (Organizar)
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        

        // Act (Actuar)
        weatherData.setMeasurements(80.0f, 65.0f, 30.4f);

        // Assert (Verificar)
        assertEquals(80.0f, currentDisplay.getTemperature());
        assertEquals(65.0f, currentDisplay.getHumidity());
    }

}
