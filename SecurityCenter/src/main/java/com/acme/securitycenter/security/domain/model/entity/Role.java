package com.acme.securitycenter.security.domain.model.entity;

import com.acme.securitycenter.security.domain.model.enumeration.PostgreSQLEnumType;
import com.acme.securitycenter.security.domain.model.enumeration.Roles;
import com.acme.securitycenter.shared.domain.AuditModel;
import lombok.*;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "my_roles")
public class Role extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;
}
