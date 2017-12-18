package com.beshoy.development.features.fixtures.adapters.fixture;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.beshoy.development.R;
import com.beshoy.development.util.image.GlideUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Beshoy Samy on 18-Dec-17.
 */

public class LeagueViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.league_icon)
    ImageView leagueIcon;
    @BindView(R.id.league_name)
    TextView leagueName;

    public LeagueViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBind(String leagueImg, String leagueName){
        GlideUtil.loadImageURL(leagueIcon.getContext(), leagueImg, leagueIcon);
        this.leagueName.setText(leagueName);
    }
}
