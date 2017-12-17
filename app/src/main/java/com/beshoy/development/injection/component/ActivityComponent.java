package com.beshoy.development.injection.component;

import dagger.Subcomponent;

import com.beshoy.development.features.fixtures.FixturesActivity;
import com.beshoy.development.injection.PerActivity;
import com.beshoy.development.injection.module.ActivityModule;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {


    void inject(FixturesActivity fixturesActivity);
}
