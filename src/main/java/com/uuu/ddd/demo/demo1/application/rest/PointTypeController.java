package com.uuu.ddd.demo.demo1.application.rest;

import com.uuu.ddd.demo.demo1.application.rest.request.CreatePointTypeRequest;
import com.uuu.ddd.demo.demo1.application.rest.response.CreatePointTypeResponse;
import com.uuu.ddd.demo.demo1.application.rest.response.ListPointTypeResponse;
import com.uuu.ddd.demo.demo1.domain.PointType;
import com.uuu.ddd.demo.demo1.domain.common.service.PointTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/points")
public class PointTypeController {
    @Autowired
    private PointTypeService pointTypeService;

    @PostMapping
    CreatePointTypeResponse createPointType(@RequestBody CreatePointTypeRequest request) {
        PointType type = new PointType(request.getType(), request.getDescription());
        UUID id = pointTypeService.createPointType(type);
        return new CreatePointTypeResponse(id);
    }


    @GetMapping("/list")
    ListPointTypeResponse listPointTypeResponse() {
        ListPointTypeResponse response = new ListPointTypeResponse();
        response.setPointTypes(pointTypeService.allTypes());
        return response;
    }

}
