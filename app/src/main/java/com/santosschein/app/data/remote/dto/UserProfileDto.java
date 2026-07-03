package com.santosschein.app.data.remote.dto;

public final class UserProfileDto {

    private String id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String document;
    private String email;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }
}
