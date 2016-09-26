package com.passioncreativestudio.beast.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.passioncreativestudio.beast.R;
import com.passioncreativestudio.beast.entities.Brother;
import com.passioncreativestudio.beast.fragments.BrotherDetailsFragment;

public class PracticeActivity extends BaseActivity {
    private static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_practice);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager
                .findFragmentById(R.id.activity_practice_fragment_container);
        if(fragment == null) {
            fragment = BrotherDetailsFragment.newInstance();

            fragmentManager.beginTransaction()
                    .add(R.id.activity_practice_fragment_container, fragment).commit();
        }
    }

    public static Intent newIntent(Context context, Brother brother) {
        Intent intent = new Intent(context, PracticeActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO, brother);
        return intent;
    }
}
