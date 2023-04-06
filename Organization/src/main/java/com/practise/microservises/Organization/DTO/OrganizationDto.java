package com.practise.microservises.Organization.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private int id;

    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
    private LocalDateTime createdDate;
}
