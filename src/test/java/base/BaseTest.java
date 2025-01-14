package base;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static String baseURI;
    private static final Properties properties;

    static {
        String configPath = System.getProperty("configPath", "src/main/resources/config.properties");
        try (FileInputStream fileInputStream = new FileInputStream(configPath)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file from: " + configPath, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    @BeforeClass
    public static void setup() {
        // Set the environment-based base URI here
        String environment = System.getProperty("env", "dev");

        switch (environment.toLowerCase()) {
            case "prod":
                baseURI = properties.getProperty("prodBaseURL");
                break;
            case "stg":
                baseURI = properties.getProperty("stgBaseURL");
                break;
            case "dev":
            default:
                baseURI = properties.getProperty("devBaseURL");
                break;
        }

        RestAssured.baseURI = baseURI;
        Allure.addAttachment("Environment", "OS: MacOS, Java: 11, Browser: Chrome, Owner:Mohammad Aldarawish");
    }

    @DataProvider(name = "contactIdProvider")
    public Object[][] provideContactIds() {
        String contactId1 = properties.getProperty("contactId1");
        String contactId2 = properties.getProperty("contactId2");
        return new Object[][]{
                {contactId1},
                {contactId2},
        };
    }
}