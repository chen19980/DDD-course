package com.uuu.ddd.demo.demo1.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointType {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID typeId;
    private String type;
    private String description;

    public PointType(String type, String description) {
        this.type = type;
        this.description = description;
    }
}
