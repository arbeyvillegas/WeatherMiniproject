package course4.miniproject.jsonweather;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;

/**
 * Parses the Json weather data returned from the Weather Services API
 * and returns a List of JsonWeather objects that contain this data.
 */
public class WeatherJSONParser {
    /**
     * Used for logging purposes.
     */
    private final String TAG =
        this.getClass().getCanonicalName();

    /**
     * Parse the @a inputStream and convert it into a object of JsonWeather
     * class.
     */
    public JsonWeather parseJsonStream(InputStream inputStream)
    throws IOException {
    	try (JsonReader reader =
                new JsonReader(new InputStreamReader(inputStream,
                                                     "UTF-8"))) {
    		
    		 return parseJsonWeather(reader);
    	}
    }
    /*public List<JsonWeather> parseJsonStream(InputStream inputStream)
        throws IOException {
        // TODO -- you fill in here.
    	try (JsonReader reader =
                new JsonReader(new InputStreamReader(inputStream,
                                                     "UTF-8"))) {
    		
    		 return parseJsonWeatherArray(reader);
    	}
    }*/

   
   /* public List<JsonWeather> parseJsonWeatherArray(JsonReader reader)
        throws IOException {

        // TODO -- you fill in here.
    	return null; 
    }*/

    /**
     * Parse a Json stream and return a JsonWeather object.
     */
    public JsonWeather parseJsonWeather(JsonReader reader) 
        throws IOException {
    	JsonWeather jsonWeather=new JsonWeather(); 

        // TODO -- you fill in here.
    	reader.beginObject();
    	try{
    		while (reader.hasNext()) {
                String name = reader.nextName();
                switch (name) {
                case JsonWeather.cod_JSON:
                	jsonWeather.setCod(reader.nextLong());
                    Log.d(TAG, "reading cod " + jsonWeather.getCod());
                    break;
                case JsonWeather.base_JSON:
                	jsonWeather.setBase(reader.nextString());
                	break;
                case JsonWeather.dt_JSON:
                	jsonWeather.setDt(reader.nextLong());
                	break;
                case JsonWeather.id_JSON:
                	jsonWeather.setId(reader.nextLong());
                	break;
                case JsonWeather.main_JSON:
                	jsonWeather.setMain(parseMain(reader));
                	break;
                case JsonWeather.name_JSON:
                	jsonWeather.setName(reader.nextString());
                	break;
                case JsonWeather.sys_JSON:
                	jsonWeather.setSys(parseSys(reader));
                	break;
                case JsonWeather.weather_JSON:
                	jsonWeather.setWeather(parseWeathers(reader));
                	break;
                case JsonWeather.wind_JSON:
                	jsonWeather.setWind(parseWind(reader));
                	break;
                default:
                    reader.skipValue();
                    // Log.d(TAG, "ignoring " + name);
                    break;
                }
            } 
    	}finally{
    		reader.endObject();
    	}
    	return jsonWeather;
    }
    
    /**
     * Parse a Json stream and return a List of Weather objects.
     */
    public List<Weather> parseWeathers(JsonReader reader) throws IOException {
    	reader.beginArray();

        try {
            List<Weather> weathers = new ArrayList<Weather>();

            while (reader.hasNext()) 
            	weathers.add(parseWeather(reader));
            
            return weathers;
        } finally {
            reader.endArray();
        }
    }

    /**
     * Parse a Json stream and return a Weather object.
     */
    public Weather parseWeather(JsonReader reader) throws IOException {
        // TODO -- you fill in here.    
    	Weather weather=new Weather(); 

        // TODO -- you fill in here.
    	reader.beginObject();
    	try{
    		while (reader.hasNext()) {
                String name = reader.nextName();
                switch (name) {
                case Weather.description_JSON:
                	weather.setDescription(reader.nextString());
                    // Log.d(TAG, "reading lf " + acronym.getLongForm());
                    break;
                case Weather.icon_JSON:
                	weather.setIcon(reader.nextString());
                    // Log.d(TAG, "reading lf " + acronym.getLongForm());
                    break;
                case Weather.id_JSON:
                	weather.setId(reader.nextLong());
                    // Log.d(TAG, "reading lf " + acronym.getLongForm());
                    break;
                case Weather.main_JSON:
                	weather.setMain(reader.nextString());
                    // Log.d(TAG, "reading lf " + acronym.getLongForm());
                    break;
                default:
                    reader.skipValue();
                    // Log.d(TAG, "ignoring " + name);
                    break;
                }
            } 
    	}finally{
    		reader.endObject();
    	}
    	return weather; 
    }
    
