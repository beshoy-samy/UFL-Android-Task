package com.beshoy.development.features.fixtures;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.beshoy.development.R;
import com.beshoy.development.features.base.BaseActivity;
import com.beshoy.development.injection.component.ActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;

public class FixturesActivity extends BaseActivity implements FixturesView{

    @Inject
    FixturesPresenter presenter;

    @BindView(R.id.leaguesRecyclerView)
    RecyclerView leaguesRecycler;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

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
        toolbar.setTitle(R.string.games);
        setupToolbar(toolbar, false);
        presenter.getFixtures();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_fixtures_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return presenter.onOptionsItemSelected(item);
    }

    @Override
    protected void detachPresenter() {
        presenter.detachView();
    }

}
