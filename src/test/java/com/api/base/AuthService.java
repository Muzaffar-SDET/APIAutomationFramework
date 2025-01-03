package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.ResetPasswordRequest;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService extends BaseService{

    //creating a constant variable for the service path
    private static final String BASE_PATH = "/api/auth/";

    public Response login(LoginRequest payload){
        return postRequest(payload, BASE_PATH+"login");
    }

    public Response signup(SignupRequest payload){
        return postRequest(payload, BASE_PATH+"signup");
    }
    public Response resetPassword(String token, ResetPasswordRequest payload){
        setAuthToken(token);
        return postRequest(payload, BASE_PATH+"reset-password");
    }
    public Response forgotPassword(String emailAddress){
        HashMap<String, String> payload = new HashMap<>();
        payload.put("email", emailAddress);
        return postRequest(payload, BASE_PATH+"forgot-password");
    }



}
