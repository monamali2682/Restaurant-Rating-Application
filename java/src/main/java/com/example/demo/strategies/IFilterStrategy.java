package com.example.demo.strategies;

import java.util.List;
import com.example.demo.entities.Review;

public interface IFilterStrategy {

    List<Review> sortByLowHigh(List<Review> reviews, int low, int high);
    
}
