package models;

import java.time.LocalDate;

public class User {
    private String name;
    private String password;
    private LocalDate birthDate;

    public User(String name, String password, LocalDate birthDay) {
        this.name = name;
        this.password = password;
        this.birthDate = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
