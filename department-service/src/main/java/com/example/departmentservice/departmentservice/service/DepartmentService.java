package com.example.departmentservice.departmentservice.service;

import com.example.departmentservice.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.departmentservice.entity.Department;
import com.example.departmentservice.departmentservice.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.departmentservice.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;

    public DepartmentDto saveDepartment(DepartmentDto departmentDto)
    {
        Department department = departmentMapper.departmentDtoToEntity(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = departmentMapper.departmentEntityToDto(savedDepartment);

        return savedDepartmentDto;
    }

    public DepartmentDto getDepartmentByCode(String departmentCode)
    {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = departmentMapper.departmentEntityToDto(department);
        return  departmentDto;
    }
}
