package com.beshoy.development.features.fixtures.adapters.fixture;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.beshoy.development.Constants;
import com.beshoy.development.R;
import com.beshoy.development.data.model.response.fixtures.Fixture;
import com.beshoy.development.util.image.GlideUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Beshoy Samy on 18-Dec-17.
 */

public class FixtureViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.coins)
    View coins;
    @BindView(R.id.team1_img)
    ImageView team1Img;
    @BindView(R.id.team1_name)
    TextView team1Name;
    @BindView(R.id.team2_img)
    ImageView team2Img;
    @BindView(R.id.team2_name)
    TextView team2Name;
    @BindView(R.id.result_or_time)
    TextView resultOrTime;

    private Context context;

    public FixtureViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = itemView.getContext();
    }

    public void onBind(Fixture fixture){
        if(fixture.getCoins() == Constants.SILVER)
            coins.setBackgroundColor(ContextCompat.getColor(context, R.color.silver));
        else if(fixture.getCoins() == Constants.GOLD)
            coins.setBackgroundColor(ContextCompat.getColor(context, R.color.gold));
        GlideUtil.loadImageURL(context, fixture.getTeam1Img(), team1Img);
        team1Name.setText(fixture.getTeam1Name());
        if(fixture.getResult().isEmpty())
            resultOrTime.setText(fixture.getOnAir());
        else
            resultOrTime.setText(fixture.getResult());
        GlideUtil.loadImageURL(context, fixture.getTeam2Img(), team2Img);
        team2Name.setText(fixture.getTeam2Name());
    }
}
