package com.igding.practiccustomview.activity.hencoder1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.igding.practiccustomview.R;
import com.igding.practiccustomview.adapter.hencoder1.BasePageAdapter;
import com.igding.practiccustomview.adapter.hencoder1.ImproveAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/09/08
 *     desc   : http://hencoder.com/ui-1-1
 *     version: 1.0
 * </pre>
 */
public class HencoderPractic1Activity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private static final String TAG = HencoderPractic1Activity.class.getSimpleName();
    private ViewPager baseVp;
    private ViewPager improveVp;
    public static final String BASE = "base";
    public static final String IMPROVE = "improve";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hencoderpractic1);
        initBase();
        initImprove();
    }

    /**
     * 初始化improve
     */
    private void initImprove() {
        List<String> improveData = new ArrayList<>();
        improveData.add("弧形扇形");
        improveData.add("子图形path");
        improveData.add("画线path");
        improveData.add("直方图");
        improveData.add("饼图");
        TabLayout improveTabLayout = findViewById(R.id.improve_tabLayout);
        //添加标签
        for (String improveDatum : improveData) {
            improveTabLayout.addTab(improveTabLayout.newTab().setTag(IMPROVE).setText(improveDatum));
        }
        //设置adapter，滑动时间
        improveVp = findViewById(R.id.improve_viewPager);
        improveVp.setAdapter(new ImproveAdapter(getSupportFragmentManager(), improveTabLayout.getTabCount()));
        improveVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(improveTabLayout));
        improveTabLayout.setOnTabSelectedListener(this);
    }


    /**
     * 初始化base数据
     */
    private void initBase() {
        TabLayout baseTabLayout = findViewById(R.id.base_tabLayout);
        ArrayList<String> baseData = new ArrayList<>();
        baseData.add("drawcolor");
        baseData.add("圆");
        baseData.add("矩形");
        baseData.add("点");
        baseData.add("椭圆");
        baseData.add("线");
        baseData.add("圆角矩形");

        for (String baseDatum : baseData) {
            baseTabLayout.addTab(baseTabLayout.newTab().setTag(BASE).setText(baseDatum));
        }

        //设置adapter，滑动时间
        baseVp = findViewById(R.id.base_viewPager);
        baseVp.setAdapter(new BasePageAdapter(getSupportFragmentManager(), baseTabLayout.getTabCount()));
        baseVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(baseTabLayout));
        baseTabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        String tag = String.valueOf(tab.getTag());
        switch (tag) {
            case BASE:
                baseVp.setCurrentItem(tab.getPosition());
                break;
            case IMPROVE:
                improveVp.setCurrentItem(tab.getPosition());
                break;
            default:
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
