package com.de.core;


public class ExecutionConfig {
    public static final String PLATFORM;
    public static final String BROWSER;
    public static final int MAX_PAGE_LOAD_WAIT_TIME;
    public static final int MAX_ELEMENT_LOAD_WAIT_TIME;
    public static final int TEST_CASE_RETRY_COUNT;
    public static final String EXECUTION_ENVIRONMENT;
    public static final String HUB_NODE_URL;
    public static final String SEND_EXEC_REPORT_EMAIL;
    public static final String SMTP_HOSTNAME;
    public static final String SMTP_PORT;
    public static final String SMTP_USERNAME;
    public static final String SMTP_PASSWORD;
    public static final String TEMP_DATA_PATH;
    public static final String EXEC_REPORT_EMAIL_RECEIVER;
    public static final String MOBILE_EMULATION;
    public static final String SUITE_XML_FILE;
    public static final String CURRENT_PROFILE;
    public static final String ANALYSIS_PATH;
    public static final String USER_AGENT;

    public ExecutionConfig() {
    }

    static {
        try {
            PLATFORM = System.getProperty("PLATFORM", "win");
            BROWSER = System.getProperty("BROWSER", "chrome");
            MAX_PAGE_LOAD_WAIT_TIME = Integer.parseInt(System.getProperty("MAX_PAGE_LOAD_WAIT_TIME", "60"));
            MAX_ELEMENT_LOAD_WAIT_TIME = Integer.parseInt(System.getProperty("MAX_ELEMENT_LOAD_WAIT_TIME", "60"));
            TEST_CASE_RETRY_COUNT = Integer.parseInt(System.getProperty("TEST_CASE_RETRY_COUNT", "0"));
            EXECUTION_ENVIRONMENT = System.getProperty("EXECUTION_ENVIRONMENT", "local");
            HUB_NODE_URL = System.getProperty("HUB_NODE_URL", "");
            SMTP_HOSTNAME = System.getProperty("SMTP_HOSTNAME", "");
            SMTP_PORT = System.getProperty("SMTP_PORT", "");
            SMTP_USERNAME = System.getProperty("SMTP_USERNAME", "");
            SMTP_PASSWORD = System.getProperty("SMTP_PASSWORD", "");
            TEMP_DATA_PATH = CommonUtils.getPathWithValidSeperator(System.getProperty("TEMP_DATA_DIRECTORY", ""));
            SEND_EXEC_REPORT_EMAIL = System.getProperty("SEND_EXEC_REPORT_EMAIL", "");
            EXEC_REPORT_EMAIL_RECEIVER = System.getProperty("EXEC_REPORT_EMAIL_RECEIVER", "");
            MOBILE_EMULATION = System.getProperty("MOBILE_EMULATION", "");
            CommonUtils.createDirectory(TEMP_DATA_PATH);
            SUITE_XML_FILE = System.getProperty("suiteXmlFile", "").replace(".xml", "").trim();
            CURRENT_PROFILE = System.getProperty("currentProfile", "");
            ANALYSIS_PATH = System.getProperty("REPORT_ANALYSIS_DIR", "");
            USER_AGENT = System.getProperty("USER_AGENT", "");
        } catch (Throwable var1) {
            var1.printStackTrace();
            throw new RuntimeException("Something wrong !!! Check configurations.", var1);
        }
    }
}
