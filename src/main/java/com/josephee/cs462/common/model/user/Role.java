package com.josephee.cs462.common.model.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Role {

    ADMIN(1L, "Admin"),
    HELPER(2L, "Helper");

    private Long id;
    private String name;

    Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonCreator
    public static Role from(@JsonProperty("id") Long id,
                            @JsonProperty("name") String name) {
        try {
            if (id != null)
                return from(id);
        } catch (IllegalArgumentException e) {
            // Do nothing intentionally
        }

        return from(name);
    }

    public static Role from(Long id) {
        if(id == null)
            throw new IllegalArgumentException("Cannot instantiate role from null ID");

        for(Role role: Role.values())
            if(role.getId().equals(id))
                return role;

        throw new IllegalArgumentException("Cannot instantiate role from ID " + id);
    }

    public static Role from(String name) {
        if(name == null)
            throw new IllegalArgumentException("Cannot instantiate role from null name");

        if(name.isEmpty())
            throw new IllegalArgumentException("Cannot instantiate role from empty name");

        String asUpperCase = name.toUpperCase();
        for(Role role: Role.values())
            if(role.getName().toUpperCase().equals(asUpperCase))
                return role;

        throw new IllegalArgumentException("Cannot instantiate role from name " + name);
    }
}
