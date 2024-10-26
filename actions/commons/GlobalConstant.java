package commons;

import java.io.File;

public class GlobalConstant {
    // Server Url : Dev/ Testing / Staging / Product
    // Database : Dev/ Testing / Staging / Product
    // Timeout : Short / Long
    // Username / Password
    // Third Party : Sandbox paypal
    public static final String ADMIN_USERNAME = "tunganh@automationfc.com";
    public static final String ADMIN_PASSWORD = "tunganh@automationfc.com";

    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator;

    public static final String OS_NAME = System.getProperty("os.name");

    public static final String RESOURCE_PATH = RELATIVE_PROJECT_PATH + File.separator + "resources" + File.separator;


    public static final long LONG_TIMEOUT = 5;
    public static final long SHORT_TIMEOUT = 30;

    public static final String ENVIRONMENT_CONFIG_PATH = RELATIVE_PROJECT_PATH + File.separator + "environmentConfig" + File.separator;
}
