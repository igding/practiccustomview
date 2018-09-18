package com.igding.practiccustomview.adapter.hencoder1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.igding.practiccustomview.fragment.hencoder1.CircleFragment;
import com.igding.practiccustomview.fragment.hencoder1.LineFragment;
import com.igding.practiccustomview.fragment.hencoder1.OvalFragment;
import com.igding.practiccustomview.fragment.hencoder1.PointFragment;
import com.igding.practiccustomview.fragment.hencoder1.RectFragment;
import com.igding.practiccustomview.fragment.hencoder1.RedCircleFragment;
import com.igding.practiccustomview.fragment.hencoder1.RoundRectViewFragment;

import java.util.HashMap;


/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/04/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BasePageAdapter extends FragmentPagerAdapter {

    private int num;
    private HashMap<Integer, Fragment> mFragmentHashMap = new HashMap<>();

    public BasePageAdapter(FragmentManager fm, int num) {
        super(fm);
        this.num = num;
    }

    @Override
    public Fragment getItem(int position) {
        return createFragment(position);
    }

    @Override
    public int getCount() {
        return num;
    }

    private Fragment createFragment(int pos) {
        Fragment fragment = mFragmentHashMap.get(pos);

        if (fragment == null) {
            switch (pos) {
                case 0:
                    fragment = new RedCircleFragment();
                    break;
                case 1:
                    fragment = new CircleFragment();
                    break;
                case 2:
                    fragment = new RectFragment();
                    break;
                case 3:
                    fragment = new PointFragment();
                    break;

                case 4:
                    fragment = new OvalFragment();
                    break;

                case 5:
                    fragment = new LineFragment();
                    break;

                case 6:
                    fragment = new RoundRectViewFragment();
                    break;
            }
            mFragmentHashMap.put(pos, fragment);
        }
        return fragment;
    }
}