package jsonData.Nopcommerce;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstant;

import java.io.File;

public class UserInfo {

    public static UserInfo getUserInfo(String filename) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstant.RESOURCE_PATH + filename), UserInfo.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("dob")
    private String DOB;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;
}