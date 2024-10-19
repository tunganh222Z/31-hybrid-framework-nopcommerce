package utilities;

import net.datafaker.Faker;

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
