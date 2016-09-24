package com.passioncreativestudio.beast.views.MeetABroViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.passioncreativestudio.beast.R;
import com.passioncreativestudio.beast.activities.BaseActivity;
import com.passioncreativestudio.beast.entities.Brother;

import java.util.ArrayList;

public class MeetABroAdapter extends RecyclerView.Adapter<MeetABroViewHolder> implements View.OnClickListener {
    private LayoutInflater inflater;
    private BaseActivity activity;
    private OnBrotherClickedListener listener;
    private ArrayList<Brother> brothers;

    public MeetABroAdapter(BaseActivity activity, OnBrotherClickedListener listener) {
        this.activity = activity;
        this.listener = listener;
        inflater = activity.getLayoutInflater();
        brothers = new ArrayList<>();
    }

    public ArrayList<Brother> getBrothers() {
        return brothers;
    }

    @Override
    public MeetABroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listView = inflater.inflate(R.layout.list_meet_a_bro, parent, false);
        listView.setOnClickListener(this);
        return new MeetABroViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(MeetABroViewHolder holder, int position) {
        holder.populate(activity, brothers.get(position));
    }

    @Override
    public int getItemCount() {
        return brothers.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getTag() instanceof Brother) {
            Brother brother = (Brother) view.getTag();
            listener.OnBrotherClicked(brother);
        }
    }

    public interface OnBrotherClickedListener {
        void OnBrotherClicked(Brother brother);
    }
}
