package com.rstit.base.di.auth.login;


import com.rstit.base.ui.auth.login.LoginViewModelTest;

import dagger.Subcomponent;

/**
 * @author Tomasz Trybala
 * @since 25.05.2017
 */
@Subcomponent(modules = TestLoginModule.class)
public interface TestLoginComponent {
    LoginViewModelTest inject(LoginViewModelTest test);
}