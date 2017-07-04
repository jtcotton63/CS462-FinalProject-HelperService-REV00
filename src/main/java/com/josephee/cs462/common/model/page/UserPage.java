package com.josephee.cs462.common.model.page;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.josephee.cs462.common.model.user.UserModel;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class UserPage extends PageImpl<UserModel> {

    @JsonCreator
    public UserPage(@JsonProperty("content") List<UserModel> content,
                    @JsonProperty("number") int number,
                    @JsonProperty("size") int size,
                    @JsonProperty("totalElements") Long totalElements) {
        super(
                content,
                new PageRequest(
                        number,
                        size
                        // TODO: Hey dummy don't forget that the sort is always null
                ),
                totalElements
        );
    }
}
