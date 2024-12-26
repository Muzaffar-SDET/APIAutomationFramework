package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)

public class LoginAPITest {

    @Test(groups = {"smoke", "regression"}, description = "Authentication Service Test: Verify if Login endpoint is working")
    public void loginTest(){
        //1. Hardcoding version
//        AuthService authService = new AuthService();
//        Response response = authService.login("{\"username\": \"Muzaffar\",\"password\": \"Automation1234\"}");
//        System.out.println(response.asPrettyString());
//        Assert.assertEquals(response.getStatusCode(), 200);

        //2. using pojo classes LoginRequest and LoginResponse
        LoginRequest loginRequest = new LoginRequest("Muzaffar", "Automation1234");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        System.out.println(loginRequest);
        Assert.assertEquals(response.getStatusCode(), 200);
        LoginResponse loginResponse = response.as(LoginResponse.class); //Deserializing: converting json object (response) into java object (response.as(LoginResponse.class))
        System.out.println(response.asPrettyString());
        System.out.println("Token: "+loginResponse.getToken());
        System.out.println("Email: "+ loginResponse.getEmail());
        System.out.println("Username: "+loginResponse.getUsername());
        System.out.println("Roles: "+ loginResponse.getRoles());


    }
}
