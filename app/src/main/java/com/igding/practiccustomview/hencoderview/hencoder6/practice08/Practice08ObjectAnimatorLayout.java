package com.igding.practiccustomview.hencoderview.hencoder6.practice08;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.igding.practiccustomview.R;


public class Practice08ObjectAnimatorLayout extends RelativeLayout {
    Practice08ObjectAnimatorView view;
    Button animateBt;

    public Practice08ObjectAnimatorLayout(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Practice08ObjectAnimatorView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator progress = ObjectAnimator.ofFloat(view, "progress", 0, 65);
                progress.setDuration(1000)
                        .setInterpolator(new FastOutSlowInInterpolator());
                progress.start();
                // TODO 在这里处理点击事件，用 ObjectAnimator 播放动画
                // 1. 用 ObjectAnimator 创建 Animator 对象
                // 2. 用 start() 执行动画
                // *. 记得在 Practice08ObjectAnimatorView 中为 progress 添加 setter/ getter 方法！

                //因为ObjectAnimator中是会根据alpha拼装成setAlpha函数，
                // 然后通过反射找到view控件对应个setAlpha方法，将当前的数值传入进去。
            }
        });
    }
}
