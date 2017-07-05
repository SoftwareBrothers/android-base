package com.rstit.di.auth.password;

import android.support.annotation.NonNull;

import com.rstit.ui.auth.password.ForgotPasswordViewAccess;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * @author Tomasz Trybala
 * @since 25.05.2017
 */
@Module
public class TestForgotPasswordModule {
    @Provides
    @NonNull ForgotPasswordViewAccess provideForgotPasswordViewAccess() {
        return mock(ForgotPasswordViewAccess.class);
    }
}