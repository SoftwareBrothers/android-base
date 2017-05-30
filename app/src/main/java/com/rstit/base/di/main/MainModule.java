package com.rstit.base.di.main;

import android.support.annotation.NonNull;

import com.rstit.base.di.base.scope.ActivityScope;
import com.rstit.base.ui.main.MainActivity;
import com.rstit.base.ui.main.MainViewAccess;

import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */


@Module
public class MainModule {
    private MainActivity mMainActivity;

    public MainModule(@NonNull MainActivity mainActivity) {
        mMainActivity = checkNotNull(mainActivity);
    }

    @Provides
    @ActivityScope
    @NonNull MainActivity provideMainActivity() {
        return mMainActivity;
    }

    @Provides
    @ActivityScope
    @NonNull MainViewAccess provideMainViewAccess(@NonNull MainActivity activity) {
        return activity;
    }
}
