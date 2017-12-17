package com.beshoy.development.data;


import javax.inject.Inject;
import javax.inject.Singleton;

import com.beshoy.development.Constants;
import com.beshoy.development.data.model.response.Result;
import com.beshoy.development.data.remote.UFLService;

import io.reactivex.Observable;

/**
 * Created by shivam on 29/5/17.
 */
@Singleton
public class DataManager {

    private UFLService uflService;


    @Inject
    public DataManager(UFLService uflService) {
        this.uflService = uflService;
    }

    public Observable<Result> getFixtures(){
        return uflService.getFixtures(Constants.MOCK_FIXTURES_FILE);
    }

}
