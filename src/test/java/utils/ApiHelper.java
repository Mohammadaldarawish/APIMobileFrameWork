package utils;

import io.restassured.response.Response;

public class ApiHelper extends BaseApiHelper {

    @Override
    public Response sendPostRequest(String endpoint, Object body) {
        System.out.println("Executing POST request to: " + endpoint);
        return super.sendPostRequest(endpoint, body);
    }

    @Override
    public Response sendGetRequest(String endpoint, String token) {
        System.out.println("Executing GET request to: " + endpoint);
        return super.sendGetRequest(endpoint, token);
    }

    @Override
    public Response sendPutRequest(String endpoint, Object body, String token) {
        System.out.println("Executing PUT request to: " + endpoint);
        return super.sendPutRequest(endpoint, body, token);
    }

    @Override
    public Response sendDeleteRequest(String endpoint, String token) {
        System.out.println("Executing DELETE request to: " + endpoint);
        return super.sendDeleteRequest(endpoint, token);
    }


    @Override
    public Response sendGetRequestWithQueryParam(String baseURI, String page, String accessToken) {
        System.out.println("Executing GET request with query parameter to: " + baseURI);
        return super.sendGetRequestWithQueryParam(baseURI, page, accessToken);
    }


    private static void logRequestAndResponse(String method, String baseURI, Object body, Response response) {
        long responseTime = response.getTime();  // Time taken for the request

        // Log request details
        System.out.println("=== REQUEST DETAILS ===");
        System.out.println("HTTP Method: " + method);
        System.out.println("Request Endpoint: " + baseURI);
        if (body != null) {
            System.out.println("Request Body: " + body.toString());
        } else {
            System.out.println("Request Body: No body content");
        }

        // Log response details
        System.out.println("\n=== RESPONSE DETAILS ===");
        System.out.println("HTTP Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Response Headers: " + response.getHeaders());
        System.out.println("Response Time: " + responseTime + " ms");

        // Log additional details for better traceability
        System.out.println("\n=== ADDITIONAL DETAILS ===");
        if (response.getStatusCode() >= 400) {
            System.out.println("Error Response: Status code indicates failure (>=400).");
        } else {
            System.out.println("Success Response: Status code indicates success (<400).");
        }
        System.out.println("Request Timestamp: " + java.time.LocalDateTime.now());
        System.out.println("Request Origin: " + System.getProperty("user.name") + "@" + System.getProperty("user.home"));
    }

}