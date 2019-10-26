package com.example.bookstore.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.R;
import com.example.bookstore.base.BaseActivity;
import com.example.bookstore.model.Movie;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter> implements MainContract.View{
    @BindView(R.id.btnFetchMovies)
    Button btnFetchItems;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    int startPageNum = 1;

//    List<Movie> movies = null; // null이면 getSize쪽에서 에러 나므로
    List<Movie> movies = new ArrayList();

    @Override
    protected MainContract.Presenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button btnFetchItems = findViewById(R.id.btnFetchMovies);

//        btnFetchItems.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //TODO 클릭 시 Presenter로 다운스트림 발생.(view > presenter)니까 다운 스트림.
//                mPresenter.fetchMovies(1);
//            }
//        });
        mPresenter.fetchMovies(startPageNum);
        initRecycleView();
    }

    private void initRecycleView() {
        adapter = new MainAdapter(this.movies, mPresenter);
        GridLayoutManager gridLayoutMngr = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutMngr);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void fetchMoviesDone(List<Movie> movies) {
        if(startPageNum == 1){
            findViewById(R.id.progressBar).setVisibility(View.GONE);
        }

//        Toast.makeText(this.getApplicationContext(), list.toString(), Toast.LENGTH_LONG).show();
        this.movies.addAll(movies);
        adapter.notifyDataSetChanged();
        if(startPageNum <= 5) {
            mPresenter.fetchMovies(startPageNum++);
        }
    }

}
