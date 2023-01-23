package com.example.demo.strategies;

import java.util.List;
import com.example.demo.entities.Review;

public interface IOrderStrategy {

    void arrangeByOrder(List<Review> reviews);
    
}
