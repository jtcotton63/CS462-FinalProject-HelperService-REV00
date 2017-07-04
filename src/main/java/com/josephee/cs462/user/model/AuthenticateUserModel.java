package com.josephee.cs462.user.model;

import com.josephee.cs462.common.model.user.UserModel;

public class AuthenticateUserModel {

    private UserModel userModel;
    private boolean authenticated;

    public AuthenticateUserModel(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public AuthenticateUserModel(UserModel userModel, boolean authenticated) {
        this.userModel = userModel;
        this.authenticated = authenticated;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public UserModel getUserModel() {
        return userModel;
    }
}
