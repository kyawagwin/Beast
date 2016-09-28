package com.passioncreativestudio.beast.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.passioncreativestudio.beast.R;
import com.passioncreativestudio.beast.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrotherDetailsFragment extends BaseFragment {
    //region view members
    @BindView(R.id.fragment_brother_details_brotherPicture)
    ImageView brotherPicture;

    @BindView(R.id.fragment_brother_details_brotherName)
    TextView brotherName;

    @BindView(R.id.fragment_brother_details_brotherCrossed)
    TextView brotherCrossed;

    @BindView(R.id.fragment_brother_details_brotherMajor)
    TextView brotherMajor;

    @BindView(R.id.fragment_brother_details_brotherFunFact)
    TextView brotherFunFact;

    @BindView(R.id.fragment_brother_details_progressBar)
    ProgressBar brotherProgressBar;

    @BindView(R.id.fragment_brother_details_brotherWhyJoined)
    TextView brotherWhyJoined;
    //endregion

    //region other members
    private Brother brother;

    private static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";
    //endregion

    public static BrotherDetailsFragment newInstance(Brother brother) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(BROTHER_EXTRA_INFO, brother);
        BrotherDetailsFragment brotherDetailsFragment = new BrotherDetailsFragment();
        brotherDetailsFragment.setArguments(bundle);
        return brotherDetailsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        brother = getArguments().getParcelable(BROTHER_EXTRA_INFO);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brother_details, container, false);

        ButterKnife.bind(this, view);

        brotherName.setText(brother.getBrotherName());
        brotherCrossed.setText(getString(R.string.crossed_intro, brother.getBrotherCrossSemester()));
        brotherCrossed.setText(getString(R.string.major_intro, brother.getBrotherMajor()));
        brotherCrossed.setText(getString(R.string.fun_fact_intro, brother.getBrotherFunFact()));;
        brotherWhyJoined.setText(brother.getBrotherWhyJoin());

        Picasso.with(getActivity())
                .load(brother.getBrotherPicture())
                .fit()
                .centerCrop()
                .into(brotherPicture, new Callback() {
                    @Override
                    public void onSuccess() {
                        brotherProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
        });

        return view;
    }
}
