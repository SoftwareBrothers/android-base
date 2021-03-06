package com.rstit.di.password;

import com.rstit.di.base.scope.FragmentScope;
import com.rstit.base.ui.ForgotPasswordFragment;

import dagger.Subcomponent;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

@FragmentScope
@Subcomponent(modules = ForgotPasswordModule.class)
public interface ForgotPasswordComponent {
    ForgotPasswordFragment inject(ForgotPasswordFragment fragment);
}
