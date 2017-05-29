package com.rstit.base.ui.base.model;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Tomasz Trybala
 * @since 2017-05-25
 */

public class BaseViewModel extends BaseObservable {
    private final CompositeDisposable mDisposables = new CompositeDisposable();

    protected void registerDisposable(@NonNull Disposable d) {
        mDisposables.add(checkNotNull(d));
    }

    public void clearDisposables() {
        mDisposables.clear();
    }
}
