package com.techtime.redis.controller;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techtime.redis.model.User;
import com.techtime.redis.repository.UserRepository;


@RestController
@RequestMapping("/redis/users")
public class RedisUserController {
    
    private UserRepository userRepository;
    
    public RedisUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping("/test")
    public String testRedisService() {
        return "Redis user service is up 3";
    }
    
    @GetMapping("/all")
    public Map<String, User> getAll() {
        System.out.println("ALL TEST");
        return userRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") String id) {
        return userRepository.findById(id);
    }
    
    
    @PostMapping("/add")
    public User add(@RequestBody User user) {
        userRepository.save(user);
        return userRepository.findById(user.getId());
    }
    
    @PutMapping("/update/")
    public User update(@RequestBody User user) {
        userRepository.update(user);
        return getById(user.getId());
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        userRepository.delete(id);
    }
    
    
}
