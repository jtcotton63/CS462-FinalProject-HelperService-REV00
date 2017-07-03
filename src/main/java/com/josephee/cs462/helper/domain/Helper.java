package com.josephee.cs462.job.domain;

import com.josephee.cs462.job.model.HelperModel;

import javax.persistence.*;

@Entity
public class Helper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String firstName;
    private String email;

    public Helper() {
    }

    public Helper(Long id, String lastName, String firstName, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public Helper(HelperModel model) {
        if(model.getId() != null && model.getId() > 0)
            this.id = model.getId();

        if(model.getLastName() != null && !model.getLastName().isEmpty())
            this.lastName = model.getLastName();

        if(model.getFirstName() != null && !model.getFirstName().isEmpty())
            this.firstName = model.getFirstName();

        if(model.getEmail() != null && !model.getEmail().isEmpty())
            this.email = model.getEmail();
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

    public HelperModel toModel() {
        HelperModel model = new HelperModel();

        if(this.getId() != null && this.getId() > 0)
            model.setId(this.getId());

        if(this.getLastName() != null && !this.getLastName().isEmpty())
            model.setLastName(this.getLastName());

        if(this.getFirstName() != null && !this.getFirstName().isEmpty())
            model.setFirstName(this.getFirstName());

        if(this.getEmail() != null && !this.getEmail().isEmpty())
            model.setEmail(this.getEmail());

        return model;
    }
}
