package com.axiom.search.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseDto {
    @JsonProperty
    private String announceDate;
    @JsonProperty
    private int priceEur;
}
