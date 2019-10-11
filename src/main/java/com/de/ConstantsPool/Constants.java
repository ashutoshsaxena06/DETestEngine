package com.de.ConstantsPool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.framework.commonUtils.Roles;


public class Constants {

	static protected Properties prop;
	public static final String path = System.getProperty("user.home") + "\\Downloads\\chromedriver_win32\\chromedriver.exe";

	static {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir")+ File.separator+ "Constants.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static class DEApp extends Constants{
		private String username;
		private String userPassword;
		private String de_App_Url;

		public static String getUsername() {
			return "autoUser111";
					//prop.getProperty("username");
		}

		public static String getUserPassword() {
			return AdminApp.defaultPassword;
					//prop.getProperty("userPassword");
		}

		public static String getde_App_Url() {
			return "http://newdiningedge.baitek.org:8100/";
					//prop.getProperty("de_App_Url");
		}
		public static void setde_App_Url(String url) {
			prop.setProperty("de_App_Url", url);
		}
	}

	public static class AdminApp extends Constants {
		private String admin_Username;
		private String admin_Password;
		private String admin_App_Url;
		public static final String defaultFirstName = "automation";
		public static final String defaultLasttName = "testing";
		public static final String defaultCompanyName = "New Demo Site";
		public static final String defaultUserName = "automationUser";
		public static final String defaultEmail = "teamesave@gmail.com";
		public static final String defaultEmail1 = "onlineweekend.diningedge@gmail.com";
		public static final String defaultPassword = "123456";
		public static final String defaultRoles = Roles.ROLE_OWNER.name();
		public static final String defaultLocation = "autoLocation";
		public static final String defaultTimeZone = "New York";
		public static final String defaultProductList = "Demo Site";
		public static final String defaultHomePageHeading = "Diningedge dark side";
		
		public static String getAdmin_Username() {
			return prop.getProperty("admin_Username");
		}

		public static String getAdmin_Password() {
			return prop.getProperty("admin_Password");
		}

		public static String getAdmin_App_Url() {
			return prop.getProperty("admin_App_Url");
		}
		public static void setAdmin_App_Url(String url) {
			prop.setProperty("admin_App_Url", url);
		}
	}

}
