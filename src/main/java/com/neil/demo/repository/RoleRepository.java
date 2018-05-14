package com.neil.demo.repository;

import com.neil.demo.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {


}
