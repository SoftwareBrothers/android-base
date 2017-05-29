package com.rstit.base;

import android.support.annotation.NonNull;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Tomasz Trybala
 * @since 25.05.2017
 */
public class RxJavaTestRule implements TestRule {
    @Override
    public @NonNull Statement apply(@NonNull Statement base, @NonNull Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                RxAndroidPlugins.setInitMainThreadSchedulerHandler(c -> Schedulers.trampoline());
                RxJavaPlugins.setIoSchedulerHandler(c -> Schedulers.trampoline());

                base.evaluate();
            }
        };
    }
}