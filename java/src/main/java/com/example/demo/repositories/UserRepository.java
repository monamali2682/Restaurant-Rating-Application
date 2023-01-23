package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.User;

public class UserRepository implements IUserRepository{
    HashMap<Long,User> map;
    Long autoIncrement=1L;

    public UserRepository() {
        this.map = new HashMap<Long,User>();
    }
    
    @Override
    public User save(User user) {
        User u = new User(user.getName(),autoIncrement);
        map.put(autoIncrement,u);
        ++autoIncrement;
        return u;
    }

    public User modify(User user) {
        map.put(user.getId(),user);
        return user;
    }

    @Override
    public boolean existsById(Long id) {
        return map.containsKey(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<User> findAll() {
        return map.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public long count() {
        return map.size();
    }
    
}
