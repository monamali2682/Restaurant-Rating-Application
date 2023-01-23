package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewService;

public class GetReviewsFilterOrderCommand implements ICommand{
    ReviewService reviewService;

    public GetReviewsFilterOrderCommand(ReviewService reviewService) {
        this.reviewService=reviewService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long id = Long.parseLong(tokens.get(1));
        int low = Integer.parseInt(tokens.get(2));
        int high = Integer.parseInt(tokens.get(3));
        String order = tokens.get(4);
        reviewService.getRatingsByFilterOrder(id,low,high,order);    
    }
}
//GET_REVIEWS_FILTER_ORDER 2 2 5 RATING_DESC
