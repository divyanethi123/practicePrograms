package com.practise.microservises.Organization.Servise.impl;

import com.practise.microservises.Organization.DTO.OrganizationDto;
import com.practise.microservises.Organization.Entity.Organization;
import com.practise.microservises.Organization.Mapping.OrganizationMapping;
import com.practise.microservises.Organization.Repository.OrganizationRepo;
import com.practise.microservises.Organization.Servise.OrganizationServise;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiseImpl implements OrganizationServise {

    private OrganizationRepo repo;


    @Override
    public OrganizationDto save(OrganizationDto organizationDto) {
        Organization organization=OrganizationMapping.mapToOrganization(organizationDto);
         Organization organization1=repo.save(organization);

         OrganizationDto organizationDto1=OrganizationMapping.mapToOrganizationDto(organization1);

         return organizationDto1;
    }

    @Override
    public OrganizationDto getByCode(String organizationCode) {
        Organization organization=repo.getByOrganizationCode(organizationCode);

        return OrganizationMapping.mapToOrganizationDto(organization);
    }
}
