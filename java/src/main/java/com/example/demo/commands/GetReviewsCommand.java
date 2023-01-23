package com.example.demo.commands;

import java.util.List;

//import com.example.demo.entities.Greeting;
//import com.example.demo.services.GreetingService;
import com.example.demo.services.ReviewService;

public class GetReviewsCommand implements ICommand{
    
    ReviewService reviewService;

    public GetReviewsCommand(ReviewService reviewService) {
        this.reviewService=reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long id = Long.parseLong(tokens.get(1));
        String order = tokens.get(2);
        reviewService.getRatingsByOrder(id,order);    
    }
    
}