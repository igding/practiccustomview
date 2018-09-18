package com.igding.practiccustomview.hencoderview.hencoder3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice09SetTextScaleXView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";

    public Practice09SetTextScaleXView(Context context) {
        super(context);
    }

    public Practice09SetTextScaleXView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice09SetTextScaleXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(60);
        paint.setTextScaleX(1f);//默认是0
        // 使用 Paint.setTextScaleX() 来改变文字宽度

        //为什么在默认的字符间距为 0 的情况下，字符和字符之间也没有紧紧贴着，
        // Canvas.drawText() 的 x 参数的时候已经说过了，具体回头看
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text, 50, 100, paint);
    }
}
