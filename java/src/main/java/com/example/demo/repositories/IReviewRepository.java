package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Review;

public interface IReviewRepository{
    Review save(Review review);
    List<Review> getReviewsOfRestaurant(Restaurant rest);
    boolean existsById(String uniqueId);
    Optional<Review> findById(String uniqueId);
    List<Review> findAll();
    void deleteById(String uniqueId);
    long count();
}