package course4.miniproject.aidl;

import java.util.ArrayList;
import java.util.List;

import course4.miniproject.jsonweather.Main;
import course4.miniproject.jsonweather.Sys;
import course4.miniproject.jsonweather.Weather;
import course4.miniproject.jsonweather.Wind;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class is a Plain Old Java Object (POJO) used for data
 * transport within the Weather app. 
 * Parcelable defines an interface for marshaling/de-marshaling
 * https://en.wikipedia.org/wiki/Marshalling_(computer_science)
 * to/from a format that Android uses to allow data transport between
 * processes on a device.  Discussion of the details of Parcelable is
 * outside the scope of this assignment, but you can read more at
 * https://developer.android.com/reference/android/os/Parcelable.html.
 */
public class WeatherData implements Parcelable {
    /*
     * These data members are the local variables that will store the
     * WeatherData's state
     */

	public Sys mSys;
	public String mBase;
	public Main mMain;
	public List<Weather> mWeather = new ArrayList<Weather>();
	public Wind mWind;
	public long mDt;
	public long mId;
	public String mName;
	public long mCod;

    /**
     * Private constructor provided for the CREATOR interface, which
     * is used to de-marshal an WeatherData from the Parcel of data.
     */
    private WeatherData(Parcel in) {
    	mSys=(Sys)in.readValue(Sys.class.getClassLoader());
    	mBase=in.readString();
    	mMain=(Main)in.readValue(Main.class.getClassLoader());
    	in.readList(mWeather,Weather.class.getClassLoader());
    	//mWind=(Wind)in.readValue(Wind.class.getClassLoader());
        mDt=in.readLong();
        mId=in.readLong();
        mName=in.readString();
        mCod=in.readLong();
    }

    /**
     * Constructor that initializes an AcronymData object from
     * its parameters.
     */
    public WeatherData(Sys sys, String base, Main main
    		,List<Weather> weather,Wind wind,long dt
    		,long id,String name,long cod) {
        mSys = sys;
        mBase = base;
        mMain = main;
        mWeather=weather;
        mWind=wind;
        mDt=dt;
        mId=id;
        mName=name;
        mCod=cod;
    }

    /**
     * The toString() custom implementation.
     */
    @Override
    public String toString() {
        return "WeatherData [mBase=" 
            + mBase 
            + ", mName=" 
            + mName
            + ", mId=" 
            + mId 
            + "]";
    }

    /*
     * Parcelable related methods.
     */

    /**
     * A bitmask indicating the set of special object types marshaled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Marshal this WeatherData to the target Parcel.
     */
    @Override
    public void writeToParcel(Parcel dest,
                              int flags) {
    	dest.writeValue(mSys);
    	dest.writeString(mBase);
    	dest.writeValue(mMain);
    	dest.writeList(mWeather);
    	dest.writeValue(mWind);
    	dest.writeLong(mDt);
    	dest.writeLong(mId);
    	dest.writeString(mName);
    	dest.writeLong(mCod);
    }

    /**
     * public Parcelable.Creator for WeatherData, which is an
     * interface that must be implemented and provided as a public
     * CREATOR field that generates instances of your Parcelable class
     * from a Parcel.
     */
    public static final Parcelable.Creator<WeatherData> CREATOR =
        new Parcelable.Creator<WeatherData>() {
        public WeatherData createFromParcel(Parcel in) {
            return new WeatherData(in);
        }

        public WeatherData[] newArray(int size) {
            return new WeatherData[size];
        }
    };
}
