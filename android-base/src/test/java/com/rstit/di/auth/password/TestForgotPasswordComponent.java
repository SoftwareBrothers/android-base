package com.rstit.di.auth.password;


import com.rstit.ui.auth.password.ForgotPasswordViewModelTest;

import dagger.Subcomponent;

/**
 * @author Tomasz Trybala
 * @since 26.05.2017
 */
@Subcomponent(modules = TestForgotPasswordModule.class)
public interface TestForgotPasswordComponent {
    ForgotPasswordViewModelTest inject(ForgotPasswordViewModelTest test);
}