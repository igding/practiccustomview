package com.igding.practiccustomview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.igding.practiccustomview.bean.CustomViewBean;
import com.igding.practiccustomview.R;
import com.igding.practiccustomview.adapter.CustomViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<CustomViewBean> data = initData();
        initView(data);
    }

    private void initView(List<CustomViewBean> data) {
        RecyclerView mRvContent = findViewById(R.id.rv_hencoder);
        mRvContent.setLayoutManager(new LinearLayoutManager(this));
        mRvContent.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRvContent.setAdapter(new CustomViewAdapter(this, data));
    }

    @NonNull
    private List<CustomViewBean> initData() {
        List<CustomViewBean> data = new ArrayList();
        data.add(new CustomViewBean("HenCoder Android 开发进阶：UI", "0"));
        data.add(new CustomViewBean("我项目中的view", "1"));
        return data;
    }
}
