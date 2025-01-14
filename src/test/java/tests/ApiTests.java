package tests;

import base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import models.*;
import api.ApiEndpoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.ApiAssertions;
import utils.ApiHelper;

public class ApiTests extends BaseTest {
    private final ApiHelper apiHelper = new ApiHelper();
    public String accessToken;
    public String refresh_token;

    @Feature("mnv")
    @Story("")
    @Owner("Mohammad Al-Darawish")

    @Test(description = "Check that sending OTP and receiving tokens works correctly", dataProvider = "contactIdProvider", priority = 1, groups = {"auth"})
    public void sendOTP(String contactId) {
        SendOtpRequest requestBody = new SendOtpRequest(contactId);
        Response response = apiHelper.sendPostRequest(baseURI + ApiEndpoints.getSendOtp(), requestBody);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "Contact Found");
        ApiAssertions.assertSuccessFlag(response, true);
        accessToken = response.jsonPath().getString("data.access_token");
        refresh_token = response.jsonPath().getString("data.refresh_token");
        ApiAssertions.assertTokenStructure(accessToken);
        ApiAssertions.assertTokenStructure(refresh_token);
    }

    @Test(description = "Check that login works correctly and verifies contact information", dataProvider = "contactIdProvider", priority = 2, groups = {"auth"})
    public void login(String contactId) {
        LoginRequest requestBody = new LoginRequest(contactId, "0000");
        Response response = apiHelper.sendPostRequest(baseURI + ApiEndpoints.getLogin(), requestBody);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertSuccessFlag(response, true);
        ApiAssertions.assertMessage(response, "Login successful");
    }

    @Test(description = "Check that logout functionality works correctly", priority = 3, groups = {"auth"})
    public void logout() {
        LogoutRequest requestBody = new LogoutRequest("client_id", "client_secret", accessToken);
        Response response = apiHelper.sendPostRequest(baseURI + ApiEndpoints.getLogout(), requestBody);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertSuccessFlag(response, true);
        ApiAssertions.assertMessage(response, "Logout successful");
    }

    @Test(description = "Check that refresh access token works correctly", priority = 4, groups = {"auth"})
    public void refreshAccessToken() {
        RefreshTokenRequest requestBody = new RefreshTokenRequest(refresh_token);
        Response response = apiHelper.sendPostRequest(baseURI + ApiEndpoints.getRefreshToken(), requestBody);
        ApiAssertions.assertStatusCode(response, 200);
        accessToken = response.jsonPath().getString("data.access_token");
        ApiAssertions.assertTokenStructure(accessToken);
    }

    @Test(description = "Check that verifying contact works correctly using contact ID", priority = 5, dataProvider = "contactIdProvider", groups = {"auth"})
    public void verifyContact(String contactId) {
        VerifyContactRequest requestBody = new VerifyContactRequest(contactId);
        Response response = apiHelper.sendPostRequest(baseURI + ApiEndpoints.getVerifyContact(contactId), requestBody);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertSuccessFlag(response, true);
        ApiAssertions.assertMessage(response, "Contact verified");
    }

    @Test(description = "Check that retrieving enrollment balance works correctly for enrolled debt", priority = 6, groups = {"Forth"}, dataProvider = "contactIdProvider")
    public void getEnrollmentBalance(String contactId) {
        Response response = apiHelper.sendGetRequest(baseURI + ApiEndpoints.getEnrollmentBalance(contactId), accessToken);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "Enrollment balance retrieved");
        ApiAssertions.assertResponseContainsData(response);
    }

    @Test(description = "Check that retrieving enrolled debt details works correctly", priority = 7, groups = {"Forth"}, dataProvider = "contactIdProvider")
    public void getEnrolledDebt(String contactId) {
        Response response = apiHelper.sendGetRequest(baseURI + ApiEndpoints.getEnrolledDebt(contactId), accessToken);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "Enrolled debt details retrieved");
        ApiAssertions.assertResponseContainsData(response);
    }

    @Test(description = "Check that retrieving contact transaction details works correctly", priority = 8, groups = {"Forth"}, dataProvider = "contactIdProvider")
    public void getContactTransaction(String contactId) {
        Response response = apiHelper.sendGetRequest(baseURI + ApiEndpoints.getContactTransactions(contactId), accessToken);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "Contact transactions retrieved");
        ApiAssertions.assertResponseContainsData(response);
    }

    @Test(description = "Check that retrieving contact documents works correctly", priority = 9, groups = {"Forth"}, dataProvider = "contactIdProvider")
    public void getContactDocuments(String contactId) {
        Response response = apiHelper.sendGetRequest(baseURI + ApiEndpoints.getContactDocuments(contactId), accessToken);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "Contact documents retrieved");
        ApiAssertions.assertResponseContainsData(response);
    }

    @Test(description = "Check that retrieving contact details works correctly", priority = 10, groups = {"Forth"}, dataProvider = "contactIdProvider")
    public void getContactDetails(String contactId) {
        Response response = apiHelper.sendGetRequest(baseURI + ApiEndpoints.getContactDetails(contactId), accessToken);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "Contact details retrieved");
        ApiAssertions.assertResponseContainsData(response);
    }

    @Test(description = "Check that retrieving all payment transactions works correctly", priority = 11, groups = {"Forth"}, dataProvider = "contactIdProvider")
    public void getAllPaymentTransactions(String contactId) {
        Response response = apiHelper.sendGetRequest(baseURI + ApiEndpoints.getPaymentTransactions(contactId), accessToken);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "Payment transactions retrieved");
    }

    @Test(description = "Check that retrieving uploaded documents works correctly", priority = 12, groups = {"Forth"}, dataProvider = "contactIdProvider")
    public void getUploadedDocuments(String contactId) {
        Response response = apiHelper.sendGetRequest(baseURI + ApiEndpoints.getUploadedDocuments(contactId), accessToken);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "Uploaded documents retrieved");
        ApiAssertions.assertResponseContainsData(response);
    }

    @Test(description = "Check that retrieving statements works correctly", priority = 13, groups = {"Forth"}, dataProvider = "contactIdProvider")
    public void getStatements(String contactId) {
        Response response = apiHelper.sendGetRequest(baseURI + ApiEndpoints.getStatements(contactId), accessToken);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "Statements retrieved");
        ApiAssertions.assertResponseContainsData(response);
    }

    @Test(description = "Check that retrieving budget tracking details works correctly", priority = 14, groups = {"Forth"}, dataProvider = "contactIdProvider")
    public void getBudgetTracking(String contactId) {
        Response response = apiHelper.sendGetRequest(baseURI + ApiEndpoints.getBudgetTracking(contactId), accessToken);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "Budget tracking details retrieved");
        ApiAssertions.assertResponseContainsData(response);
    }

    @Test(description = "Check that sending a message to a contact works correctly", priority = 15, groups = {"CMS"})
    public void sendContactMessage() {
        SendContactMessageRequest requestBody = new SendContactMessageRequest("4083642", "Test message");
        Response response = apiHelper.sendPostRequest(baseURI + ApiEndpoints.getSendContactMessage(), requestBody);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "Message sent");
        ApiAssertions.assertResponseContainsData(response);
    }

    @Test(description = "Check that retrieving the FAQ page works correctly", priority = 16, groups = {"CMS"})
    public void getFAQPage() {
        Response response = apiHelper.sendGetRequestWithQueryParam(baseURI + ApiEndpoints.getFaqPage(), "1", accessToken);
        ApiAssertions.assertStatusCode(response, 200);
        ApiAssertions.assertMessage(response, "FAQ page retrieved");
        ApiAssertions.assertResponseContainsData(response);
    }
}