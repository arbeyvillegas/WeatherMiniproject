package course4.miniproject.aidl;

import course4.miniproject.aidl.WeatherData;
import java.util.List;

/**
 * Interface defining the method that receives callbacks from the
 * AcronymServiceAsync.
 */
interface WeatherResults {
    /**
     * This one-way (non-blocking) method allows WeatherServiceAsync
     * to return the List of WeatherData results associated with a
     * one-way AcronymRequest.callAcronymRequest() call.
     */
    oneway void sendResult(in WeatherData result);

    /**
     * This one-way (non-blocking) method allows WeatherServiceAsync
     * to return an error String if the Service fails for some reason.
     */
    oneway void sendError(in String reason);
}
