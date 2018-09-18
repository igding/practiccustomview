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
public class PointView extends View {

    public PointView(Context context) {
        super(context);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        //圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE) 三种
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(100);
        /*必须要设置宽度 不然就没有效果*/
        canvas.drawPoint(100, 200, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setStrokeWidth(100);
        canvas.drawPoint(200, 300, paint);

        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setStrokeWidth(100);
        canvas.drawPoint(300, 400, paint);

        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(100);
        //必须要加大小，默认大小是0

        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        canvas.drawPoints
                (points, 2
                /* 跳过两个数，即前两个 0 */,
                        8
                /* 一共绘制 8 个数（4 个点）*/, paint);
    }
}
