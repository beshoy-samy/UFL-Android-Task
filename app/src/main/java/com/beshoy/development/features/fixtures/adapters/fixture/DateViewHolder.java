package com.beshoy.development.features.fixtures.adapters.fixture;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.beshoy.development.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Beshoy Samy on 18-Dec-17.
 */

public class DateViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.fixture_date)
    TextView fixtureDate;

    public DateViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBind(String date){
        fixtureDate.setText(date);
    }
}
