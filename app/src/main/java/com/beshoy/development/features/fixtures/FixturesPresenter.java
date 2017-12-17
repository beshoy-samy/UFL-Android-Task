package com.beshoy.development.features.fixtures;

import com.beshoy.development.Constants;
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
        addDisposable(dataManager.getFixtures()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(result -> {
                Timber.d("success :: "+result.getResponse());
            }, e ->{
                Timber.e("failed :: "+e.getMessage());
            }));
    }
}
