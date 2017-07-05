package com.rstit.di.register;

import com.rstit.di.base.scope.FragmentScope;
import com.rstit.base.ui.RegisterFragment;

import dagger.Subcomponent;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

@FragmentScope
@Subcomponent(modules = RegisterModule.class)
public interface RegisterComponent {
    RegisterFragment inject(RegisterFragment fragment);
}
