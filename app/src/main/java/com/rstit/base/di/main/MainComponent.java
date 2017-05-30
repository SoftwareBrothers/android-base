package com.rstit.base.di.main;

import com.rstit.base.di.base.scope.ActivityScope;
import com.rstit.base.ui.main.MainActivity;

import dagger.Subcomponent;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    MainActivity inject(MainActivity mainActivity);
}
