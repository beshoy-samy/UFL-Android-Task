package com.beshoy.development.data.remote;


import com.beshoy.development.data.model.response.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface UFLService {

    @GET("api/v1/fixtures/{page}")
    Observable<Result> getFixtures(@Path("page") int page);

}
