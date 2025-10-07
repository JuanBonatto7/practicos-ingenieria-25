public class actuallyTemperatureDisplay implements Observer, DisplayElement {
    private float actuallyTemperature;
    private WeatherData weatherData;

    public actuallyTemperatureDisplay( WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        actuallyTemperature = temp;

		display();
	}
    
    	public void display() {
		System.out.print("Temperature: " + actuallyTemperature);
		
	}

    public float  getTemperature(){
        return actuallyTemperature;
    }

}
