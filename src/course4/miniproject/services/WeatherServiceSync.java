package course4.miniproject.services;

import java.util.ArrayList;
import java.util.List;

import course4.miniproject.aidl.WeatherCall;
import course4.miniproject.aidl.WeatherData;
import course4.miniproject.utils.Utils;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * @class WeatherServiceSync
 * 
 * @brief This class uses synchronous AIDL interactions to expand
 *        Weathers via an Weather Web service.  The WeatherActivity
 *        that binds to this Service will receive an IBinder that's an
 *        instance of WeatherCall, which extends IBinder.  The
 *        Activity can then interact with this Service by making
 *        two-way method calls on the WeatherCall object asking this
 *        Service to lookup the meaning of the Weather string.  After
 *        the lookup is finished, this Service sends the Weather
 *        results back to the Activity by returning a List of
 *        WeatherData.
 * 
 *        AIDL is an example of the Broker Pattern, in which all
 *        interprocess communication details are hidden behind the
 *        AIDL interfaces.
 */
public class WeatherServiceSync extends LifecycleLoggingService {
    /**
     * Factory method that makes an Intent used to start the
     * WeatherServiceSync when passed to bindService().
     * 
     * @param context
     *            The context of the calling component.
     */
    public static Intent makeIntent(Context context) {
        return new Intent(context,
                          WeatherServiceSync.class);
    }

    /**
     * Called when a client (e.g., WeatherActivity) calls
     * bindService() with the proper Intent.  Returns the
     * implementation of WeatherCall, which is implicitly cast as an
     * IBinder.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mWeatherCallImpl;
    }

    /**
     * The concrete implementation of the AIDL Interface WeatherCall,
     * which extends the Stub class that implements WeatherCall,
     * thereby allowing Android to handle calls across process
     * boundaries.  This method runs in a separate Thread as part of
     * the Android Binder framework.
     * 
     * This implementation plays the role of Invoker in the Broker
     * Pattern.
     */
    private final WeatherCall.Stub mWeatherCallImpl =
        new WeatherCall.Stub() {
            /**
             * Implement the AIDL WeatherCall expandWeather() method,
             * which forwards to DownloadUtils getResults() to obtain
             * the results from the Weather Web service and then
             * returns the results back to the Activity.
             */
            @Override
            public WeatherData getCurrentWeather(String cityName)
                throws RemoteException {

                // Call the Weather Web service to get the list of
                // possible expansions of the designated Weather.
                final WeatherData weatherResult = 
                    Utils.getResult(cityName);

                if (weatherResult != null) {
                    Log.d(TAG, ""
                          + " results for Weather: " 
                          + cityName);

                    // Return the list of Weather expansions back to the
                    // WeatherActivity.
                    return weatherResult;
                } else {
                    // Create a zero-sized WeatherResults object to
                    // indicate to the caller that the Weather had no
                    // expansions.
                    return null;
                }
            }
	};
}
