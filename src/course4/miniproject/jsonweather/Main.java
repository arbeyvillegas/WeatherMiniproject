package course4.miniproject.jsonweather;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * This "Plain Ol' Java Object" (POJO) class represents data related
 * to temperature, pressure, and humidity downloaded in Json from the
 * Weather Service.
 */
public class Main implements Parcelable {
    /**
     * Various tags corresponding to temperature, pressure, and
     * humidity data downloaded in Json from the Weather Service.
     */
    public final static String temp_JSON = "temp";
    public final static String tempMin_JSON = "tempMin";
    public final static String tempMax_JSON = "tempMax";
    public final static String pressure_JSON = "pressure";
    public final static String seaLevel_JSON = "seaLevel";
    public final static String grndLevel_JSON = "grndLevel";
    public final static String humidity_JSON = "humidity";

    /**
     * Various fields corresponding to temperature, pressure, and
     * humidity data downloaded in Json from the Weather Service.
     */
    private double mTemp;
    private double mTempMin;
    private double mTempMax;
    private double mPressure;
    private double mSeaLevel;
    private double mGrndLevel;
    private long mHumidity;

    public Main(Parcel in){
    	mTemp=in.readDouble();
    	mTempMin=in.readDouble();
    	mTempMax=in.readDouble();
    	mPressure=in.readDouble();
    	mSeaLevel=in.readDouble();
    	mGrndLevel=in.readDouble();
    	mHumidity=in.readLong();
    }
    
    /**
     * @return The temperature
     */
    public double getTemp() {
        return mTemp;
    }

    /**
     * @param temp
     *            The temp
     */
    public void setTemp(double temp) {
        mTemp = temp;
    }

    /**
     * @return The tempMin
     */
    public double getTempMin() {
        return mTempMin;
    }

    /**
     * @param tempMin
     *            The temp_min
     */
    public void setTempMin(double tempMin) {
        mTempMin = tempMin;
    }

    /**
     * @return The tempMax
     */
    public double getTempMax() {
        return mTempMax;
    }

    /**
     * @param tempMax
     *            The temp_max
     */
    public void setTempMax(double tempMax) {
        mTempMax = tempMax;
    }

    /**
     * @return The pressure
     */
    public double getPressure() {
        return mPressure;
    }

    /**
     * @param pressure
     *            The pressure
     */
    public void setPressure(double pressure) {
        mPressure = pressure;
    }

    /**
     * @return The seaLevel
     */
    public double getSeaLevel() {
        return mSeaLevel;
    }

    /**
     * @param seaLevel
     *            The sea_level
     */
    public void setSeaLevel(double seaLevel) {
        mSeaLevel = seaLevel;
    }

    /**
     * @return The grndLevel
     */
    public double getGrndLevel() {
        return mGrndLevel;
    }

    /**
     * @param grndLevel
     *            The grnd_level
     */
    public void setGrndLevel(double grndLevel) {
        mGrndLevel = grndLevel;
    }

    /**
     * @return The humidity
     */
    public long getHumidity() {
        return mHumidity;
    }

    /**
     * @param humidity
     *            The humidity
     */
    public void setHumidity(long humidity) {
        mHumidity = humidity;
    }

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeDouble(mTemp);
		dest.writeDouble(mTempMin);
		dest.writeDouble(mTempMax);
		dest.writeDouble(mPressure);
		dest.writeDouble(mSeaLevel);
		dest.writeDouble(mGrndLevel);
		dest.writeLong(mHumidity);
	}
	
	
    public static final Parcelable.Creator<Main> CREATOR =
        new Parcelable.Creator<Main>() {
        public Main createFromParcel(Parcel in) {
            return new Main(in);
        }

        public Main[] newArray(int size) {
            return new Main[size];
        }
    };
}
