package com.passioncreativestudio.beast.fragments;

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
import com.passioncreativestudio.beast.entities.Brother;
import com.passioncreativestudio.beast.views.MeetABroViews.MeetABroAdapter;

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
        getBrothers(brothers);

        return view;
    }

    private void setUpAdapter() {
        if(isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void OnBrotherClicked(Brother brother) {
        Log.i(LOG_TAG, brother.getBrotherName() + " was clicked!");
    }

    private ArrayList<Brother> getBrothers(ArrayList<Brother> brothers) {
        for(int i = 0; i < 32; i++) {
            brothers.add(new Brother(
                    i,
                    "Brother " + i,
                    "joined for this reason",
                    "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                    "Computer Science",
                    "Spring 2015",
                    "I love to code my heart out"));
        }

        return brothers;
    }
}
