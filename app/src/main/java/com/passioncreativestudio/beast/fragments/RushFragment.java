package com.passioncreativestudio.beast.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.passioncreativestudio.beast.R;

public class RushFragment extends BaseFragment {
    public static RushFragment newInstance() {
        return new RushFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rush, container, false);
        return view;
    }
}
