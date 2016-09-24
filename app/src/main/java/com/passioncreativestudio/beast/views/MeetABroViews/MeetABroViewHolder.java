package com.passioncreativestudio.beast.views.MeetABroViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.passioncreativestudio.beast.R;
import com.passioncreativestudio.beast.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeetABroViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_meet_a_bro_imageView)
    ImageView brotherPic;

    @BindView(R.id.list_meet_a_bro_progressBar)
    ProgressBar brotherProgressBar;

    public MeetABroViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void populate(Context context, Brother brother) {
        itemView.setTag(brother);

        Picasso.with(context).load(brother.getBrotherPicture())
                .fit().centerCrop().into(brotherPic, new Callback() {
            @Override
            public void onSuccess() {
                brotherProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }
}
