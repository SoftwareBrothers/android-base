package base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.rstit.base.library.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

import base.di.base.AppComponent;
import base.di.base.AppModule;
import base.di.base.DaggerAppComponent;


/**
 * @author Tomasz Trybala
 * @since 2017-05-25
 */

public class BaseApplication extends MultiDexApplication {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    public @NonNull AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static @NonNull BaseApplication get(@NonNull Context context) {
        return (BaseApplication) context.getApplicationContext();
    }
}
