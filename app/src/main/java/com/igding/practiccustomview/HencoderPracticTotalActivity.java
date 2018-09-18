package com.igding.practiccustomview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.igding.practiccustomview.adapter.HencoderAdapter;
import com.igding.practiccustomview.bean.CustomViewBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/09/08
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class HencoderPracticTotalActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hencoder_practic);
        List<CustomViewBean> data = initData();
        initView(data);
    }

    private void initView(List<CustomViewBean> data) {
        RecyclerView mRvHencoder = findViewById(R.id.rv_hencoder);
        mRvHencoder.setLayoutManager(new LinearLayoutManager(this));
        mRvHencoder.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRvHencoder.setAdapter(new HencoderAdapter(this, data));
    }

    @NonNull
    private List<CustomViewBean> initData() {
        List<CustomViewBean> data = new ArrayList();
        data.add(new CustomViewBean("UI 1-1 绘制基础", "0"));
        data.add(new CustomViewBean("hencoder2", "1"));
        data.add(new CustomViewBean("UI 1-3 文字的绘制", "2"));
        data.add(new CustomViewBean("UI 1-4 Canvas 对绘制的辅助", "3"));
        data.add(new CustomViewBean("UI 1-5 绘制顺序", "4"));
        data.add(new CustomViewBean("UI 1-6 动画", "5"));
        data.add(new CustomViewBean("UI 1-7 Evaluator", "6"));
        data.add(new CustomViewBean("UI 1-8 布局基础", "7"));
        return data;
    }
}
