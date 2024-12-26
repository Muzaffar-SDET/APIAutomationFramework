package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignupAPITest {

    @Test(groups = {"smoke", "regression"}, description = "Authentication Service Test: Verify if Signup API is working")
    public void signupTest(){
        //1. Initiazing object variables through Constructor
//        SignupRequest signupRequest = new SignupRequest("muzaffar405", "muzaffar2", "muzaffar908@gmail.com", "muzaffar", "muzaddar", "8783959765");


        //2. Passing a lot of parameters to the Constructor which can be confusing to remember the order of the parameters,
        //   We can use implement Builder Design Pattern to make it more readable. We will create it in our POJO class SignupRequest
        Faker faker = new Faker();
        String username = faker.name().username();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName+"."+lastName+"@gmail.com";
        String mobileNumber = faker.phoneNumber().cellPhone().replaceAll("[^\\d]", "");
        String password = "APITest1234";

        SignupRequest signupRequest = new SignupRequest.Builder()
                .userName(username) //setting username value by calling the username setter method inside the Builder() inner class
                .password(password) //setting the password value
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .mobileNumber(mobileNumber)
                .build(); //after passing values into the setter methods calling build method which initializes the Constructor

        AuthService authService = new AuthService();
        Response response = authService.signup(signupRequest);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");

    }



}
