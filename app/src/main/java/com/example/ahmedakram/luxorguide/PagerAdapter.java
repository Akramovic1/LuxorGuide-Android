package com.example.ahmedakram.luxorguide;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"Go Play", "Go Eat", "Go Rest", "To Do"};
    private Context context;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new GoPlay();
        } else if (position == 1) {
            return new GoEat();
        } else if (position == 2) {
            return new GoRest();
        } else {
            return new ThingsToDo();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
