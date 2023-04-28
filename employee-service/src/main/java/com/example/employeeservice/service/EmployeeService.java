package com.example.employeeservice.service;

import com.example.employeeservice.dto.DepartmentDto;
import com.example.employeeservice.dto.EmployeeDepartmentDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto)
    {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );

        return savedEmployeeDto;
    }

    public EmployeeDepartmentDto getEmployeeById(String id) {
        Employee employee = employeeRepository.findById(Long.valueOf(id)).orElse(null);

        //Call Get Department by department code service
        ResponseEntity<DepartmentDto> responseEntity =  restTemplate.getForEntity(
                "http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        EmployeeDepartmentDto employeeDepartmentDto = new EmployeeDepartmentDto(
                employeeDto, departmentDto
        );
        return employeeDepartmentDto;
    }
}