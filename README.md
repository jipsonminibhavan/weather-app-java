# Weather-App

Dieser Java-Code besteht aus drei Hauptklassen (Weather, WeatherFetcher und WeatherInfo), die zusammenarbeiten, 
um Wetterdaten für eine spezifizierte Stadt zu holen und anzuzeigen. Dieser Code demonstriert grundlegende OOP-Prinzipien,
Netzwerkoperationen mit APIs, XML-Parsing und das Singleton-Designmuster in Java.

- Klasse Weather
Hauptklasse: Enthält die main-Methode.
Benutzerinteraktion: Fordert den Benutzer auf, den Namen einer Stadt einzugeben, für die das Wetter abgefragt werden soll.
Datenanzeige: Zeigt die Wetterdaten in einem formatierten Format an, einschließlich Zeitstempel, Temperatur, Luftfeuchtigkeit und Luftdruck.

- Klasse WeatherFetcher
Singleton-Design: Implementiert das Singleton-Designmuster, um sicherzustellen, dass nur eine Instanz von WeatherFetcher existiert.
Wetterdaten-Abruf: Verwendet die OpenWeatherMap API, um Wetterdaten im XML-Format zu holen.
XML-Parsing: Verarbeitet die XML-Antwort von OpenWeatherMap und extrahiert relevante Wetterinformationen.

- Klasse WeatherInfo
Datenhaltung: Hält Informationen über das Wetter, einschließlich Zeitstempel, Temperatur, Luftfeuchtigkeit und Luftdruck.
Getter-Methoden: Stellt Methoden zur Verfügung, um auf diese Informationen zuzugreifen.

- Konfigurationsdatei
API-Schlüssel: Der API-Schlüssel für OpenWeatherMap wird in einer Konfigurationsdatei (config.properties) gespeichert und von WeatherFetcher geladen.

- Funktionsweise
Der Benutzer startet das Programm und gibt eine Stadt ein.
WeatherFetcher holt anhand des Stadtnamens und des API-Schlüssels Wetterdaten von OpenWeatherMap.
Die Daten werden geparst, in WeatherInfo-Objekte umgewandelt und an die main-Methode zurückgegeben.
Weather zeigt die Wetterinformationen formatiert an.
