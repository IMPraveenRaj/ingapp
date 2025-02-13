package com.springheaven.ing.ingapp.thymeleaf;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDetailsDTO {
    // Getters and Setters
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;


    // Constructors
    public UserDetailsDTO(String name, String email, String address, String dateOfBirth) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public void setName(String name) { this.name = name; }

    public void setEmail(String email) { this.email = email; }

    public void setAddress(String address) { this.address = address; }

    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
}

