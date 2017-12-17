package com.beshoy.development.features.fixtures;

import android.os.Bundle;

import com.beshoy.development.R;
import com.beshoy.development.features.base.BaseActivity;
import com.beshoy.development.injection.component.ActivityComponent;

import javax.inject.Inject;

public class FixturesActivity extends BaseActivity implements FixturesView{

    @Inject
    FixturesPresenter presenter;

    @Override
    protected int getLayout() {
        return R.layout.activity_fixtures;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void attachView() {
        presenter.attachView(this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        presenter.getFixtures();
    }

    @Override
    protected void detachPresenter() {
        presenter.detachView();
    }
}
