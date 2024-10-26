package utilities;

import commons.GlobalConstant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {
    private Properties properties;
    private final String propertyFilePath = GlobalConstant.ENVIRONMENT_CONFIG_PATH + "%s.properties";

    public PropertiesConfig(String severName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(String.format(propertyFilePath, severName)));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }


    public static PropertiesConfig getProperties(String severName){
        return new PropertiesConfig(severName);
    }

    public String getApplicationUrl(){
        String url = properties.getProperty("App.Url");
        if (url != null ) {
            return url;
        } else
            throw new RuntimeException("Url not specified in the properties file");
    }
}
