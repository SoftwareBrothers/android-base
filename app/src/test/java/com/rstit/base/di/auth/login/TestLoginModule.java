package com.rstit.base.di.auth.login;

import android.support.annotation.NonNull;

import com.rstit.base.ui.auth.login.LoginViewAccess;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * @author Tomasz Trybala
 * @since 25.05.2017
 */
@Module
public class TestLoginModule {
    @Provides
    @NonNull LoginViewAccess provideLoginViewAccess() {
        return mock(LoginViewAccess.class);
    }
}