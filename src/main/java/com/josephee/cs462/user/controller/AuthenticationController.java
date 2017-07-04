package com.josephee.cs462.user.controller;

import com.josephee.cs462.common.model.user.Role;
import com.josephee.cs462.common.model.user.UserModel;
import com.josephee.cs462.user.model.AuthenticateUserModel;
import com.josephee.cs462.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    private static final int COOKIE_MAX_SECONDS = 12 * 60 * 60;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<AuthenticateUserModel> authenticate(@RequestBody UserModel model, HttpServletResponse response) {
        Assert.notNull(model.getUsername());
        Assert.notNull(model.getPassword());
        AuthenticateUserModel auth = userService.authenticate(model.getUsername(), model.getPassword());
        if(!auth.isAuthenticated()) {
            for(Role role: Role.values()) {
                Cookie cookie = new Cookie("role", role.name());
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }

            return new ResponseEntity<>(auth, HttpStatus.OK);
        }

        // Send back a response with a special cookie header
        Role role = auth.getUserModel().getRole();
        Assert.notNull(role);
        Cookie cookie = new Cookie("role", role.name());
        cookie.setMaxAge(COOKIE_MAX_SECONDS);
        response.addCookie(cookie);

        // Return the appropriate response entity
        return new ResponseEntity<>(auth, HttpStatus.OK);
    }
}
