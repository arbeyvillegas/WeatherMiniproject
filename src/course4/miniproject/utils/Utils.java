package course4.miniproject.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import course4.miniproject.aidl.WeatherData;
import course4.miniproject.jsonweather.WeatherJSONParser;
import course4.miniproject.jsonweather.JsonWeather;
import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * @class WeatherDownloadUtils
 *
 * @brief Handles the actual downloading of Weather information from
 *        the Weather web service.
 */
public class Utils {
    /**
     * Logging tag used by the debugger. 
     */
    private final static String TAG = Utils.class.getCanonicalName();
    
    private final static Map<String,JsonWeather> mCache=new HashMap<String,JsonWeather>();

    /** 
     * URL to the Weather web service.
     */
    private final static String sWeather_Web_Service_URL =
        "http://api.openweathermap.org/data/2.5/weather?q=";

    /**
     * Obtain the Weather information.
     * 
     * @return The information that responds to your current Weather search.
     */
    public static WeatherData getResult(final String city) {
    	WeatherData weatherData = getResultFromCache(city);
    	if(weatherData==null){
    		weatherData=getResultFromService(city);
    	}
    	return weatherData;
    }
    
    public static WeatherData getResultFromCache(String city){
    	WeatherData weatherData=null;
    	JsonWeather jsonWeather = null;
    	synchronized (mCache) {
    		if(mCache.containsKey(city)){
    			jsonWeather=mCache.get(city);
    			if(!jsonWeather.passedTenMin(new Date())){
    				Log.d(TAG, "get result from cache");
    				weatherData=createWeatherData(jsonWeather);
    			}else{
    				mCache.remove(city);
    			}
    		}
		}
    	return weatherData;
    }
    
    public static WeatherData getResultFromService(String city){
    	Log.d(TAG, "get result from service");
    	// Create a List that will return the WeatherData obtained
        // from the Weather Service web service.
        WeatherData weatherData = null;
            
        // A List of JsonWeather objects.
        JsonWeather jsonWeather = null;

        try {
            // Append the location to create the full URL.
            final URL url =
                new URL(sWeather_Web_Service_URL
                        + city +"&units=metric");

            // Opens a connection to the Weather Service.
            HttpURLConnection urlConnection =
                (HttpURLConnection) url.openConnection();
            
            // Sends the GET request and reads the Json results.
            try (InputStream in =
                 new BufferedInputStream(urlConnection.getInputStream())) {
                 // Create the parser.
                 final WeatherJSONParser parser =
                     new WeatherJSONParser();

                // Parse the Json results and create JsonWeather data
                // objects.
                jsonWeather = parser.parseJsonStream(in);
            } finally {
                urlConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // See if we parsed any valid data.
        if (jsonWeather != null) {
        	synchronized (mCache) {
        		mCache.put(city, jsonWeather);
			}
        	weatherData=createWeatherData(jsonWeather);        	
   
             // Return object WeatherData.
             return weatherData;
        }  else
            return null;
    }
    
    private static WeatherData createWeatherData(JsonWeather jsonWeather){
    	Log.d(TAG,"Nombre de jsonweather "+jsonWeather.getName());
    	WeatherData weatherData=new WeatherData(jsonWeather.getSys(), jsonWeather.getBase()
    			, jsonWeather.getMain(), jsonWeather.getWeather(), jsonWeather.getWind()
    			, jsonWeather.getDt(), jsonWeather.getId(), jsonWeather.getName(), jsonWeather.getCod());
    	return weatherData;
    }
    
    /**
     * This method is used to hide a keyboard after a user has
     * finished typing the url.
     */
    public static void hideKeyboard(Activity activity,
                                    IBinder windowToken) {
        InputMethodManager mgr =
           (InputMethodManager) activity.getSystemService
            (Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(windowToken,
                                    0);
    }

    /**
     * Show a toast message.
     */
    public static void showToast(Context context,
                                 String message) {
        Toast.makeText(context,
                       message,
                       Toast.LENGTH_SHORT).show();
    }

    /**
     * Ensure this class is only used as a utility.
     */
    private Utils() {
        throw new AssertionError();
    } 
}
