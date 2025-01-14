package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class ApiAssertions {

    // Generic method to assert the status code
    public static void assertStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code mismatch");
    }

    // Generic method to assert the response message
    public static void assertMessage(Response response, String expectedMessage) {
        String actualMessage = response.jsonPath().getString("message");
        Assert.assertEquals(actualMessage, expectedMessage, "Message mismatch");
    }

    // Generic method to assert success flag
    public static void assertSuccessFlag(Response response, boolean expectedFlag) {
        boolean actualFlag = response.jsonPath().getBoolean("success");
        Assert.assertEquals(actualFlag, expectedFlag, "Success flag mismatch");
    }

    // Generic method to assert a field exists in the response
    public static void assertFieldExists(Response response, String fieldName) {
        Assert.assertNotNull(response.jsonPath().get(fieldName), "Field " + fieldName + " not found in response");
    }

    // Generic method to assert response body contains a specific data field
    public static void assertResponseContainsData(Response response) {
        Assert.assertTrue(response.getBody().asString().contains("data"), "Response body does not contain 'data' field");
    }

    // Generic method to assert the token structure
    public static void assertTokenStructure(String token) {
        Assert.assertNotNull(token, "Token is null");
        Assert.assertTrue(token.matches("[A-Za-z0-9\\-\\\\.]+\\.[A-Za-z0-9\\-\\\\.]+\\.[A-Za-z0-9\\-\\_\\.]+"), "Token structure is invalid");
    }

    // Generic method to assert JSON response contains specific key-value pair
    public static void assertJsonKeyValue(Response response, String jsonPath, String expectedValue) {
        String actualValue = response.jsonPath().getString(jsonPath);
        Assert.assertEquals(actualValue, expectedValue, "Value mismatch for JSON path: " + jsonPath);
    }

    // Generic method to assert that the response body is not empty
    public static void assertResponseNotEmpty(Response response) {
        Assert.assertTrue(response.getBody().asString().length() > 0, "Response body is empty");
    }

    // Generic method to assert the response time is within the expected range
    public static void assertResponseTime(Response response, long maxResponseTime) {
        long actualResponseTime = response.getTime();
        Assert.assertTrue(actualResponseTime <= maxResponseTime, "Response time exceeded: " + actualResponseTime + "ms");
    }
}