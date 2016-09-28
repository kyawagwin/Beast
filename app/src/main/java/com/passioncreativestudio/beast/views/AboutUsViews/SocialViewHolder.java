package com.passioncreativestudio.beast.views.AboutUsViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.passioncreativestudio.beast.R;
import com.passioncreativestudio.beast.entities.EventCard;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SocialViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_event_card_eventDescription)
    TextView eventDescription;

    @BindView(R.id.list_event_card_eventName)
    TextView eventName;

    @BindView(R.id.list_event_card_eventType)
    ImageView eventType;

    @BindView(R.id.list_event_card_imageView)
    ImageView imageView;

    @BindView(R.id.list_event_card_progressBar)
    ProgressBar progressBar;

    public SocialViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void populate(Context context, EventCard eventCard) {
        itemView.setTag(eventCard);

        if(!eventCard.isVideo()) {
            eventType.setImageResource(R.mipmap.ic_camera);
        } else {
            eventType.setImageResource(R.mipmap.ic_video);
        }

        eventDescription.setText(eventCard.getEventDescription());
        eventName.setText(eventCard.getEventName());

        Picasso.with(context).load(eventCard.getEventImage()).fit().centerCrop().into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }
}
