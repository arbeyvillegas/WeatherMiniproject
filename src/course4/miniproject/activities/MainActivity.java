package course4.miniproject.activities;

import course4.miniproject.operations.WeatherOps;
import course4.miniproject.operations.WeatherOpsImpl;
import course4.miniproject.utils.RetainedFragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import course4.miniproject.R;
import android.widget.Button;
import android.view.View.OnClickListener;

/**
 * The main Activity that prompts the user for Weathers to expand via
 * various implementations of WeatherServiceSync and
 * WeatherServiceAsync and view via the results.  Extends
 * LifecycleLoggingActivity so its lifecycle hook methods are logged
 * automatically.
 */
public class MainActivity extends LifecycleLoggingActivity {
    /**
     * Used to retain the ImageOps state between runtime configuration
     * changes.
     */
    protected final RetainedFragmentManager mRetainedFragmentManager = 
        new RetainedFragmentManager(this.getFragmentManager(),
                                    TAG);

    /**
     * Provides Weather-related operations.
     */
    private WeatherOps mWeatherOps;

    /**
     * Hook method called when a new instance of Activity is created.
     * One time initialization code goes here, e.g., runtime
     * configuration changes.
     *
     * @param Bundle object that contains saved state information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Always call super class for necessary
        // initialization/implementation.
        super.onCreate(savedInstanceState);

        // Create the WeatherOps object one time.
        mWeatherOps = new WeatherOpsImpl(this);

        // Handle any configuration change.
        handleConfigurationChanges();
        
        Button btnAsync = (Button) findViewById(R.id.btnAsync);
        btnAsync.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 Log.d(TAG,
		                  "Click Async");
				 expandWeatherAsync(v);
			}
		});
        
        Button btnSync = (Button) findViewById(R.id.btnSync);
        btnSync.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 Log.d(TAG,
						 "Click Sync");
				 expandWeatherSync(v);
			}
		});
    }

    /**
     * Hook method called by Android when this Activity is
     * destroyed.
     */
    @Override
    protected void onDestroy() {
        // Unbind from the Service.
        mWeatherOps.unbindService();

        // Always call super class for necessary operations when an
        // Activity is destroyed.
        super.onDestroy();
    }

    /**
     * Handle hardware reconfigurations, such as rotating the display.
     */
    protected void handleConfigurationChanges() {
        // If this method returns true then this is the first time the
        // Activity has been created.
        if (mRetainedFragmentManager.firstTimeIn()) {
            Log.d(TAG,
                  "First time onCreate() call");

            // Create the WeatherOps object one time.  The "true"
            // parameter instructs WeatherOps to use the
            // DownloadImagesBoundService.
            mWeatherOps = new WeatherOpsImpl(this);

            // Store the WeatherOps into the RetainedFragmentManager.
            mRetainedFragmentManager.put("Weather_OPS_STATE",
                                         mWeatherOps);
            
            // Initiate the service binding protocol (which may be a
            // no-op, depending on which type of DownloadImages*Service is
            // used).
            mWeatherOps.bindService();
        } else {
            // The RetainedFragmentManager was previously initialized,
            // which means that a runtime configuration change
            // occured.

            Log.d(TAG,
                  "Second or subsequent onCreate() call");

            // Obtain the WeatherOps object from the
            // RetainedFragmentManager.
            mWeatherOps = 
                mRetainedFragmentManager.get("Weather_OPS_STATE");

            // This check shouldn't be necessary under normal
            // circumtances, but it's better to lose state than to
            // crash!
            if (mWeatherOps == null) {
                // Create the WeatherOps object one time.  The "true"
                // parameter instructs WeatherOps to use the
                // DownloadImagesBoundService.
                mWeatherOps = new WeatherOpsImpl(this);

                // Store the WeatherOps into the RetainedFragmentManager.
                mRetainedFragmentManager.put("Weather_OPS_STATE",
                                             mWeatherOps);

                // Initiate the service binding protocol (which may be
                // a no-op, depending on which type of
                // DownloadImages*Service is used).
                mWeatherOps.bindService();
            } else
                // Inform it that the runtime configuration change has
                // completed.
                mWeatherOps.onConfigurationChange(this);
        }
    }

    /*
     * Initiate the synchronous Weather lookup when the user presses
     * the "Look Up Sync" button.
     */
    public void expandWeatherSync(View v) {
        mWeatherOps.getCurrentWeatherSync(v);
    }

    /*
     * Initiate the asynchronous Weather lookup when the user presses
     * the "Look Up Async" button.
     */
    public void expandWeatherAsync(View v) {
        mWeatherOps.getCurrentWeatherAsync(v);
    }
}
