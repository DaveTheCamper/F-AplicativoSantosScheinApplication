package com.santosschein.app.data.remote.dto;

public final class RegisterUserRequestDto {

    private final String firstName;
    private final String lastName;
    private final String birthDate;
    private final String document;
    private final String email;
    private final String password;

    public RegisterUserRequestDto(
            String firstName,
            String lastName,
            String birthDate,
            String document,
            String email,
            String password
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.document = document;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
