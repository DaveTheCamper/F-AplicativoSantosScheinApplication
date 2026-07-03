package com.santosschein.app.domain.model;

import java.time.LocalDate;

public final class User {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String document;
    private final String email;

    public User(
            String id,
            String firstName,
            String lastName,
            LocalDate birthDate,
            String document,
            String email
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.document = document;
        this.email = email;
    }

    public String getId() {
        return id;
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
}
