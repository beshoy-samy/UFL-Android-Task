package com.beshoy.development.data.remote;


import com.beshoy.development.data.model.response.fixtures.FixturesResponse;
import com.beshoy.development.data.model.response.leagues.League;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface UFLService {

    @GET("api/v1/fixtures/{file}")
    Observable<ArrayList<League>> getLeagues(@Path("file") String file);

    @GET("api/v1/fixtures/{leagueId}")
    Observable<FixturesResponse> getFixtures(@Path("leagueId") String leagueId);

}
