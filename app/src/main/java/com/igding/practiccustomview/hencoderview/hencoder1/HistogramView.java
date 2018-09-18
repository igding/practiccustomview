package com.igding.practiccustomview.hencoderview.hencoder1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/04/25
 *     desc   : 思路： 1.修改原点的位置
 *                    2.用canvas调用drawtext，得到文字
 *                    3.矩形的宽高和间隙以及文字都单独保存
 *     version: 1.0
 * </pre>
 */
public class HistogramView extends View {

    /*原点的X轴*/
    private float originX = 100;
    /*原点的Y轴*/
    private float originY = 600;

    private Paint paint = new Paint();

    /*矩形的间隔*/
    private float rectSpace = 30;

    /*矩形的宽度*/
    private float rectWidth = 50;

    /*矩形的高度*/
    private float[] rectHeight = {100, 200, 300, 400, 500};

    private String[] text = {"a", "b", "c", "d", "e"};

    public HistogramView(Context context) {
        super(context);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //修改原点的位置
        canvas.translate(originX, originY);
        initLine(canvas);
        initData(canvas);
    }

    /**
     * 矩形和文字
     *
     * @param canvas
     */
    private void initData(Canvas canvas) {
        paint.setColor(Color.GREEN);
        paint.setTextSize(50);
        float left = rectSpace;
        for (int i = 0; i < rectHeight.length; i++) {
            canvas.drawRect(left, 0, left + rectWidth, -rectHeight[i], paint);
            float textLeft = left + (originX - getTextBounds(text[i], paint).width()) / 2;
            canvas.drawText(text[i], textLeft, 50, paint);
            left += (rectSpace + rectWidth);
        }
    }

    /**
     * 调用drawText的话就必须要计算文字的最小包裹区域了，就是没有包含字间距和行间距的区域。
     * Paint提供了一个方法， getTextBounds()。
     * 传入一个Rect对象可以获得文字的左上右下（相对于左上角0，0位置）和小宽度。
     *
     * @param s
     * @param paint
     * @return
     */
    private Rect getTextBounds(String s, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(s, 0, s.length(), rect);
        return rect;
    }

    /**
     * 初始化线
     *
     * @param canvas
     */
    private void initLine(Canvas canvas) {
        paint.setColor(Color.WHITE);
        //竖线
        canvas.drawLine(0, 0, 0, -originY, paint);
        //横线
        canvas.drawLine(0, 0, originY, 0, paint);
    }
}
