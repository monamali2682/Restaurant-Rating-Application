package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;

public class AddReviewCommand implements ICommand{
    ReviewService reviewService;

    public AddReviewCommand(ReviewService reviewService) {
        this.reviewService=reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Double rating = Double.parseDouble(tokens.get(1));
        Long userId = Long.parseLong(tokens.get(2));
        Long restaurantId = Long.parseLong(tokens.get(3));
        String dishes = tokens.get(4);
        String description = tokens.get(5);
        reviewService.addRating(rating,userId,restaurantId,dishes,description);
    }
    
}
