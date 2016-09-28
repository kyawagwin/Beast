package com.passioncreativestudio.beast.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.passioncreativestudio.beast.R;
import com.passioncreativestudio.beast.entities.Brother;
import com.passioncreativestudio.beast.fragments.BrotherDetailsFragment;
import com.passioncreativestudio.beast.services.BrotherServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrotherPagerActivity extends BaseActivity {
    private static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";

    private ArrayList<Brother> brothers;

    @BindView(R.id.activity_brother_pager_viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_brother_pager);

        ButterKnife.bind(this);

        brothers = new ArrayList<>();

        bus.post(new BrotherServices.SearchBrotherRequest("Request Url"));

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Brother brother = brothers.get(position);
                return BrotherDetailsFragment.newInstance(brother);
            }

            @Override
            public int getCount() {
                return brothers.size();
            }
        });

        Brother brother = getIntent().getParcelableExtra(BROTHER_EXTRA_INFO);
        int brotherId = brother.getBrotherId();

        for(int i = 0; i < brothers.size(); i++) {
            if(brothers.get(i).getBrotherId() == brotherId) {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }

    @Subscribe
    public void getBrothers(BrotherServices.SearchBrotherResponse response) {
        brothers.clear();
        brothers.addAll(response.brothers);
    }

    public static Intent newIntent(Context context, Brother brother) {
        Intent intent = new Intent(context, BrotherPagerActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO, brother);
        return intent;
    }
}
