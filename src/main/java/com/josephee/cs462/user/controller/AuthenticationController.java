package com.josephee.cs462.user.controller;

import com.josephee.cs462.common.model.user.UserModel;
import com.josephee.cs462.user.model.AuthenticationModel;
import com.josephee.cs462.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    private static final int COOKIE_MAX_SECONDS = 12 * 60 * 60;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public AuthenticationModel authenticate(@RequestBody UserModel model) {
        Assert.notNull(model.getUsername());
        Assert.notNull(model.getPassword());
        AuthenticationModel auth = userService.authenticate(model.getUsername(), model.getPassword());
        return auth;
    }
}
