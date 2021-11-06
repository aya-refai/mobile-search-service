package com.axiom.search.api.boundary.helper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class MobileDto implements Serializable {

    @JsonProperty
    private int id;
    @JsonProperty
    private String brand;
    @JsonProperty
    private String phone;
    @JsonProperty
    private String picture;
    @JsonProperty
    private ReleaseDto release;
    @JsonProperty
    private String sim;
    @JsonProperty
    private String resolution;
    @JsonProperty
    private HardwareDto hardware;
}