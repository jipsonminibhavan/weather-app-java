import java.io.InputStream;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherFetcher {

	private static WeatherFetcher  instance;


	private WeatherFetcher() {
	
}

    public static WeatherFetcher  getInstance() {
	    if (instance == null) {
		     instance = new WeatherFetcher ();
	} 
	  return instance;
	  
}
    public WeatherInfo[] fetch(String city)throws Exception {
    	
    	Properties prop = new Properties();
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
        prop.load(input);
        String apiKey = prop.getProperty("openweathermap.api.key");

        String uri = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&mode=xml&units=metric&appid=" + apiKey;

		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder  = factory.newDocumentBuilder();
		
		Document document= documentBuilder.parse(uri);
		
		NodeList times = document.getElementsByTagName("time");
		
		WeatherInfo[] weatherInfos = new WeatherInfo[times.getLength()];
		
		for(int x=0; x < times.getLength(); x++) {
			
			Node time = times.item(x);
			NamedNodeMap timeAttribute =  time.getAttributes();
			String timestamp = timeAttribute.getNamedItem("from").getNodeValue();
			
			String temperature = null;
	        String humidity = null;
	        String pressure = null;
			
			NodeList children = time.getChildNodes();
			for(int y=0; y < children.getLength(); y++) {
				
				Node child = children.item(y);
				
				switch (child.getNodeName()) {
				
				case "temperature":
				 temperature = child.getAttributes().getNamedItem("value").getNodeValue() + " °C";
				    break;
				    
				
				case "humidity": 
				   humidity = child.getAttributes().getNamedItem("value").getNodeValue() + " %";
				     break;
				   
			   
	            
				case "pressure":
	              pressure = child.getAttributes().getNamedItem("value").getNodeValue() + " hPa";
	                 break;
	                

			}
			
		}
		
			 weatherInfos[x] = new WeatherInfo(timestamp, temperature, humidity, pressure);
	    }
		
	
		return weatherInfos;
    

}}
