package com.rstit.di.auth.password;


import com.rstit.ui.auth.password.ForgotPasswordViewModelTest;

import dagger.Subcomponent;

/**
 * @author Tomasz Trybala
 * @since 26.05.2017
 */
@Subcomponent(modules = TestForgetPasswordModule.class)
public interface TestForgetPasswordComponent {
    ForgotPasswordViewModelTest inject(ForgotPasswordViewModelTest test);
}