import java.util.Scanner;

public class Weather {
    
	public static void main(String[] args) throws Exception {
		
System.out.println("Für welche Stadt soll das Wetter abgefragt werden?");
		
		Scanner input = new Scanner(System.in);
		String city = input.next();
		
		System.out.println("Wetter wird für folgende Stadt abgefragt: " + city);
		
        WeatherFetcher w = WeatherFetcher.getInstance();

        WeatherInfo[] weatherInfos = w.fetch(city);

        System.out.printf("%-20s %-15s %-20s %-15s\n", "Zeitstempel", "Temperatur", "Luftfeuchtigkeit", "Luftdruck");
        for (WeatherInfo weatherInfo : weatherInfos) {
            System.out.printf("%-20s %-15s %-20s %-15s\n", weatherInfo.getTimestamp(), weatherInfo.getTemperature(), weatherInfo.getHumidity(), weatherInfo.getPressure());
        }

    }
}
