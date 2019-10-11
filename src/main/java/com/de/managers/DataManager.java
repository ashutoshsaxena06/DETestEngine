package com.de.managers;

public class DataManager {

	private static String username;
	private static String password;
	private String locationName;

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		DataManager.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		DataManager.password = password;
	}

	public static void setCredentials(String userName2, String defaultpassword) {
		setUsername(userName2);
		setPassword(defaultpassword);
	}

	public String getOrderGuideForVendor(String name) {
		return null;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locatioName) {
		this.locationName = locatioName;
	}
}
