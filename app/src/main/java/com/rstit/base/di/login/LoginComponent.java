package com.rstit.base.di.login;

import com.rstit.base.di.base.scope.FragmentScope;
import com.rstit.base.ui.LoginFragment;

import dagger.Subcomponent;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

@FragmentScope
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {
    LoginFragment inject(LoginFragment loginFragment);
}
