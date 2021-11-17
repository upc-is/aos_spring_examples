package com.acme.securitycenter.security.domain.service;

import com.acme.securitycenter.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {

    void seed();

    List<Role> getAll();
}
