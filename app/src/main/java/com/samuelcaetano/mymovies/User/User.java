package com.samuelcaetano.mymovies.User;

import com.samuelcaetano.mymovies.Movie.Movie;

import java.util.List;

public class User {
    private int userID;
    private String name;
    private String email;
    private String password;
    public List<Integer> favoriteMovieIDs;

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean register(){
        return true;
    }

    public boolean login(){
        return true;
    }

    public boolean resetPassword(){

        return true;
    }

    public void addToFav(Movie movie){

    }
}