    /**
     * Parse a Json stream and return a Main Object.
     */
    public Main parseMain(JsonReader reader) 
        throws IOException {
    	// TODO -- you fill in here.    
    	Main main=new Main(); 

        // TODO -- you fill in here.
    	reader.beginObject();
    	try{
    		while (reader.hasNext()) {
                String name = reader.nextName();
                switch (name) {
                case Main.grndLevel_JSON:
                	main.setGrndLevel(reader.nextDouble());
                    // Log.d(TAG, "reading lf " + acronym.getLongForm());
                    break;
                case Main.humidity_JSON:
                	main.setHumidity(reader.nextLong());
                	break;
                case Main.pressure_JSON:
                	main.setPressure(reader.nextDouble());
                	break;
                case Main.seaLevel_JSON:
                	main.setSeaLevel(reader.nextDouble());
                	break;
                case Main.temp_JSON:
                	main.setTemp(reader.nextDouble());
                	break;
                case Main.tempMax_JSON:
                	main.setTempMax(reader.nextDouble());
                	break;
                case Main.tempMin_JSON:
                	main.setTempMin(reader.nextDouble());
                	break;
                default:
                    reader.skipValue();
                    // Log.d(TAG, "ignoring " + name);
                    break;
                }
            } 
    	}finally{
    		reader.endObject();
    	}
    	return main;  
    }

    /**
     * Parse a Json stream and return a Wind Object.
     */
    public Wind parseWind(JsonReader reader) throws IOException {
    	// TODO -- you fill in here.    
    	Wind wind=new Wind(); 

        // TODO -- you fill in here.
    	reader.beginObject();
    	try{
    		while (reader.hasNext()) {
                String name = reader.nextName();
                switch (name) {
                case Wind.deg_JSON:
                	wind.setDeg(reader.nextDouble());
                    // Log.d(TAG, "reading lf " + acronym.getLongForm());
                    break;
                case Wind.speed_JSON:
                	wind.setSpeed(reader.nextDouble());
                    // Log.d(TAG, "reading lf " + acronym.getLongForm());
                    break;
                default:
                    reader.skipValue();
                    // Log.d(TAG, "ignoring " + name);
                    break;
                }
            } 
    	}finally{
    		reader.endObject();
    	}
    	return wind;
    }

    /**
     * Parse a Json stream and return a Sys Object.
     */
    public Sys parseSys(JsonReader reader) throws IOException {
    	Sys sys=new Sys(); 

        // TODO -- you fill in here.
    	reader.beginObject();
    	try{
    		while (reader.hasNext()) {
                String name = reader.nextName();
                switch (name) {
                case Sys.country_JSON:
                	sys.setCountry(reader.nextString());
                    // Log.d(TAG, "reading lf " + acronym.getLongForm());
                    break;
                case Sys.message_JSON:
                	sys.setMessage(reader.nextDouble());
                    // Log.d(TAG, "reading lf " + acronym.getLongForm());
                    break;
                case Sys.sunrise_JSON:
                	sys.setSunrise(reader.nextLong());
                    // Log.d(TAG, "reading lf " + acronym.getLongForm());
                    break;
                case Sys.sunset_JSON:
                	sys.setSunset(reader.nextLong());
                    // Log.d(TAG, "reading lf " + acronym.getLongForm());
                    break;
                default:
                    reader.skipValue();
                    // Log.d(TAG, "ignoring " + name);
                    break;
                }
            } 
    	}finally{
    		reader.endObject();
    	}
    	return sys; 
    }
}
