package com.example.rentit.repositories;

import java.util.List;
import java.util.Set;

import com.example.rentit.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Set<Role> findByName(String name);
}