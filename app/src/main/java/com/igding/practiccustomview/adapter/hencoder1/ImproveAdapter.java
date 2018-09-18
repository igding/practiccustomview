package com.igding.practiccustomview.adapter.hencoder1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.igding.practiccustomview.fragment.hencoder1.ArcFragment;
import com.igding.practiccustomview.fragment.hencoder1.CircleDiagramFragment;
import com.igding.practiccustomview.fragment.hencoder1.HistogramFragment;
import com.igding.practiccustomview.fragment.hencoder1.PathLineFragment;
import com.igding.practiccustomview.fragment.hencoder1.PathLoveFragment;

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
public class ImproveAdapter extends FragmentPagerAdapter {

    private int num;
    private HashMap<Integer, Fragment> mFragmentHashMap = new HashMap<>();

    public ImproveAdapter(FragmentManager fm, int num) {
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
                    fragment = new ArcFragment();
                    break;
                case 1:
                    fragment = new PathLoveFragment();
                    break;
                case 2:
                    fragment = new PathLineFragment();
                    break;
                case 3:
                    fragment = new HistogramFragment();
                    break;
                case 4:
                    fragment = new CircleDiagramFragment();
                    break;
            }
            mFragmentHashMap.put(pos, fragment);
        }
        return fragment;
    }
}
