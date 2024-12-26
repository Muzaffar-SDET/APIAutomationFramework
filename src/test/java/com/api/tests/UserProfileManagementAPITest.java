package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileManagementAPITest {
    @Test(groups = "regression", description = "User Management Service: Verify Profile API is working")
    public void getProfileInfoTest(){
        //To get Profile info we need to first login to get the token
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Muzaffar", "Automation1234"));
        //Deserializing response object (which is json) to java object and reading token by calling getter method getToken()
        String token = response.as(LoginResponse.class).getToken();
        UserManagementService userManagementService = new UserManagementService();
        response = userManagementService.getUserProfile(token);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getId(), 377);
        Assert.assertEquals(userProfileResponse.getUsername(), "Muzaffar");
        Assert.assertEquals(userProfileResponse.getFirstName(), "Muzaffar");
        Assert.assertEquals(userProfileResponse.getLastName(), "Abduholikov");


    }
}
