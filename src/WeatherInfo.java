
public class WeatherInfo {
	
	private String timestamp;
	private String temperature;
	private String humidity;
	private String pressure;
	
	WeatherInfo(String timestamp, String temperature, String humidity, String pressure) {
		
		this.timestamp = timestamp;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public String getTemperature() {
		return temperature;
	}
	
	public String getHumidity() {
		return humidity;
	}
	
	public String getPressure() {
		return pressure;
	}
	
	
}
