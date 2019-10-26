package com.example.bookstore.logic;


import com.example.bookstore.base.BasePresenter;
import com.example.bookstore.logic.remote.RemoteDataSourceImpl;
import com.example.bookstore.model.Movie;

import java.util.List;

import io.reactivex.Single;

//직접 DB에 다녀올 애.
public class RepositoryImpl<T> implements Repository {
    BasePresenter<T> presenter;
    DataSource remoteDataSource;

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = presenter;
        this.remoteDataSource = new RemoteDataSourceImpl();
        this.remoteDataSource.setRepository(this);
    }

    @Override
    public Single<List<Movie>> fetchMovies(int pageNum) {
        return remoteDataSource.fetchMovies(pageNum);
//        return null;
    }
}
