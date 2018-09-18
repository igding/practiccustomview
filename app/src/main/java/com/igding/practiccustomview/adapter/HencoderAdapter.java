package com.igding.practiccustomview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.igding.practiccustomview.R;
import com.igding.practiccustomview.activity.hencoder1.HencoderPractic1Activity;
import com.igding.practiccustomview.activity.hencoder3.HencoderPractic3Activity;
import com.igding.practiccustomview.activity.hencoder4.HencoderPractic4Activity;
import com.igding.practiccustomview.activity.hencoder5.HencoderPractic5Activity;
import com.igding.practiccustomview.activity.hencoder6.HencoderPractic6Activity;
import com.igding.practiccustomview.activity.hencoder7.HencoderPractic7Activity;
import com.igding.practiccustomview.activity.hencoder8.HencoderPractic8Activity;
import com.igding.practiccustomview.bean.CustomViewBean;

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
public class HencoderAdapter extends BaseQuickAdapter<CustomViewBean, BaseViewHolder> {

    private Context context;

    public HencoderAdapter(Context context, @Nullable List<CustomViewBean> data) {
        super(R.layout.item_hencoder, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final CustomViewBean item) {
        helper.setText(R.id.tv_hencoder, item.getName());
        helper.setOnClickListener(R.id.ll_hencoder, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("0".equals(item.getId())) {
                    context.startActivity(new Intent(context, HencoderPractic1Activity.class));
                } else if ("2".equals(item.getId())) {
                    context.startActivity(new Intent(context, HencoderPractic3Activity.class));
                } else if ("3".equals(item.getId())) {
                    context.startActivity(new Intent(context, HencoderPractic4Activity.class));
                } else if ("4".equals(item.getId())) {
                    context.startActivity(new Intent(context, HencoderPractic5Activity.class));
                } else if ("5".equals(item.getId())) {
                    context.startActivity(new Intent(context, HencoderPractic6Activity.class));
                } else if ("6".equals(item.getId())) {
                    context.startActivity(new Intent(context, HencoderPractic7Activity.class));
                } else if ("7".equals(item.getId())) {
                    context.startActivity(new Intent(context, HencoderPractic8Activity.class));
                }
            }
        });
    }
}
