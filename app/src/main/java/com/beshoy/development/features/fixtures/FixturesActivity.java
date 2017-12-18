package com.beshoy.development.features.fixtures;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.beshoy.development.R;
import com.beshoy.development.data.model.response.fixtures.Fixture;
import com.beshoy.development.data.model.response.leagues.League;
import com.beshoy.development.features.base.BaseActivity;
import com.beshoy.development.features.fixtures.adapters.fixture.FixturesAdapter;
import com.beshoy.development.features.fixtures.adapters.league.LeaguesAdapter;
import com.beshoy.development.features.fixtures.adapters.league.LeagueClickListener;
import com.beshoy.development.injection.component.ActivityComponent;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class FixturesActivity extends BaseActivity implements FixturesView,
        LeagueClickListener{

    @Inject
    FixturesPresenter presenter;
    @Inject
    LeaguesAdapter leaguesAdapter;
    @Inject
    FixturesAdapter fixturesAdapter;
    @BindView(R.id.leaguesRecyclerView)
    RecyclerView leaguesRecycler;
    @BindView(R.id.fixturesRecyclerView)
    RecyclerView fixturesRecycler;
    @BindView(R.id.error_view)
    View errorView;
    @BindView(R.id.progress)
    ProgressBar progress;
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
        leaguesRecycler.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        leaguesAdapter.setListener(this);
        leaguesRecycler.setAdapter(leaguesAdapter);
        fixturesRecycler.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        fixturesRecycler.setAdapter(fixturesAdapter);
        presenter.getLeagues();
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

    @Override
    public void showProgress(boolean show) {
        progress.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showErrorView(boolean show) {
        errorView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showFixturesRecycler(boolean show) {
        fixturesRecycler.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void leaguesLoaded(ArrayList<League> leagues) {
        leaguesAdapter.setLeagues(leagues);
    }

    @Override
    public void fixturesLoaded(ArrayList<Fixture> fixtures) {
        fixturesAdapter.setFixtures(fixtures);
    }

    @Override
    public void onLeagueClicked(League league) {
        presenter.onLeagueClicked(league.getId());
    }

    @OnClick(R.id.retry)
    void onRetry(){
        presenter.retry();
    }
}
