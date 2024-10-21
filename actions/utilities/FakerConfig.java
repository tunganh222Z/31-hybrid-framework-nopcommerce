package utilities;

import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class FakerConfig {
    public static FakerConfig getFakerConfig(){
        return new FakerConfig();
    }

    Faker faker = new Faker(new Locale("en", "US"));

    public String getFirstName() {
        return faker.name().firstName();
    }
}
