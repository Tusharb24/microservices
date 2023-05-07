package com.example.organizartionservice.repository;

import com.example.organizartionservice.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {

    OrganizationEntity getByOrganizationCode(String organizationCode);
}
