package com.example.demo.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.entities.Review;

public class FilterStrategy implements IFilterStrategy{
    public List<Review> sortByLowHigh(List<Review> reviews,int low, int high){
        List<Review> filteredReviews = new ArrayList<>();
        filteredReviews= reviews.stream().filter(r -> (r.getRating()>=low & r.getRating()<=high)).collect(Collectors.toList());
        return filteredReviews; 
    }
}
