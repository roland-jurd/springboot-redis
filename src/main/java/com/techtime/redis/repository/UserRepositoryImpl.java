package com.techtime.redis.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.techtime.redis.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
    
    private static final String USER_KEY = "USER";
    
    private HashOperations hashOperations;
    
    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        hashOperations = redisTemplate.opsForHash();
    }
    
    @Override
    public void save(User user) {
        hashOperations.put(USER_KEY, user.getId(), user);
    }
    
    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries(USER_KEY);
    }
    
    @Override
    public User findById(String id) {
        return (User)hashOperations.get(USER_KEY, id);
    }
    
    @Override
    public void update(User user) {
        save(user);
    }
    
    @Override
    public void delete(String id) {
        hashOperations.delete(USER_KEY, id);
    }
}
