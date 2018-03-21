package com.project.pmalek_project.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class User implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirdt;

    public User() { }

    public User(Long id, String firstName, String lastName, String email, LocalDate dateOfBirdt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirdt = dateOfBirdt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDateOfBirdt() {
        return dateOfBirdt;
    }

    public void setDateOfBirdt(LocalDate dateOfBirdt) {
        this.dateOfBirdt = dateOfBirdt;
    }
}
