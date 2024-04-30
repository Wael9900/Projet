package com.example.projet;

public class helperuser {
    public String email;
    public String username;
    public String password;

    public helperuser() {
        // Default constructor required for calls to DataSnapshot.getValue(HelperUser.class)
    }

    public helperuser(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
