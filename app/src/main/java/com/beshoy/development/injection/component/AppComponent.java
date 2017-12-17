package com.beshoy.development.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import com.beshoy.development.data.DataManager;
import com.beshoy.development.injection.ApplicationContext;
import com.beshoy.development.injection.module.AppModule;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ApplicationContext
    Context context();

    Application application();

    DataManager apiManager();
}
