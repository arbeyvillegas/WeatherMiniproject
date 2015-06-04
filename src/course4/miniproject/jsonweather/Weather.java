package course4.miniproject.jsonweather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This "Plain Ol' Java Object" (POJO) class represents data related to weather
 * downloaded in Json from the Weather Service.
 */
public class Weather implements Parcelable {
	/**
	 * Various tags corresponding to weather data downloaded in Json from the
	 * Weather Service.
	 */
	public final static String id_JSON = "id";
	public final static String main_JSON = "main";
	public final static String description_JSON = "description";
	public final static String icon_JSON = "icon";

	/**
	 * Various fields corresponding to weather data downloaded in Json from the
	 * Weather Service.
	 */
	private long id;
	private String main;
	private String description;
	private String icon;
	
	public Weather()
	{}
	
	public Weather(Parcel in){
		id=in.readLong();
		main=in.readString();
		description=in.readString();
		icon=in.readString();
	}
	
	/**
	 * 
	 * @return The id
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The main
	 */
	public String getMain() {
		return main;
	}

	/**
	 * 
	 * @param main
	 *            The main
	 */
	public void setMain(String main) {
		this.main = main;
	}

	/**
	 * 
	 * @return The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return The icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 
	 * @param icon
	 *            The icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(main);
		dest.writeString(description);
		dest.writeString(icon);
	}

	public static final Parcelable.Creator<Weather> CREATOR = new Parcelable.Creator<Weather>() {
		public Weather createFromParcel(Parcel in) {
			return new Weather(in);
		}

		public Weather[] newArray(int size) {
			return new Weather[size];
		}
	};
}
