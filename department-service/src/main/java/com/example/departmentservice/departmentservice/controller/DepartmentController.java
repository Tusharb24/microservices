package com.example.departmentservice.departmentservice.controller;

import com.example.departmentservice.departmentservice.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.departmentservice.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto)
    {
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return  new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String departmentCode)
    {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.FOUND);
    }
}
