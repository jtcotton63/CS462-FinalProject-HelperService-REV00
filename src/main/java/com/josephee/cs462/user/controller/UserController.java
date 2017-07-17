package com.josephee.cs462.user.controller;

import com.josephee.cs462.common.model.user.Role;
import com.josephee.cs462.common.model.user.UserModel;
import com.josephee.cs462.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Long create(@RequestBody UserModel model) {
        UserModel saved = userService.create(model);
        return saved.getId();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<UserModel> getUsers(Pageable pageable,
                                    @RequestParam(name = "role", required = false)Optional<Long> roleId) {
        Page<UserModel> modelsPage;

        if(roleId.isPresent()) {
            Role role = Role.from(roleId.get());
            modelsPage = userService.getUsers(pageable, role);
        }

        else {
            modelsPage = userService.getUsers(pageable);
        }

        return modelsPage;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserModel getUser(@PathVariable Long id) {
        UserModel userModel = userService.getById(id);
        return userModel;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public Role[] getRoles() {
        Role[] roles = userService.getRoles();
        return roles;
    }
}
