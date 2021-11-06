package com.axiom.search.api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "MobileHandset")
public class MobileHandsetEntity {

    @Id
    private int id;
    private String brand;
    private String phone;
    private String picture;
    private ReleaseEntity release;
    private String sim;
    private String resolution;
    private HardwareEntity hardware;
}
