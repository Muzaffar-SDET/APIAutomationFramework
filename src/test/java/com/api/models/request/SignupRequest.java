package com.api.models.request;

public class SignupRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;


    public SignupRequest(String username, String password, String email, String firstName, String lastName, String mobileNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "SignupRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    //creating an inner class Builder. Inner class will not have a Constructor in it. Only methods.
    public static class Builder{
        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private String mobileNumber;

        //setter method for the Builder class
        public Builder userName(String username){
            this.username = username;
            return this; //this means current object. Object here is new Builder()
        }

        public Builder password(String password){
            this.password = password;
            return this; //this means current object. Object here is new Builder()
        }

        public Builder email(String email){
            this.email = email;
            return this; //this means current object. Object here is new Builder()
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this; //this means current object. Object here is new Builder()
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this; //this means current object. Object here is new Builder()
        }
        public Builder mobileNumber(String mobileNumber){
            this.mobileNumber = mobileNumber;
            return this; //this means current object. Object here is new Builder()
        }

        //creating a new method build() to create an object of SignUpRequest class
        public SignupRequest build(){
            SignupRequest signupRequest = new SignupRequest(username, password, email, firstName, lastName, mobileNumber);
            return  signupRequest;
        }

    }

}
