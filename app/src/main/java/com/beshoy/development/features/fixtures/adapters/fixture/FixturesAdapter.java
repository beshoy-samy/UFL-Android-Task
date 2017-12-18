package com.beshoy.development.features.fixtures.adapters.fixture;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beshoy.development.Constants;
import com.beshoy.development.R;
import com.beshoy.development.data.model.response.fixtures.Fixture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


/**
 * Created by Beshoy Samy on 17-Dec-17.
 */

public class FixturesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Fixture> fixtures;

    @Inject
    public FixturesAdapter() {
        fixtures = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        return fixtures.get(position).getViewType();
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
                break;
            case Constants.ViewHolderTypes.LEAGUE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_fixture_league, parent, false);
                holder = new LeagueViewHolder(view);
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
        Fixture fixture = fixtures.get(position);
        switch (fixture.getViewType()){
            case Constants.ViewHolderTypes.DATE:
                ((DateViewHolder) holder).onBind(fixture.getDate());
                break;
            case Constants.ViewHolderTypes.LEAGUE:
                ((LeagueViewHolder) holder).onBind(fixture.getLeagueImage(),
                        fixture.getLeagueName());
                break;
            case Constants.ViewHolderTypes.FIXTURE:
                ((FixtureViewHolder) holder).onBind(fixture);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return fixtures.size();
    }

    public void setFixtures(ArrayList<Fixture> fixtures) {
        this.fixtures = fixtures;
        notifyDataSetChanged();
    }

}
