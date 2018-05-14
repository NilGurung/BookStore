package com.neil.demo.repository;

import com.neil.demo.model.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {


}
