package com.beshoy.development.injection.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.beshoy.development.data.remote.UFLService;
import retrofit2.Retrofit;

/**
 * Created by shivam on 29/5/17.
 */
@Module(includes = {NetworkModule.class})
public class ApiModule {

    @Provides
    @Singleton
    UFLService providePokemonApi(Retrofit retrofit) {
        return retrofit.create(UFLService.class);
    }
}
