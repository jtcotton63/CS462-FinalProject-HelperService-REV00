package com.josephee.cs462.common.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Clock;
import java.time.Instant;

public class CreateEvent<T> {

    private T newValue;
    private Instant createdAt;

    @JsonCreator
    public CreateEvent(@JsonProperty("newValue") T newValue, @JsonProperty("createdAt") Instant createdAt) {
        this.newValue = newValue;
        this.createdAt = createdAt;
    }

    public CreateEvent(T newValue) {
        this.newValue = newValue;
        this.createdAt = Instant.now(Clock.systemUTC());
    }

    public T getNewValue() {
        return newValue;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        String newValueString = newValue == null ? "null" : newValue.toString();
        String createdAtString = createdAt == null ? "null" : createdAt.toString();
        return "CreateEvent(newValue=" + newValueString + ", createdAt=" + createdAtString + ")";
    }
}
