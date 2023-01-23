package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

public class User {
    String name;
    Long id;
    Set<String> reviewIds;

    public User(String name, Long id) {
        this.name = name;
        this.id = id;
        this.reviewIds= new HashSet<>();
    }

    public User(String name) {
        this.name = name;
        this.reviewIds= new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void addReview(String reviewId){
        this.reviewIds.add(reviewId);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + "]";
    }
    
    
}
