package com.josephee.cs462.common.model.job;

import java.time.ZonedDateTime;

public class JobModel {

    private Long id;
    private String address;
    private String description;
    private ZonedDateTime jobTime;
    private ZonedDateTime rendevousTime;
    private Long acceptedBy;
    private boolean completed;

    public JobModel() {
        this.completed = false;
    }

    public JobModel(Long id, String address, String description, ZonedDateTime jobTime, ZonedDateTime rendevousTime, Long acceptedBy, boolean completed) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.jobTime = jobTime;
        this.rendevousTime = rendevousTime;
        this.acceptedBy = acceptedBy;
        this.completed = completed;
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

    public Long getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(Long acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JobModel{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", jobTime=" + jobTime +
                ", rendevousTime=" + rendevousTime +
                ", acceptedBy=" + acceptedBy +
                ", completed=" + completed +
                '}';
    }
}
