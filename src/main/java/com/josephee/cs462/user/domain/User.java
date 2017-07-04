package com.josephee.cs462.user.domain;

import com.josephee.cs462.common.model.user.UserModel;
import com.josephee.cs462.common.model.user.Role;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String username;
    private String password;
    private Role role;

    public User() {
    }

    public User(Long id, String lastName, String firstName, String email, String username, String password, Role role) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(UserModel model) {
        if(model.getId() != null && model.getId() > 0)
            this.id = model.getId();

        if(model.getLastName() != null && !model.getLastName().isEmpty())
            this.lastName = model.getLastName();

        if(model.getFirstName() != null && !model.getFirstName().isEmpty())
            this.firstName = model.getFirstName();

        if(model.getEmail() != null && !model.getEmail().isEmpty())
            this.email = model.getEmail();

        if(model.getUsername() != null && !model.getUsername().isEmpty())
            this.username = model.getUsername();

        if(model.getPassword() != null && !model.getPassword().isEmpty())
            this.password = model.getPassword();

        if(model.getRole() != null)
            this.role = model.getRole();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserModel toModel() {
        UserModel model = new UserModel();

        if(this.getId() != null && this.getId() > 0)
            model.setId(this.getId());

        if(this.getLastName() != null && !this.getLastName().isEmpty())
            model.setLastName(this.getLastName());

        if(this.getFirstName() != null && !this.getFirstName().isEmpty())
            model.setFirstName(this.getFirstName());

        if(this.getEmail() != null && !this.getEmail().isEmpty())
            model.setEmail(this.getEmail());

        if(this.getUsername() != null && !this.getUsername().isEmpty())
            model.setUsername(this.getUsername());

        if(this.getPassword() != null && !this.getPassword().isEmpty())
            model.setPassword(this.getPassword());

        if(this.getRole() != null)
            model.setRole(this.getRole());

        return model;
    }
}
