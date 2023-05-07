package com.example.organizartionservice.mapper;

import com.example.organizartionservice.dto.OrganizationDto;
import com.example.organizartionservice.entity.OrganizationEntity;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper {

    public OrganizationEntity organizationDtoToEntity(OrganizationDto organizationDto) {
        return new OrganizationEntity(organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationCode(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getCreatedDate());
    }

    public OrganizationDto organizationEntityToDto(OrganizationEntity organizationEntity) {
        return new OrganizationDto(organizationEntity.getId(),
                organizationEntity.getOrganizationName(),
                organizationEntity.getOrganizationCode(),
                organizationEntity.getOrganizationDescription(),
                organizationEntity.getCreatedDate());
    }
}
