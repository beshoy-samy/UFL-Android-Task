package com.beshoy.development.features.fixtures;

import com.beshoy.development.data.model.response.leagues.League;
import com.beshoy.development.features.base.MvpView;

import java.util.ArrayList;

/**
 * Created by Beshoy Samy on 17-Dec-17.
 */

public interface FixturesView extends MvpView {
    void showProgress(boolean show);

    void leaguesLoaded(ArrayList<League> leagues);
}
