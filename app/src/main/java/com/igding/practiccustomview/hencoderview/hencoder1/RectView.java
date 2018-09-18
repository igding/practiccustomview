package com.igding.practiccustomview.hencoderview.hencoder1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/04/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class RectView extends View {

    public RectView(Context context) {
        super(context);
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        //这里的左上右下代表的是矩形四条边的坐标
        canvas.drawRect(100, 200, 300, 400, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        //这里的左上右下代表的是矩形四条边的坐标
        canvas.drawRect(300, 400, 500, 600, paint);

    }
}
