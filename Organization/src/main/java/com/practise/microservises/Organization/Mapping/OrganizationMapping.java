package com.practise.microservises.Organization.Mapping;

import com.practise.microservises.Organization.DTO.OrganizationDto;
import com.practise.microservises.Organization.Entity.Organization;

public class OrganizationMapping {

    public static OrganizationDto mapToOrganizationDto(Organization organization){
        OrganizationDto dto=new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()
        );
        return  dto;
    }

    public static Organization mapToOrganization(OrganizationDto dto){
        Organization organization=new Organization(
                dto.getId(),
                dto.getOrganizationName(),
                dto.getOrganizationDescription(),
                dto.getOrganizationCode(),
                dto.getCreatedDate()
        );
        return  organization;
    }
}
