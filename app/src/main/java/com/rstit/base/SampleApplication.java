package com.rstit.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;

import com.rstit.di.base.AppComponent;
import com.rstit.di.base.AppModule;
import com.rstit.di.base.DaggerAppComponent;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

public class SampleApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public @NonNull AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static @NonNull SampleApplication get(@NonNull Context context) {
        return (SampleApplication) context.getApplicationContext();
    }
}
