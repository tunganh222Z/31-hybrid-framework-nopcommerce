package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Topic10_Environment_Properties {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        try (FileInputStream input = new FileInputStream(projectPath + File.separator + "environmentConfig"+File.separator+"dev.properties")) {
            Properties prop = new Properties();

            prop.load(input);

            System.out.println(prop.getProperty("App.Url"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
