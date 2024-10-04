package com.upwork.demo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Feedback {

    @JsonProperty(value = "message")
    private String message;

}
