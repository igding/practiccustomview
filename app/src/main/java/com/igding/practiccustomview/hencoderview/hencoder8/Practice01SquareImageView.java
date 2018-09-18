package com.igding.practiccustomview.hencoderview.hencoder8;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 需要把它写成正方形的 ImageView
 */
public class Practice01SquareImageView extends ImageView {
    public Practice01SquareImageView(Context context) {
        super(context);
    }

    public Practice01SquareImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01SquareImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 重写 onMeasure()，调整尺寸，让 ImageView 总是正方形
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        // 先用 getMeasuredWidth() 和 getMeasuredHeight() 取到 super.onMeasure() 的计算结果
        // 然后通过计算，让宽度和高度一致
        if (measuredWidth > measuredHeight) {
            measuredWidth = measuredHeight;
        } else {
            measuredHeight = measuredWidth;
        }

        /*
        * 这里的逻辑是因为外面的逻辑代码，因为外面viewgroup的逻辑是根据seekbar的值来进行改变的。
        * 同时FrameLayout的宽高是写的死的值，所以才会有这样的问题
        * */
//        measuredWidth = measuredHeight;

        setMeasuredDimension(measuredWidth, measuredHeight);
        // 再用 setMeasuredDimension(width, height) 来保存最终的宽度和高度
    }
}
