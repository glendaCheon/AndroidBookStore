package com.example.bookstore.logic;

import com.example.bookstore.model.Movie;

import java.util.List;

import io.reactivex.Single;

public interface DataSource {
    void setRepository(Repository repository);
    Single<List<Movie>> fetchMovies(int pageNum); //비어도 instnace는 있기 때문에 null이 될 수는 없으니  signle
}
