package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

public class Restaurant {
    String name;
    long id;
    Set<String> reviewIds; // ratings are reviews with empty description
    Double avgRating;
    Double totalRating;
    int numberOfRatings; // = size of reviewIds


    public Restaurant(String name, long id) {
        this.name = name;
        this.id = id;
        this.reviewIds= new HashSet<>();
        this.avgRating=0.0;
        this.totalRating=0.0;
        this.numberOfRatings=0;
    }

    public Restaurant(String name) {
        this.name = name;
        this.reviewIds= new HashSet<>();
    }

    public void modifyRating(Double newRating){
        Double totalRatingNew = this.totalRating+ newRating;
        int numberOfRatingsNew = this.reviewIds.size()+ 1;
        double newAvgRating = (totalRatingNew)/(numberOfRatingsNew);
        this.setAvgRating(newAvgRating);
        this.setNumberOfRatings(numberOfRatingsNew);
        this.setTotalRating(totalRatingNew);
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public void setTotalRating(Double totalRating) {
        this.totalRating = totalRating;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void addReview(String reviewId){
        this.reviewIds.add(reviewId);
    }

    public Set<String> getReviewIds() {
        return reviewIds;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public Double getTotalRating() {
        return totalRating;
    }

    @Override
    public String toString() {
        return "Restaurant [id=" + id + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Restaurant other = (Restaurant) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
}
