package com.guba.springbootcassandra.service;

import com.guba.springbootcassandra.model.User;
import com.guba.springbootcassandra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        log.info("Service: get all users");

        return userRepository.findAll();
    }

    public List<User> filterUsersByAgeGreaterThan(Integer age) {
        log.info("Service: filter users age greater than {}", age);

        return userRepository.findByAgeGreaterThan(age);
    }

    public void createUsers() {
        log.info("Service: create users");

        List<User> users = new ArrayList<>();
        users.add(new User(99, "guba", "Ciudad Evita", 25));
        users.add(new User(100, "ruba", "La Ferrere", 21));
        users.add(new User(101, "ouba", "Gonzales Catan", 30));
        users.add(new User(102, "vuba", "San Justo",35));

        userRepository.saveAll(users);
    }

    public User saveUser(User u) {
        log.info("Service: create user");

        return userRepository.save(u);
    }

    public void deleteUser(Integer id) {
        log.info("Service: delete user id {}", id);

        userRepository.deleteById(id);
    }
}
