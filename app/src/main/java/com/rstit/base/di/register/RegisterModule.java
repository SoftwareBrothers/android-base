package com.rstit.base.di.register;

import android.support.annotation.NonNull;

import com.rstit.base.di.base.scope.FragmentScope;
import com.rstit.base.ui.RegisterFragment;

import base.ui.auth.register.RegisterViewAccess;
import dagger.Module;
import dagger.Provides;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

@Module
public class RegisterModule {
    private RegisterFragment mFragment;

    public RegisterModule(@NonNull RegisterFragment fragment) {
        mFragment = checkNotNull(fragment);
    }

    @Provides
    @FragmentScope
    public RegisterFragment providesRegisterFragment() {
        return mFragment;
    }

    @Provides
    @FragmentScope
    public RegisterViewAccess providesRegisterViewAccess(@NonNull RegisterFragment fragment) {
        return fragment;
    }
}
