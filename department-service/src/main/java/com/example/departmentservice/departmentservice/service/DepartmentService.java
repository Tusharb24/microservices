package com.example.departmentservice.departmentservice.service;

import com.example.departmentservice.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.departmentservice.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.departmentservice.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDto saveDepartment(DepartmentDto departmentDto)
    {
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentCode(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentCode(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription()
        );

        return savedDepartmentDto;
    }

    public DepartmentDto getDepartmentByCode(String departmentCode)
    {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentCode(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
        return  departmentDto;
    }
}
