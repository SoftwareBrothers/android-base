package com.rstit.base.di.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;

import com.google.common.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Tomasz Trybala
 * @since 25.05.2017
 */
@Module
public class AppModule {
    private Application mApplication;
    private EventBus mEventBus;

    public AppModule(@NonNull Application application) {
        mApplication = checkNotNull(application);
        mEventBus = new EventBus(application.getPackageName());
    }

    @Provides
    @NonNull Context provideContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton EventBus provideEventBus() {
        return mEventBus;
    }

    @Provides
    @NonNull Resources provideResources(@NonNull Context context) {
        return context.getResources();
    }
}