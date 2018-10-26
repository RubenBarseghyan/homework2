package com.example.ruben.homework2;

public class User {
    private String fistName;
    private String lastName;
    private boolean gender;
    private String email;
    private String password;


    public User(String fistName, String lastName, boolean gender, String email, String password) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
