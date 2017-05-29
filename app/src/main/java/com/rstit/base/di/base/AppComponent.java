package com.rstit.base.di.base;

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

}