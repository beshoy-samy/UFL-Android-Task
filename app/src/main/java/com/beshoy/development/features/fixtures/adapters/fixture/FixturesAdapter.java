package com.beshoy.development.features.fixtures.adapters.fixture;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beshoy.development.Constants;
import com.beshoy.development.R;
import com.beshoy.development.data.model.response.fixtures.Fixture;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by Beshoy Samy on 17-Dec-17.
 */

public class FixturesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Fixture> fixtures;
    private String lastLeague;
    private String lastDate;
    private int extraHolders = 0;
    private boolean isAllLeagues;
    private int count = 0;
    private int viewType;
    int lastFixtureIndex = 0;
    int lastSuccessPosition = -1;

    @Inject
    public FixturesAdapter() {
        fixtures = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if(position < lastSuccessPosition){
            int add = 0;
            if(position == 0)
                add = 1;
            else
                add = 0;
            viewType = getViewType(position+lastSuccessPosition+add);
            Timber.d("position :: to fix "+position);
            return viewType;
        }
        else{
            viewType = getViewType(position);
            lastSuccessPosition = position;
            return viewType;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        View view;
        switch (viewType){
            case Constants.ViewHolderTypes.DATE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_date, parent, false);
                holder = new DateViewHolder(view);
                extraHolders++;
                break;
            case Constants.ViewHolderTypes.LEAGUE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_fixture_league, parent, false);
                holder = new LeagueViewHolder(view);
                extraHolders++;
                break;
            default :
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_fixture, parent, false);
                holder = new FixtureViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Timber.d("used index :: "+lastFixtureIndex);
        switch (viewType){
            case Constants.ViewHolderTypes.DATE:
                ((DateViewHolder) holder).onBind(fixtures.get(position).getDate());
                break;
            case Constants.ViewHolderTypes.LEAGUE:
                ((LeagueViewHolder) holder).onBind(fixtures.get(position).getLeagueImage(),
                        fixtures.get(position).getLeagueName());
                break;
            case Constants.ViewHolderTypes.FIXTURE:
                ((FixtureViewHolder) holder).onBind(fixtures.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    private int getViewType(int position) {
        /*Fixture fixture = getRightFixture(position);
        if(!fixture.getDate().equals(lastDate)){
            lastDate = fixture.getDate();
            return Constants.ViewHolderTypes.DATE;
        }
        else if(isAllLeagues && !fixture.getLeagueName().equals(lastLeague)){
            lastLeague = fixture.getLeagueName();
            return Constants.ViewHolderTypes.LEAGUE;
        }
        else*/
            return Constants.ViewHolderTypes.FIXTURE;
    }

    private Fixture getRightFixture(int position){
        Timber.d("position :: "+position+", extraHolders :: "+extraHolders);
        lastFixtureIndex = position- extraHolders;
        return fixtures.get(lastFixtureIndex);
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

    public void setIsAllLeagues(boolean isAllLeagues) {
        this.isAllLeagues = isAllLeagues;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
