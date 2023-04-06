package com.practise.microservises.Organization.Repository;

import com.practise.microservises.Organization.Entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepo extends JpaRepository<Organization,Integer>{
    Organization getByOrganizationCode(String organizationCode);
}
