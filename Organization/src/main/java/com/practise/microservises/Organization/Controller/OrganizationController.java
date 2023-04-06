package com.practise.microservises.Organization.Controller;

import com.practise.microservises.Organization.DTO.OrganizationDto;
import com.practise.microservises.Organization.Servise.OrganizationServise;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/organization")
public class OrganizationController {

    private OrganizationServise organizationServise;

    @PostMapping("/save")
    public ResponseEntity<OrganizationDto> save(@RequestBody OrganizationDto organizationDto){

    OrganizationDto dto= organizationServise.save(organizationDto);
    return  new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @GetMapping("/{organizationCode}")
    public ResponseEntity<OrganizationDto> findByCode(@PathVariable String organizationCode){
        OrganizationDto dto=organizationServise.getByCode(organizationCode);
        return   ResponseEntity.ok(dto);
    }
}
