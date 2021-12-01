package com.epam.tc.hw7.entities;

import com.jdiai.tools.DataClass;

public class User extends DataClass<User> {

    public static User DEFAULT_USER = new User("Roman", "Jdi1234", "Roman Iovlev");

    private String name;
    private String password;
    private String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
