package com.kuisma.showlist.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String title, creators, watched;
    @NotNull
    private int firstAired;
    private double imdbRating;// imdb ratingin voin ehkä hakea API:lla?
    @NotNull
    private double myRating;

    @ManyToOne
    @JoinColumn(name = "kategoria_id")
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
