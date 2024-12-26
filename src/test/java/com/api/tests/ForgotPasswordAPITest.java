package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordAPITest {
    @Test(groups = "regression", description = "Authentication Service Test: Verify if Forgot Password API is working")
    public void forgotPassword(){
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("muzaffar988@gmail.com");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
