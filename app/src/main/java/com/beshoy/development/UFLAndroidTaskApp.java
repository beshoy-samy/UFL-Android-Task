package com.beshoy.development;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.facebook.stetho.Stetho;
import com.singhajit.sherlock.core.Sherlock;
import com.squareup.leakcanary.LeakCanary;
import com.tspoon.traceur.Traceur;

import com.beshoy.development.injection.component.AppComponent;
import com.beshoy.development.injection.component.DaggerAppComponent;
import com.beshoy.development.injection.module.AppModule;
import com.beshoy.development.injection.module.NetworkModule;
import timber.log.Timber;

public class UFLAndroidTaskApp extends Application {

    private AppComponent appComponent;

    public static UFLAndroidTaskApp get(Context context) {
        return (UFLAndroidTaskApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Stetho.initializeWithDefaults(this);
            LeakCanary.install(this);
            Sherlock.init(this);
            Traceur.enableLogging();
        }

        Utils.init(this);
    }

    public AppComponent getComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .networkModule(new NetworkModule(this))
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
