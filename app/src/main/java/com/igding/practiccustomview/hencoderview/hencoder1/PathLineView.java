package com.igding.practiccustomview.hencoderview.hencoder1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/04/26
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class PathLineView extends View {

    Paint paint = new Paint();
    // 初始化 Path 对象
    Path path = new Path();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        // 由当前位置 (0, 0) 向 (100, 100) 画一条直线 代表的是绝对位置
        path.lineTo(100, 100);
        path.lineTo(200, 0);
////
////        // 由当前位置 (100, 100) 向正右方 200 像素的位置画一条直线，这里的R代表的是相对位置
        path.rLineTo(200, 0);
//
        //也是绝对位置和相对位置，这里是二阶贝塞尔曲线
        path.quadTo(100, 100, 200, 100);
        path.rQuadTo(100, 100, 200, 100);

        path.moveTo(500, 500);
        /*move相当于把原点重新指定某个坐标*/
        path.lineTo(300, 500);
        path.lineTo(100, 100);

        path.close();/*close相当于从最后的坐标与原点相连接*/

//      close() 和 lineTo(起点坐标) 是完全等价的。


        canvas.drawPath(path, paint);

    }

    public PathLineView(Context context) {
        super(context);
    }

    public PathLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

}
