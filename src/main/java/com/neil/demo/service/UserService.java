package com.neil.demo.service;

import com.neil.demo.domain.User;
import com.neil.demo.domain.security.UserRole;

import java.util.Set;

public interface UserService  {

    User createUser(User user, Set<UserRole> userRoles);
}
