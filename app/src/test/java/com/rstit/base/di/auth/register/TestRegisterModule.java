package com.rstit.base.di.auth.register;

import android.support.annotation.NonNull;

import com.rstit.base.ui.auth.login.LoginViewAccess;
import com.rstit.base.ui.auth.register.RegisterViewAccess;

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