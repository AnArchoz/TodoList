package model;

import java.util.Objects;

public class AppUser {
    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role) {
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        if (username == null || username.equals("")) {
            throw new IllegalArgumentException("Username can't be null!");
        }

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        if (password == null || password.equals("")) {
            throw new IllegalArgumentException("Password can't be null!");
        }

        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    private void setRole(AppRole role) {
        if (role == null) {
            throw new IllegalArgumentException("Role can't be null!");
        }

        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return getUsername().equals(appUser.getUsername()) && getRole() == appUser.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }
}
