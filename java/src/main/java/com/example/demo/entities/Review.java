package com.example.demo.entities;

public class Review {
    Long id;
    Long userId;
    Long restId;
    String uniqueId;
    Double rating;
    String listOfDishes;
    String description;


    /// for review before saving ( rating will be review with empty dish & description)
    public Review(Long userId, Long restId, String uniqueId, Double rating, String listOfDishes,
            String description) {
        this.userId = userId;
        this.restId = restId;
        this.uniqueId = uniqueId;
        this.rating = rating;
        this.listOfDishes = listOfDishes;
        this.description = description;
        this.rating=rating;
    }
    // for review after saving
    public Review(Long id, Long userId, Long restId, String uniqueId, Double rating,
            String listOfDishes, String description) {
        this.id = id;
        this.userId = userId;
        this.restId = restId;
        this.uniqueId = uniqueId;
        this.rating = rating;
        this.listOfDishes = listOfDishes;
        this.description = description;
        this.rating=rating;
    }

    public Long getId() {
        return id;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public Long getUserId() {
        return userId;
    }
    public Long getRestId() {
        return restId;
    }
    public Double getRating() {
        return rating;
    }
    public String getListOfDishes() {
        return listOfDishes;
    }
    public String getDescription() {
        return description;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uniqueId == null) ? 0 : uniqueId.hashCode());
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
        Review other = (Review) obj;
        if (uniqueId == null) {
            if (other.uniqueId != null)
                return false;
        } else if (!uniqueId.equals(other.uniqueId))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Review [id=" + id + "]";
    }
    
}
