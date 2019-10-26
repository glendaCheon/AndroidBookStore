package com.example.bookstore.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

//1. 먼저 이걸 만듦. 다음은 presenter
public abstract class BaseActivity <V extends BaseView, P extends BasePresenter<V>>
        extends AppCompatActivity
{

    //butterknife binding 및 view의 기본 모양을 잡아줌.
    protected P mPresenter;
    protected abstract P setPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = this.setPresenter();
        mPresenter.setView((V)this);

    }

//    @Override
//    public void setContentView(View view) { //int로 받아야 하지 view로 받으면 안 됨.
//        super.setContentView(view);
//        ButterKnife.bind(this);
//    }

    @Override
    public void setContentView(int layoutResId) { //int로 받아야 하지 view로 받으면 안 됨.
        super.setContentView(layoutResId);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.removeView();
        super.onDestroy();
    }
}
