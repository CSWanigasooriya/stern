package com.flaze.stern.controllers;

import com.flaze.stern.models.entities.UserEntity;
import com.flaze.stern.repositories.UserEntityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserEntityRepository userRepository;

    public UserController(UserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public ResponseEntity<List<UserEntity>> getAll() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("users/{uid}")
    public ResponseEntity<UserEntity> getById(@PathVariable String uid) {
        Optional<UserEntity> user = userRepository.findById(uid);
        return user.map(userEntity -> new ResponseEntity<>(userEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity newUser) {
        UserEntity user = userRepository.save(newUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
