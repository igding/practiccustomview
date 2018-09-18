package com.igding.practiccustomview.activity.hencoder6;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.igding.practiccustomview.R;
import com.igding.practiccustomview.fragment.hencoder3.PageFragment;

import java.util.ArrayList;
import java.util.List;

public class HencoderPractic6Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.string.title_translation, R.layout.practice_translation));
        pageModels.add(new PageModel(R.string.title_rotation, R.layout.practice_rotation));
        pageModels.add(new PageModel(R.string.practic6_title_scale, R.layout.hencoder6_practice_scale));
        pageModels.add(new PageModel(R.string.title_alpha, R.layout.practice_alpha));
        pageModels.add(new PageModel(R.string.title_multi_properties, R.layout.practice_multi_properties));
        pageModels.add(new PageModel(R.string.title_duration, R.layout.practice_duration));
        pageModels.add(new PageModel(R.string.title_interpolator, R.layout.practice_interpolator));
        pageModels.add(new PageModel(R.string.title_object_animator, R.layout.practice_object_animator));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hencoderpractic6);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private class PageModel {
        @StringRes
        int titleRes;
        @LayoutRes
        int practiceLayoutRes;

        PageModel(@StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
