package org.csystem.application.service.rest.movie.data.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movie {
    public long id;
    public String name;
    public LocalDate sceneTime;
    public long rating;
    public BigDecimal cost;
    public float imdb;

    //...


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
}
