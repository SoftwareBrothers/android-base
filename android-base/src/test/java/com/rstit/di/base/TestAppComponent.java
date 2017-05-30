package com.rstit.di.base;

import com.rstit.di.auth.login.TestLoginComponent;
import com.rstit.di.auth.login.TestLoginModule;
import com.rstit.di.auth.password.TestForgotPasswordComponent;
import com.rstit.di.auth.password.TestForgotPasswordModule;
import com.rstit.di.auth.register.TestRegisterComponent;
import com.rstit.di.auth.register.TestRegisterModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Tomasz Trybala
 * @since 28.03.2017
 */
@Singleton
@Component(modules = {
        TestAppModule.class,
        TestValidationModule.class
})

public interface TestAppComponent {
    TestLoginComponent plus(TestLoginModule module);

    TestRegisterComponent plus(TestRegisterModule module);

    TestForgotPasswordComponent plus(TestForgotPasswordModule module);
}