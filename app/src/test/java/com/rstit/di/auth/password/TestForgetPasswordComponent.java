package com.rstit.di.auth.password;


import com.rstit.ui.auth.password.ForgetPasswordViewModelTest;

import dagger.Subcomponent;

/**
 * @author Tomasz Trybala
 * @since 26.05.2017
 */
@Subcomponent(modules = TestForgetPasswordModule.class)
public interface TestForgetPasswordComponent {
    ForgetPasswordViewModelTest inject(ForgetPasswordViewModelTest test);
}