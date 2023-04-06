package com.practise.microservises.Organization.Servise;

import com.practise.microservises.Organization.DTO.OrganizationDto;

public interface OrganizationServise {

    public OrganizationDto save(OrganizationDto organizationDto);
    public OrganizationDto getByCode(String organizationCode);
}
