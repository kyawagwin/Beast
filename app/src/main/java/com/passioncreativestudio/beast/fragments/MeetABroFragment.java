package com.passioncreativestudio.beast.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.passioncreativestudio.beast.R;
import com.passioncreativestudio.beast.activities.BaseActivity;
import com.passioncreativestudio.beast.activities.PracticeActivity;
import com.passioncreativestudio.beast.entities.Brother;
import com.passioncreativestudio.beast.services.BrotherServices;
import com.passioncreativestudio.beast.views.MeetABroViews.MeetABroAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class MeetABroFragment extends BaseFragment implements MeetABroAdapter.OnBrotherClickedListener {
    private static final String LOG_TAG = MeetABroFragment.class.getSimpleName();

    private MeetABroAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Brother> brothers;

    public static MeetABroFragment newInstance() {
        return new MeetABroFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meet_a_bro, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_meet_a_bro_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));

        adapter = new MeetABroAdapter((BaseActivity) getActivity(), this);
        brothers = adapter.getBrothers();
        setUpAdapter();

        bus.post(new BrotherServices.SearchBrotherRequest("Firebase Url"));

        return view;
    }

    private void setUpAdapter() {
        if(isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void OnBrotherClicked(Brother brother) {
        Intent intent = PracticeActivity.newIntent(getActivity(), brother);
        startActivity(intent);
    }

    @Subscribe
    public void getBrothers(BrotherServices.SearchBrotherResponse response) {
        brothers.clear();
        brothers.addAll(response.brothers);
    }
}
