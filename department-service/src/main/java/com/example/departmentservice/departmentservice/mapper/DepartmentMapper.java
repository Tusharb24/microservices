package com.example.departmentservice.departmentservice.mapper;

import com.example.departmentservice.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.departmentservice.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentDto departmentEntityToDto(Department department)
    {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentCode(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    public Department departmentDtoToEntity(DepartmentDto departmentDto)
    {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentCode(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
