package com.axiom.search.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HardwareEntity {
    private String audioJack;
    private String gps;
    private String battery;
}
