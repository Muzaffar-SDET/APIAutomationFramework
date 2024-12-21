package com.api.tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleAPITest {
    @Test(description = "Verify if Login Page is working")
    public void loginTest(){

//        RestAssured.baseURI = "http://64.227.160.186:8080"; //assigning base URI
        /**
         * RestAssured class has many utility methods that help in constructing HTTP requests and processing responses.
         * The most commonly used method are:
         *     1. given() which is used to set up the request specification.
         *     2. header() which takes content type
         *     3. body() which takes the request body
         *
         */

//        RequestSpecification x = RestAssured.given(); //returns RequestSpecification object
//        RequestSpecification y = x.header("Content-Type", "application/json"); //returns RequestSpecification object
//        RequestSpecification z = y.body("{\"username\": \"Muzaffar\",\n" +
//                "  \"password\": \"Automation1234\"}");
//        Response response = z.post("api/auth/login");
//        System.out.println(response.asPrettyString());
//        Assert.assertEquals(response.getStatusCode(), 200);

        //we can also write it like below.
//        Response response = given().header("Content-Type", "application/json").body("{\"username\": \"Muzaffar\",\"password\": \"Automation1234\"}").post("api/auth/login");

        //we can also do static import (import static io.restassured.RestAssured.*;)for RestAssured package for better readability.
        //We won't have to write RestAssured. before using it's properties (methods)
        Response response = given().baseUri("http://64.227.160.186:8080")
                .header("Content-Type", "application/json")
                .body("{\"username\": \"muzaffar555\",\n" +
                        "  \"password\": \"muzaffar2\",\n" +
                        "  \"email\": \"muzaffar97@gmail.com\",\n" +
                        "  \"firstName\": \"muzaffar\",\n" +
                        "  \"lastName\": \"abdu\",\n" +
                        "  \"mobileNumber\": \"8783859765\"}")
                .post("api/auth/signup");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
