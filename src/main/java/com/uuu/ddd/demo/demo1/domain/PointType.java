package com.uuu.ddd.demo.demo1.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class PointType {
    private UUID typeId;
    private String type;
    private String description;

    public PointType(String type, String description) {
        this.type = type;
        this.description = description;
    }
}
