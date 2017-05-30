package com.rstit.di.auth.register;


import com.rstit.ui.auth.register.RegisterViewModelTest;

import dagger.Subcomponent;

/**
 * @author Tomasz Trybala
 * @since 26.05.2017
 */
@Subcomponent(modules = TestRegisterModule.class)
public interface TestRegisterComponent {
    RegisterViewModelTest inject(RegisterViewModelTest test);
}