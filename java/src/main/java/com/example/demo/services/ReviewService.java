package com.example.demo.services;

import java.util.Arrays;
import java.util.List;
//import java.util.Set;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;
import com.example.demo.entities.User;
import com.example.demo.repositories.IReviewRepository;
import com.example.demo.repositories.RestaurantRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.strategies.AscOrderStrategy;
import com.example.demo.strategies.DescOrderStrategy;
import com.example.demo.strategies.FilterStrategy;
import com.example.demo.strategies.IFilterStrategy;
import com.example.demo.strategies.IOrderStrategy;

public class ReviewService {
    UserRepository userRepository;
    RestaurantRepository restaurantRepository;
    IReviewRepository reviewrepository;
    
    IFilterStrategy filterStrategy;
    IOrderStrategy orderStrategy;

    public ReviewService(UserRepository userRepository, RestaurantRepository restaurantRepository,
            IReviewRepository reviewrepository) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.reviewrepository = reviewrepository;
    }

    public void addRating(Double rating, Long userId, Long restId, String dishes, String description){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id: " + userId + " not found!"));
        Restaurant restaurant = restaurantRepository.findById(restId).orElseThrow(() -> new RuntimeException("Restaurant with id: " + restId + " not found!"));
        String uniqueId = userId.toString() + "_" + restId.toString();
        //create review
        Review r = new Review(userId,restId,uniqueId,rating,dishes,description);
        // save review
        Review review = reviewrepository.save(r);
        // modify rating of restaurant
        restaurant.modifyRating(rating);
        // add review uniq id to users review list & save back the modified user
        user.addReview(review.getUniqueId());
        userRepository.modify(user);
        // add review uniq id to restaurants review list & save back the modified restaurant
        restaurant.addReview(review.getUniqueId());
        restaurantRepository.modify(restaurant);
        System.out.println(review +" added successfully for " + restaurant + " by "+ user +"!");
    }

    public void getRatingsByOrder(Long id, String order) {
        // first get all reviews of restaurant from review repository
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant with id: " + id + " not found!"));
        List<Review> reviews = reviewrepository.getReviewsOfRestaurant(restaurant);
        // choode order Strategy
        if(order.equals("RATING_DESC")){
            orderStrategy = new DescOrderStrategy();
        }else{
            orderStrategy = new AscOrderStrategy();
        }
        // call appropriate method on on orderStrategy
        orderStrategy.arrangeByOrder(reviews);
        System.out.println(Arrays.toString(reviews.toArray()));
    }

    public void getRatingsByFilterOrder(Long id, int low, int high, String order) {
        // first get all reviews of restaurant from review repository
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant with id: " + id + " not found!"));
        List<Review> reviews = reviewrepository.getReviewsOfRestaurant(restaurant);

        // choose filter strategy
        filterStrategy = new FilterStrategy();
        // call appropriate method on filter strategy
        List<Review> filteredReviews = filterStrategy.sortByLowHigh(reviews,low,high);

        // choode order Strategy
        if(order.equals("RATING_DESC")){
            orderStrategy = new DescOrderStrategy();
        }else{
            orderStrategy = new AscOrderStrategy();
        }
        // call appropriate method on on orderStrategy
        orderStrategy.arrangeByOrder(filteredReviews);
        System.out.println(Arrays.toString(filteredReviews.toArray()));
    }


    
}
