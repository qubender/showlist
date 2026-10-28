package com.kuisma.showlist.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Show {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title, creators, watched;
    private int firstAired;
    private double imdbRating, myRating;
    
    public Show(String title, String creators, String watched, int firstAired, double imdbRating, double myRating) {
        this.title = title;
        this.creators = creators;
        this.watched = watched;
        this.firstAired = firstAired;
        this.imdbRating = imdbRating;
        this.myRating = myRating;
    }

    public Show() {
        
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCreators() {
        return creators;
    }
    public void setCreators(String creators) {
        this.creators = creators;
    }
    public String getWatched() {
        return watched;
    }
    public void setWatched(String watched) {
        this.watched = watched;
    }
    public int getFirstAired() {
        return firstAired;
    }
    public void setFirstAired(int firstAired) {
        this.firstAired = firstAired;
    }
    public double getImdbRating() {
        return imdbRating;
    }
    public void setImdbRating(double imdbRating) {
        imdbRating = imdbRating;
    }
    public double getMyRating() {
        return myRating;
    }
    public void setMyRating(double myRating) {
        myRating = myRating;
    }

    


}
