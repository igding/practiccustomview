package com.igding.practiccustomview.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.igding.practiccustomview.bean.CustomViewBean;
import com.igding.practiccustomview.HencoderPracticTotalActivity;
import com.igding.practiccustomview.R;

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
public class CustomViewAdapter extends BaseQuickAdapter<CustomViewBean, BaseViewHolder> {

    private Context context;

    public CustomViewAdapter(Context context, @Nullable List<CustomViewBean> data) {
        super(R.layout.item_customview, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final CustomViewBean item) {
        helper.setText(R.id.tv_content, item.getName());
        helper.setOnClickListener(R.id.ll_customview, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("0".equals(item.getId())) {
                    context.startActivity(new Intent(context, HencoderPracticTotalActivity.class));
                }
            }
        });
    }

}
