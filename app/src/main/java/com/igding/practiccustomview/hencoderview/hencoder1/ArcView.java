package com.igding.practiccustomview.hencoderview.hencoder1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/04/24
 *     desc   : 弧
 *     version: 1.0
 * </pre>
 */
public class ArcView extends View {

    public ArcView(Context context) {
        super(context);
    }

    public ArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // left, top, right, bottom 描述的是这个弧形所在的椭圆；
        //

        /*先画出来一个矩形，然后以三点钟为0度，
          oval - 　　　　用于确定圆弧形状与尺寸的椭圆边界（即椭圆外切矩形）
          startAngle- 开始角度（以时钟3点的方向为0°，顺时针为正方向）为开始度数，正数就代表顺时针，负数就代表逆时针
          sweepAngle- 扫过角度（以时钟3点的方向为0°，顺时针为正方向）  在开始度数的基础上的顺时针或者逆时针旋转度数
          useCenter - 是否包含圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
          paint - 绘制圆弧的画笔
          useCenter
        */

        Paint paint = new Paint();
        // 填充模式
        paint.setStyle(Paint.Style.FILL);
//       绘制扇形
        canvas.drawArc(200, 100, 800, 500, -110, 100, true, paint);
//       绘制弧形
        canvas.drawArc(200, 100, 800, 500, 20, 140, false, paint);
//       画线模式
        paint.setStyle(Paint.Style.STROKE);
//       绘制不封口的弧形
        canvas.drawArc(200, 100, 800, 500, 180, 60, false, paint);
    }
}