package com.acme.learningcenter.security.domain.persistence;

import com.acme.learningcenter.security.domain.model.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
