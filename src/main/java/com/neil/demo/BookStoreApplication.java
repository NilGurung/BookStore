package com.neil.demo;

import com.neil.demo.config.SecurityUtility;
import com.neil.demo.model.User;
import com.neil.demo.model.security.Role;
import com.neil.demo.model.security.UserRole;
import com.neil.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {


        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Adams");
        user1.setUsername("j");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
        user1.setEmail("j@gmail.com");
        user1.setEmail("j@gmail.com");

        Set<UserRole> userRoles = new HashSet<>();

        Role role1 = new Role();
        role1.setRoleId(1);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles);

        userRoles.clear();



        User user2 = new User();
        user2.setFirstName("Kris");
        user2.setLastName("Adams");
        user2.setUsername("k");
        user2.setPassword(SecurityUtility.passwordEncoder().encode("g"));
        user2.setEmail("k@gmail.com");

        Set<UserRole> userRole2 = new HashSet<>();

        Role role2 = new Role();
        role2.setRoleId(1);
        role2.setName("ROLE_USER");
        userRole2.add(new UserRole(user2, role2));

        userService.createUser(user2, userRole2);

    }



}
