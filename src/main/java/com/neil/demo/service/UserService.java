package com.neil.demo.service;

import com.neil.demo.model.User;
import com.neil.demo.model.security.UserRole;

import java.util.Set;

public interface UserService  {

    User createUser(User user, Set<UserRole> userRoles);
}
