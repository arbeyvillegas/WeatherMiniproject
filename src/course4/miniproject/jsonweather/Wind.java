package course4.miniproject.jsonweather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This "Plain Ol' Java Object" (POJO) class represents system data downloaded
 * in Json from the Wind Service.
 */
public class Wind implements Parcelable {
	/**
	 * Various tags corresponding to system data downloaded in Json from the
	 * Wind Service.
	 */
	public final static String speed_JSON = "speed";
	public final static String deg_JSON = "deg";

	/**
	 * Various fields corresponding to system data downloaded in Json from the
	 * Wind Service.
	 */
	private double mSpeed;
    private double mDeg;
	
	public Wind()
	{}
	
	public Wind(Parcel in) {
		mSpeed=in.readDouble();
    	mDeg=in.readDouble();
	}
/**
     * @return The speed
     */
    public double getSpeed() {
        return mSpeed;
    }

    /**
     * @param speed
     *            The speed
     */
    public void setSpeed(double speed) {
        mSpeed = speed;
    }

    /**
     * @return The deg
     */
    public double getDeg() {
        return mDeg;
    }

    /**
     * @param deg
     *            The deg
     */
    public void setDeg(double deg) {
        mDeg = deg;
    }

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeDouble(mSpeed);
		dest.writeDouble(mDeg);
	}

	public static final Parcelable.Creator<Wind> CREATOR = new Parcelable.Creator<Wind>() {
		public Wind createFromParcel(Parcel in) {
			return new Wind(in);
		}

		public Wind[] newArray(int size) {
			return new Wind[size];
		}
	};
}