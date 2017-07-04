package com.josephee.cs462.common.model.page;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.josephee.cs462.common.model.helper.HelperModel;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class HelperPage extends PageImpl<HelperModel> {

    @JsonCreator
    public HelperPage(@JsonProperty("content") List<HelperModel> content,
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
