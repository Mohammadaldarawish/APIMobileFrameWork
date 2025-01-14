package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class BaseApiHelper {

    public Response sendPostRequest(String endpoint, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response sendGetRequest(String endpoint, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response sendPutRequest(String endpoint, Object body, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(body)
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response sendDeleteRequest(String endpoint, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
    public Response sendGetRequestWithQueryParam(String baseURI, String page, String accessToken) {
        return given()
                .queryParam("page", page)
                .header("Authorization", "Bearer " + accessToken)
                .get(baseURI)
                .then()
                .extract()
                .response();
    }
}