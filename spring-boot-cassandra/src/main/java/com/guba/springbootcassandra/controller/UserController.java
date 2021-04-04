package com.guba.springbootcassandra.controller;

import com.guba.springbootcassandra.model.User;
import com.guba.springbootcassandra.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostConstruct
    public void saveUser() {
        userService.createUsers();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{age}")
    public List<User> getUsersFilterAge(@PathVariable Integer age) {
        return userService.filterUsersByAgeGreaterThan(age);
    }
}
