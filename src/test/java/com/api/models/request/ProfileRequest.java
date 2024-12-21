package com.api.models.request;

public class ProfileRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;

    public ProfileRequest(String firstName, String lastName, String email, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "ProfileRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String email;
        private String mobileNumber;

        // Setter methods in the builder for each field
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this; // Return builder itself to allow method chaining
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this; // Return builder itself to allow method chaining
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this; // Return builder itself to allow method chaining
        }

        public Builder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this; // Return builder itself to allow method chaining
        }

        // Build method to return the User object
        public ProfileRequest build() {
            return new ProfileRequest(firstName, lastName, email, mobileNumber); // Create the ProfileRequest object using the builder
        }

    }
}
