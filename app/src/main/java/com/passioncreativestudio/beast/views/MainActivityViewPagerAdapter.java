package com.passioncreativestudio.beast.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.passioncreativestudio.beast.fragments.AboutUsFragment;
import com.passioncreativestudio.beast.fragments.MeetABroFragment;
import com.passioncreativestudio.beast.fragments.RushFragment;

public class MainActivityViewPagerAdapter extends FragmentStatePagerAdapter {
    public MainActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = AboutUsFragment.newInstance();
                break;
            case 1:
                fragment = MeetABroFragment.newInstance();
                break;
            case 2:
                fragment = RushFragment.newInstance();
                break;
            default:
                fragment = null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        switch (position) {
            case 0:
                title = "About Us";
                break;
            case 1:
                title = "Meet A Bro";
                break;
            case 2:
                title = "Rush";
                break;
            default:
                title = null;
        }
        return title;
    }
}
