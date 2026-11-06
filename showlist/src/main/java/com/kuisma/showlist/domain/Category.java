package com.kuisma.showlist.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "kategoria", nullable = false)
    private String kategoria;

    @OneToMany(mappedBy = "category")
    private List<Show> shows = new ArrayList<>();

    public Category() {

    }

    public Category(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public Long getId() {
        return id;
    }
}
