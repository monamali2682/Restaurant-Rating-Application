package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;
//import com.example.demo.entities.User;

public class RestaurantRepository implements IRestaurantRepository{
    HashMap<Long,Restaurant> map;
    Long autoIncrement =1L;

    public RestaurantRepository() {
        this.map = new HashMap<Long,Restaurant>();
    }

    @Override
    public Restaurant save(Restaurant restaurant){
        Restaurant r = new Restaurant(restaurant.getName(),autoIncrement);
        map.put(autoIncrement, r);
        autoIncrement++;
        return r;
    }

    public Restaurant modify(Restaurant restaurant) {
        map.put(restaurant.getId(),restaurant);
        return restaurant;
    }

    @Override
    public boolean existsById(Long id) {
        return map.containsKey(id);
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<Restaurant> findAll() {
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
