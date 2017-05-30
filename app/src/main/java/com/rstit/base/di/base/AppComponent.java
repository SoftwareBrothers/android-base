package com.rstit.base.di.base;

import com.rstit.base.di.login.LoginComponent;
import com.rstit.base.di.login.LoginModule;
import com.rstit.base.di.main.MainComponent;
import com.rstit.base.di.main.MainModule;
import com.rstit.base.di.password.ForgotPasswordComponent;
import com.rstit.base.di.password.ForgotPasswordModule;
import com.rstit.base.di.register.RegisterComponent;
import com.rstit.base.di.register.RegisterModule;

import javax.inject.Singleton;

import base.di.base.ValidationModule;
import dagger.Component;

/**
 * @author Tomasz Trybala
 * @since 25.05.2017
 */
@Singleton
@Component(modules = {
        AppModule.class,
        ValidationModule.class
})
public interface AppComponent {
    MainComponent plus(MainModule module);

    LoginComponent plus(LoginModule module);

    ForgotPasswordComponent plus(ForgotPasswordModule module);

    RegisterComponent plus(RegisterModule module);
}