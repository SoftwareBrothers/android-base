package com.rstit.di.auth.register;

import android.support.annotation.NonNull;

import com.rstit.ui.auth.register.RegisterViewAccess;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * @author Tomasz Trybala
 * @since 26.05.2017
 */
@Module
public class TestRegisterModule {
    @Provides
    @NonNull RegisterViewAccess provideRegisterViewAccess() {
        return mock(RegisterViewAccess.class);
    }
}