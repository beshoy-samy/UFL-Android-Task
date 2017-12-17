package com.beshoy.development.data;


import javax.inject.Inject;
import javax.inject.Singleton;

import com.beshoy.development.Constants;
import com.beshoy.development.data.model.response.leagues.League;
import com.beshoy.development.data.remote.UFLService;

import java.util.ArrayList;

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

    public Observable<ArrayList<League>> getSupportedLeagues(){
        return uflService.getLeagues(Constants.MOCK_LEAGUES_FILE);
    }

}
