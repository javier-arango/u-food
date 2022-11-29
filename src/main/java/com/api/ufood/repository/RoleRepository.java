package com.api.ufood.repository;

import com.api.ufood.model.user.Role;
import com.api.ufood.model.user.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(UserRoles role);
}
