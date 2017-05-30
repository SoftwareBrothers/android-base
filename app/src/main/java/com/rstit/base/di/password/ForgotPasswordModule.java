package com.rstit.base.di.password;

import android.support.annotation.NonNull;

import com.rstit.base.di.base.scope.FragmentScope;
import com.rstit.base.ui.ForgotPasswordFragment;
import com.rstit.base.ui.LoginFragment;

import base.ui.auth.login.LoginViewAccess;
import base.ui.auth.password.ForgotPasswordViewAccess;
import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

@Module
public class ForgotPasswordModule {
    private ForgotPasswordFragment mFragment;

    public ForgotPasswordModule(@NonNull ForgotPasswordFragment fragment) {
        mFragment = checkNotNull(fragment);
    }

    @Provides
    @FragmentScope
    public ForgotPasswordFragment providesForgotPasswordFragment() {
        return mFragment;
    }

    @Provides
    @FragmentScope
    public ForgotPasswordViewAccess providesForgotPasswordViewAccess(@NonNull ForgotPasswordFragment fragment) {
        return fragment;
    }
}
