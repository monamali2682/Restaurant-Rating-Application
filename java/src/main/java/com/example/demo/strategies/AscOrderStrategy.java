package com.example.demo.strategies;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.example.demo.entities.Review;

public class AscOrderStrategy implements IOrderStrategy {

    class AscComparator implements Comparator<Review>{

        @Override
        public int compare(Review review1, Review review2) {
            if(review1.getRating() < review2.getRating()){
                return -1;
            }else if (review1.getRating() > review2.getRating()){
                return 1;
            }
            return 0;    
        }
        
    }

    @Override
    public void arrangeByOrder(List<Review> reviews) {
        Collections.sort(reviews, new AscComparator());    
    }
    
}
