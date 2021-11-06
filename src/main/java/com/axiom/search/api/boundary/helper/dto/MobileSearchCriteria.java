package com.axiom.search.api.boundary.helper.dto;

import lombok.Data;

@Data
public class MobileSearchCriteria {

    private Integer id;
    private Integer priceEur;
    private String announceDate;
    private String brand;
    private String phone;
    private String sim;
    private String resolution;
    private String audioJack;
    private String gps;
    private String battery;

}
