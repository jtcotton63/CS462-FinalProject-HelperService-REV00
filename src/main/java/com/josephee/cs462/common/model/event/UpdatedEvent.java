package com.josephee.cs462.common.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Clock;
import java.time.Instant;

public class UpdatedEvent<T> {

    private T oldValue;
    private T newValue;
    private Instant updatedAt;

    @JsonCreator
    public UpdatedEvent(@JsonProperty("newValue") T oldValue, @JsonProperty("newValue") T newValue, @JsonProperty("updatedAt") Instant updatedAt) {
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.updatedAt = updatedAt;
    }

    public UpdatedEvent(T oldValue, T newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.updatedAt = Instant.now(Clock.systemUTC());
    }

    public T getOldValue() {
        return oldValue;
    }

    public T getNewValue() {
        return newValue;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        String oldValueString = oldValue == null ? "null" : oldValue.toString();
        String newValueString = newValue == null ? "null" : newValue.toString();
        String updatedAtString = updatedAt == null ? "null" : updatedAt.toString();
        return "UpdateEvent(oldValue=" + oldValueString + ", newValue=" + newValueString + ", updatedAt=" + updatedAtString + ")";
    }
}
