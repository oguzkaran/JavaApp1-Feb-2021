package org.csystem.application.service.rest.movie.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    public long id;

    @Column(nullable = false)
    public String name;

    @Column(name= "scene_time", nullable = false)
    public LocalDate sceneTime;

    @Column(nullable = false)
    public long rating;

    @Column(nullable = false)
    public BigDecimal cost;

    @Column(nullable = false)
    public float imdb;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    public Set<Director> directors = new HashSet<>();

    public Movie()
    {
    }

    public Movie(String name, LocalDate sceneTime, long rating, BigDecimal cost, float imdb)
    {
        this(0, name, sceneTime, rating, cost, imdb);
    }

    public Movie(long id, String name, LocalDate sceneTime, long rating, BigDecimal cost, float imdb)
    {
        this.id = id;
        this.name = name;
        this.sceneTime = sceneTime;
        this.rating = rating;
        this.cost = cost;
        this.imdb = imdb;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getSceneTime()
    {
        return sceneTime;
    }

    public void setSceneTime(LocalDate sceneTime)
    {
        this.sceneTime = sceneTime;
    }

    public long getRating()
    {
        return rating;
    }

    public void setRating(long rating)
    {
        this.rating = rating;
    }

    public BigDecimal getCost()
    {
        return cost;
    }

    public void setCost(BigDecimal cost)
    {
        this.cost = cost;
    }

    public float getImdb()
    {
        return imdb;
    }

    public void setImdb(float imdb)
    {
        this.imdb = imdb;
    }

    @Override
    public String toString()
    {
        return String.format("[%d]%s-%s-%d-%s-%f", id, name, sceneTime, rating, cost, imdb);
    }
}
