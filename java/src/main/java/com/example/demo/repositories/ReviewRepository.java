package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;

public class ReviewRepository implements IReviewRepository{
    HashMap<String, Review> map;
    Long autoIncrement=1L;
    public ReviewRepository() {
        this.map = new HashMap<String, Review>();
    }


    public Review save(Review r){
        Review review = new Review(autoIncrement, r.getUserId(), r.getRestId(), r.getUniqueId(),r.getRating(),r.getListOfDishes(),r.getDescription());
        map.put(review.getUniqueId(),review);
        autoIncrement++;
        return review;
    }

    public List<Review> getReviewsOfRestaurant(Restaurant rest){
        List<Review> reviews = new ArrayList<>();
        for(String uniqueId : rest.getReviewIds()){
            Review review = map.get(uniqueId);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public boolean existsById(String uniqueId) {
        return map.containsKey(uniqueId);
    }


    @Override
    public Optional<Review> findById(String uniqueId) {
        return Optional.ofNullable( map.get(uniqueId));
    }


    @Override
    public List<Review> findAll() {
        List<Review>reviews= map.values().stream().collect(Collectors.toList());
        return reviews;
    } 


    @Override
    public void deleteById(String uniqueId) {
        map.remove(uniqueId);
    }


    @Override
    public long count() {
        return map.size();
    }
    
}
