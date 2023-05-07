package com.example.employeeservice.service;

import com.example.employeeservice.dto.DepartmentDto;
import com.example.employeeservice.dto.APIResponse;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.dto.OrganizationDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.mapper.EmployeeMapper;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto)
    {
        Employee employee = employeeMapper.employeeDtoToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = employeeMapper.employeeEntityToDto(savedEmployee);

        return savedEmployeeDto;
    }

    public APIResponse getEmployeeById(String id) {
        Employee employee = employeeRepository.findById(Long.valueOf(id)).orElse(null);

        //Call Get Department by department code service
        ResponseEntity<DepartmentDto> responseEntity =  restTemplate.getForEntity(
              "http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode(),
               DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                 .uri("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode())
//                 .retrieve()
//                 .bodyToMono(DepartmentDto.class)
//                 .block();

        EmployeeDto employeeDto = employeeMapper.employeeEntityToDto(employee);

        ResponseEntity<OrganizationDto> orgResponseEntity =  restTemplate.getForEntity(
                "http://ORGANIZATION-SERVICE/api/organizations/" + employee.getOrganizationCode(),
                OrganizationDto.class);

        OrganizationDto organizationDto = orgResponseEntity.getBody();

        APIResponse employeeDepartmentDto = new APIResponse(
                employeeDto, departmentDto, organizationDto
        );
        return employeeDepartmentDto;
    }
}
