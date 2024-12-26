package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ResetPasswordRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResetPasswordAPITest {

    @Test(groups = "regression", description = "Authentication Service Test: Verify if Reset Password API is working")
    public void resetPassword(){
        LoginRequest loginRequest = new LoginRequest("Muzaffar", "Automation1234");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        System.out.println(loginRequest);
        Assert.assertEquals(response.getStatusCode(), 200);
        LoginResponse loginResponse = response.as(LoginResponse.class); //Deserializing: converting json object (response) into java object (response.as(LoginResponse.class))
        System.out.println(response.asPrettyString());
        //fetching the token from Login call response and assigning it to a new String variable to use in the next call
        String token = loginResponse.getToken();
        ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest(token, "Automation12345", "Automation12345");
        response = authService.resetPassword(token, resetPasswordRequest);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
