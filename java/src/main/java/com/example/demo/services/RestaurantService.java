package com.example.demo.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.IRestaurantRepository;

public class RestaurantService {
    IRestaurantRepository restaurantRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant register(String name){
        Restaurant restaurant = new Restaurant(name);
        return restaurantRepository.save(restaurant);
    }

    public void describeRestaurant(Long id) {
        Restaurant rest = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant with id " + id + " not found!"));
        String restInfo = "Restaurant [id=" + id + ", name=" + rest.getName() + ", rating=" + rest.getAvgRating() + "]";
        System.out.println(restInfo); 
    }

    public void getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        Collections.sort(restaurants, new RestaurantComparator());
        System.out.println(Arrays.toString(restaurants.toArray()));
    }


    class RestaurantComparator implements Comparator<Restaurant>{
        @Override
        public int compare(Restaurant rest1, Restaurant rest2) {
            if(rest1.getAvgRating()>rest2.getAvgRating()){
                return -1;
            }else if (rest1.getAvgRating() < rest2.getAvgRating()){
                return 1;
            }
            return 0;
        }  
    }
    
}
