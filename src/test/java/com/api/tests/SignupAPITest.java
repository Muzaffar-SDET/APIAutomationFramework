package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignupAPITest {

    @Test(description = "Authentication Service Test: Verify if Signup API is working")
    public void signupTest(){
        //1. Initiazing object variables through Constructor
//        SignupRequest signupRequest = new SignupRequest("muzaffar405", "muzaffar2", "muzaffar908@gmail.com", "muzaffar", "muzaddar", "8783959765");


        //2. Passing a lot of parameters to the Constructor which can be confusing to remember the order of the parameters,
        //   We can use implement Builder Design Pattern to make it more readable. We will create it in our POJO class SignupRequest
        SignupRequest signupRequest = new SignupRequest.Builder().userName("muzaffar4105") //setting username value by calling the username setter method inside the Builder() inner class
                .password("muzaffar2") //setting the password value
                .email("muzaffar988@gmail.com")
                .firstName("muzaffar")
                .lastName("muzaffar")
                .mobileNumber("7862349877")
                .build(); //after passing values into the setter methods calling build method which initializes the Constructor

        AuthService authService = new AuthService();
        Response response = authService.signup(signupRequest);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");

    }



}
