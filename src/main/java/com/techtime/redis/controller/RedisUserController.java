package com.techtime.redis.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.techtime.redis.model.User;
import com.techtime.redis.repository.UserRepository;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/redis/users")
public class RedisUserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/test")
    public String test() {
        return "Redis user service is up";
    }
    
    @ApiOperation(value = "Get all users")
    @GetMapping("/all")
    public Map<String, User> getAll() {
        return userRepository.findAll();
    }
    
    @ApiOperation(value = "Get user by id")
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") String id) {
        return userRepository.findById(id);
    }
    
    @ApiOperation(value = "Add user")
    @PostMapping("/add")
    public User add(@RequestBody User user) {
        userRepository.save(user);
        return userRepository.findById(user.getId());
    }
    
    @ApiOperation(value = "Update user")
    @PutMapping("/update/")
    public User update(@RequestBody User user) {
        userRepository.update(user);
        return getById(user.getId());
    }
    
    @ApiOperation(value = "Delete user by id")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        userRepository.delete(id);
    }
}
