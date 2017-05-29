package base.di.base;

import base.di.auth.login.TestLoginComponent;
import base.di.auth.login.TestLoginModule;
import base.di.auth.password.TestForgetPasswordComponent;
import base.di.auth.password.TestForgetPasswordModule;
import base.di.auth.register.TestRegisterComponent;
import base.di.auth.register.TestRegisterModule;

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

    TestForgetPasswordComponent plus(TestForgetPasswordModule module);
}