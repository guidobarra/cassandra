package com.guba.springbootcassandra.controller;

import com.guba.springbootcassandra.model.User;
import com.guba.springbootcassandra.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
        log.info("Controller: get all users");

        return userService.getUsers();
    }

    @GetMapping("/users/{age}")
    public List<User> getUsersFilterAge(@PathVariable Integer age) {
        log.info("Controller: get users filter by age greater than {}", age);

        return userService.filterUsersByAgeGreaterThan(age);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User u) {
        log.info("Controller: create user");

        return userService.saveUser(u);
    }
}
