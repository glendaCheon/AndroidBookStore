package com.example.bookstore.base;

import io.reactivex.disposables.CompositeDisposable;

//3. 이걸 구현
public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {
    protected T view;
    protected CompositeDisposable bag = new CompositeDisposable();

    @Override
    public void setView(T view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
//        bag.dispose(); //내용은 있는데 안에 있는 걸 비우지 않고 dispose만.
        bag.clear(); //다없어지면서 disposable
    }
}
