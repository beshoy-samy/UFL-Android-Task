package com.beshoy.development.features.fixtures.adapters.league;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beshoy.development.Constants;
import com.beshoy.development.R;
import com.beshoy.development.data.model.response.leagues.League;
import com.beshoy.development.util.image.GlideUtil;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Beshoy Samy on 17-Dec-17.
 */

public class LeaguesAdapter extends RecyclerView.Adapter<LeaguesAdapter.ViewHolder> {

    private ArrayList<League> leagues;
    private View lastSelected;
    private LeagueClickListener listener;

    @Inject
    public LeaguesAdapter() {
        leagues = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_league, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(position == Constants.ALL_LEAGUES_POSITION)
            setItemAsSelected(holder.itemLeague, position);
        GlideUtil.loadImageURL(holder.leagueIcon.getContext(), leagues.get(position).getImage(), holder.leagueIcon);
        holder.leagueName.setText(leagues.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return leagues.size();
    }

    public void setLeagues(ArrayList<League> leagues) {
        this.leagues = leagues;
        notifyDataSetChanged();
    }

    public void setListener(LeagueClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.league_icon)
        ImageView leagueIcon;
        @BindView(R.id.league_name)
        TextView leagueName;
        @BindView(R.id.item_league)
        View itemLeague;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item_league)
        void onLeagueClicked(View view){
            setItemAsSelected(view, getAdapterPosition());
        }
    }

    private void setItemAsSelected(View view, int position) {
        if(!view.equals(lastSelected)){
            if(lastSelected != null){
                ((TextView)lastSelected.findViewById(R.id.league_name))
                        .setTextColor(ContextCompat.getColor(view.getContext()
                                , R.color.Gray));
            }
            ((TextView)view.findViewById(R.id.league_name))
                    .setTextColor(ContextCompat.getColor(view.getContext(), R.color.white));
            lastSelected = view;
            listener.onLeagueClicked(leagues.get(position));
        }
    }
}
