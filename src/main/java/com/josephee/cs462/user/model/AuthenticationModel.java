package com.josephee.cs462.user.model;

public class AuthenticationModel {

    private boolean authenticated;
    private Long userId;

    public AuthenticationModel(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public AuthenticationModel(boolean authenticated, Long userId) {
        this.authenticated = authenticated;
        this.userId = userId;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
