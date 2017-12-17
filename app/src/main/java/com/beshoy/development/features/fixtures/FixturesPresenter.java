package com.beshoy.development.features.fixtures;

import android.view.MenuItem;

import com.beshoy.development.Constants;
import com.beshoy.development.R;
import com.beshoy.development.data.DataManager;
import com.beshoy.development.features.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Beshoy Samy on 17-Dec-17.
 */

public class FixturesPresenter extends BasePresenter<FixturesView>{

    private FixturesView view;
    private DataManager dataManager;

    @Inject
    public FixturesPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(FixturesView mvpView) {
        super.attachView(mvpView);
        this.view = mvpView;
    }

    public void getFixtures() {
        addDisposable(dataManager.getSupportedLeagues()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(result -> {
                view.leaguesLoaded(result);
                view.showProgress(false);
            }, e ->{
                Timber.e("failed :: "+e.getMessage());
            }));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_filter)
            return true;
        return false;
    }
}