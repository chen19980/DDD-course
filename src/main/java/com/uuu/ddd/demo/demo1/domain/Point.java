package com.uuu.ddd.demo.demo1.domain;

import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class Point {
    PointType type;
    PointStatus status;
    float value;

    public Point(PointType type, PointStatus status, float value) {
        this.type = type;
        this.status = status;
        this.value = value;
    }
}
