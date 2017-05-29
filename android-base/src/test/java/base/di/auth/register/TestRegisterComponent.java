package base.di.auth.register;


import base.ui.auth.register.RegisterViewModelTest;

import dagger.Subcomponent;

/**
 * @author Tomasz Trybala
 * @since 26.05.2017
 */
@Subcomponent(modules = TestRegisterModule.class)
public interface TestRegisterComponent {
    RegisterViewModelTest inject(RegisterViewModelTest test);
}