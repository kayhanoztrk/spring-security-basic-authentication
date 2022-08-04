package com.basicauthentication.sample.repository;
import com.basicauthentication.sample.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
