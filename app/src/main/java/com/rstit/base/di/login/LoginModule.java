package com.rstit.base.di.login;

import android.support.annotation.NonNull;

import com.rstit.base.di.base.scope.FragmentScope;
import com.rstit.base.ui.LoginFragment;

import base.ui.auth.login.LoginViewAccess;
import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

@Module
public class LoginModule {
    private LoginFragment mLoginFragment;

    public LoginModule(@NonNull LoginFragment loginFragment) {
        mLoginFragment = checkNotNull(loginFragment);
    }

    @Provides
    @FragmentScope
    public LoginFragment providesLoginFragment() {
        return mLoginFragment;
    }

    @Provides
    @FragmentScope
    public LoginViewAccess providesLoginViewAccess(@NonNull LoginFragment loginFragment) {
        return loginFragment;
    }
}
