package com.acme.securitycenter.security.api;

import com.acme.securitycenter.security.domain.service.RoleService;
import com.acme.securitycenter.security.mapping.RoleMapper;
import com.acme.securitycenter.security.resource.RoleResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/roles")
public class RolesController {
    private final RoleService roleService;

    private final RoleMapper mapper;

    public RolesController(RoleService roleService, RoleMapper mapper) {
        this.roleService = roleService;
        this.mapper = mapper;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('INSTRUCTOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getAllRoles(Pageable pageable) {
        Page<RoleResource> resources = mapper.modelListToPage(roleService.getAll(), pageable);
        return ResponseEntity.ok(resources);
    }


}
