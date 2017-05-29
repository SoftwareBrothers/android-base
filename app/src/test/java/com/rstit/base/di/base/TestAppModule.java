package com.rstit.base.di.base;

import android.support.annotation.NonNull;

import com.google.common.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * @author Tomasz Trybala
 * @since 25.05.2017
 */
@Module
public class TestAppModule {
    @Provides
    public @NonNull EventBus provideEventBus() {
        return mock(EventBus.class);
    }
}