package com.santosschein.app.domain.model;

import java.time.LocalDate;

public final class RegisterUserInput {

    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String document;
    private final String email;
    private final String password;

    public RegisterUserInput(
            String firstName,
            String lastName,
            LocalDate birthDate,
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

    public LocalDate getBirthDate() {
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
