package com.uuu.ddd.demo.demo1.application.rest.response;

import com.uuu.ddd.demo.demo1.domain.PointType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPointTypeResponse {
    private List<PointType> pointTypes;
}
