package com.josephee.cs462.common.model.job;

import lombok.ToString;

import java.time.ZonedDateTime;

@ToString
public class JobModel {

    private Long id;
    private String address;
    private String description;
    private ZonedDateTime jobTime;
    private ZonedDateTime rendevousTime;

    public JobModel() {
    }

    public JobModel(Long id, String address, String description, ZonedDateTime jobTime, ZonedDateTime rendevousTime) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.jobTime = jobTime;
        this.rendevousTime = rendevousTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getJobTime() {
        return jobTime;
    }

    public void setJobTime(ZonedDateTime jobTime) {
        this.jobTime = jobTime;
    }

    public ZonedDateTime getRendevousTime() {
        return rendevousTime;
    }

    public void setRendevousTime(ZonedDateTime rendevousTime) {
        this.rendevousTime = rendevousTime;
    }
}
