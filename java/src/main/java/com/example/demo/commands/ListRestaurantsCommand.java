package com.example.demo.commands;

import java.util.List;
//import javax.swing.Icon;
import com.example.demo.services.RestaurantService;

public class ListRestaurantsCommand implements ICommand{
    RestaurantService restaurantService;
    

    public ListRestaurantsCommand(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void invoke(List<String> tokens) {
        restaurantService.getAllRestaurants();
    }
    
}
