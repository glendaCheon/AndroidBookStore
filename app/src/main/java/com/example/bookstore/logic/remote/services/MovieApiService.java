package com.example.bookstore.logic.remote.services;

import com.example.bookstore.model.ResponseMovie;


import io.reactivex.Single;
import retrofit2.http.GET;

/** Movie와 관련된 내용을 얻는다. */
public interface MovieApiService {
    @GET("list_movies.json")
//    Single<List<Movie>> fetchMovies(); //사이트에서 json 데이터가 바로 movie를 던져주지 않기 때문.
    Single<ResponseMovie> fetchMovies();
}
