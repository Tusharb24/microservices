package com.example.organizartionservice.service;

import com.example.organizartionservice.dto.OrganizationDto;
import com.example.organizartionservice.entity.OrganizationEntity;
import com.example.organizartionservice.mapper.OrganizationMapper;
import com.example.organizartionservice.repository.OrganizationRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    OrganizationMapper organizationMapper;

    public OrganizationDto saveOrganization(OrganizationDto organizationDto)
    {
        OrganizationEntity organizationEntity = organizationMapper.organizationDtoToEntity(organizationDto);
        OrganizationEntity savedOrganization = organizationRepository.save(organizationEntity);
        return organizationMapper.organizationEntityToDto(savedOrganization);
    }

    public OrganizationDto getOrganizationByCode(String organizationCode)
    {
        OrganizationEntity organizationEntity = organizationRepository.getByOrganizationCode(organizationCode);
        return organizationMapper.organizationEntityToDto(organizationEntity);
    }
}
