package com.rstit.di.base;

import com.rstit.di.login.LoginComponent;
import com.rstit.di.login.LoginModule;
import com.rstit.di.main.MainComponent;
import com.rstit.di.main.MainModule;
import com.rstit.di.password.ForgotPasswordComponent;
import com.rstit.di.password.ForgotPasswordModule;
import com.rstit.di.register.RegisterComponent;
import com.rstit.di.register.RegisterModule;

import javax.inject.Singleton;

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