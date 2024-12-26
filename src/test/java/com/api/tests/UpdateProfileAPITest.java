package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileAPITest {
    @Test(groups = "regression", description = "Verifying if Profile update API is working")
    public void profileUpdate(){
        //Logging in to get token
        AuthService authService = new AuthService();
        LoginResponse loginResponse = authService.login(
                new LoginRequest("Muzaffar", "Automation1234")).as(LoginResponse.class);
        String token = loginResponse.getToken();


        UserManagementService userManagementService = new UserManagementService();
        Response response = userManagementService.updateProfile(token, new ProfileRequest.Builder()
                .setFirstName("Muzaffar1")
                .setLastName("Muzaffar1")
                .setEmail("muzaffar12234@gmail.com")
                .setMobileNumber("8747659345")
                .build());
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getFirstName(), "Muzaffar1");
    }
}
