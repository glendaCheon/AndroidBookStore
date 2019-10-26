package com.example.bookstore.main;

import com.example.bookstore.base.BasePresenter;
import com.example.bookstore.base.BaseView;
import com.example.bookstore.model.Movie;

import java.util.List;

public class MainContract {

    //각 view에 어떤 기능이 필요할지 생각해본다(화면 기준)
    public interface View extends BaseView {
        //책 리스트 조회한 결과 view에 요청
        void fetchMoviesDone(List<Movie> list);
    }

    public interface Presenter extends BasePresenter<View>{
        //책 리스트 요청
        void fetchMovies(int pageNum);
    }
}
