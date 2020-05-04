package com.samuelcaetano.mymovies.Movie;

import java.util.Date;
import java.util.List;
import android.graphics.Bitmap;

public class Movie {
    public int id;
    public String title, genre, production, director;
    public Date date;
    public List<String> actors;
    public double rating;
    public Bitmap poster;

    public Movie(int id,
                 String title,
                 String genre,
                 String production,
                 String director,
                 Date date,
                 List<String> actors,
                 double rating,
                 Bitmap poster){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.production = production;
        this.director = director;
        this.date = date;
        this.actors = actors;
        this.rating = rating;
        this.poster = poster;
    }

    public String getInfo(){
        return "Title: " + title + "\n" +
                "Genre: " + genre + "\n" +
                "Production: " + production + "\n" +
                "Director: " + director + "\n" +
                "Date: " + date.toString() + "\n" +
                "Rating: " + rating + "\n" +
                "Actors: " + actors.toArray().toString();
    }

    public List<Movie> search(String search){
        return null;
    }

    public List<Movie> searchByDirector(String search){
        return null;
    }

    public List<Movie> searchByGenre(String search){
        return null;
    }

    public void showPoster(){

    }
}
