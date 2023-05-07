package com.example.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrganizationDto {

    private Long id;
    private String organizationName;
    private String organizationCode;
    private String organizationDescription;
    @CreationTimestamp
    private LocalDateTime createdDate;
}
