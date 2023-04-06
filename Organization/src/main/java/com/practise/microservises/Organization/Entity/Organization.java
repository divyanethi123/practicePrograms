package com.practise.microservises.Organization.Entity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String organizationName;
    private String organizationDescription;
    @Column(unique = true,nullable = false)
    private String organizationCode;
    @CreationTimestamp
    private LocalDateTime createdDate;
}
