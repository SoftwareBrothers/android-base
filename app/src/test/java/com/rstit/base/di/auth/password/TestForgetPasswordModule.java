package com.rstit.base.di.auth.password;

import android.support.annotation.NonNull;

import com.rstit.base.ui.auth.login.LoginViewAccess;
import com.rstit.base.ui.auth.password.ForgetPasswordViewAccess;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * @author Tomasz Trybala
 * @since 25.05.2017
 */
@Module
public class TestForgetPasswordModule {
    @Provides
    @NonNull ForgetPasswordViewAccess provideForgetPasswordViewAccess() {
        return mock(ForgetPasswordViewAccess.class);
    }
}