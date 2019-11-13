package com.de.ConstantsPool;

import com.framework.commonUtils.Roles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Constants {

    public static final String path = System.getProperty("user.home") + "\\Downloads\\chromedriver_win32\\chromedriver.exe";
    static protected Properties prop;

    static {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") + File.separator + "Constants.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static class DEApp extends Constants {
        private static String defaultUser;
        private static String defaultPassword;
        private static String de_App_Url;

        public static String getDefaultUser() { return prop.getProperty("defaultUser"); }

        public static String getDefaultPassword() {
            return prop.getProperty("defaultPassword");
        }

        public static String getde_App_Url() { return prop.getProperty("de_App_Url");    }

        public static String getProductName() { return prop.getProperty("productName");    }
    }

    public static class AdminApp extends Constants {
        public static final String defaultFirstName = "automation";
        public static final String defaultLasttName = "testing";
        public static final String defaultCompanyName = "New Demo Site";
        public static final String defaultUserName = "automationUser";
        public static final String defaultEmail = "vb0788@gmail.com";
        public static final String defaultEmail1 = "onlineweekend.diningedge@gmail.com";
        public static final String defaultPassword = "123456";
        public static final String defaultRoles = Roles.ROLE_OWNER.name();
        public static final String defaultLocation = "autoLocation";
        public static final String defaultTimeZone = "New York";
        public static final String defaultProductList = "Demo Site";
        public static final String defaultHomePageHeading = "Diningedge dark side";
        private String admin_Username;
        private String admin_Password;
        private String admin_App_Url;

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
