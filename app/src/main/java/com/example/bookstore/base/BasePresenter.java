package com.example.bookstore.base;

//2. 이걸 구현
// 이후 impl
public interface BasePresenter<T> {
    void setView(T view);
    void removeView();
}
