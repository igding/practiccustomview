package com.igding.practiccustomview.hencoderview.hencoder1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/04/25
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CircleDiagramView extends View {

    //圆的半径
    private static final int RADIUS = 200;

    //文字
    private String[] textContent = {"a", "bb", "ccc", "dddd", "eeeee"};

    /**
     * 百分比
     */
    private int[] percents = {10, 20, 30, 25, 15};

    /**
     * 颜色
     */
    private int[] circleColors = {Color.WHITE, Color.YELLOW, Color.BLUE, Color.GRAY, Color.GREEN};

    //画笔
    private Paint arcPaint, linePaint, textPaint;

    //画圆必备之矩形
    private RectF rectF;

    // 线的长度
    private static final int LINE_LENGTH = 50;
    // 扇形偏移距离
    private static final int OFFSET = 20;
    // 偏移的扇形
    private static final int OFFSET_INDEX = 2;


    public CircleDiagramView(Context context) {
        super(context);
    }

    public CircleDiagramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getWidth() / 2, getHeight() / 2);

        float startAngle = 0;

        for (int i = 0; i < percents.length; i++) {
            // 扇形的角度
            float sweepAngle = 360 * percents[i] / 100;
            // 扇形的中心线相对于坐标系的角度(0~2π)
            // 取每个圆的中心线的角度来改变原点
            double theta = (startAngle + sweepAngle / 2) * Math.PI / 180;

            // 偏移的扇形，当i=2时，偏移圆心
            if (i == OFFSET_INDEX) {
                //保存最初的canvas的状态
                canvas.save();
                //  Sin：正弦 Tan：正切 Cos：余弦
                // 计算该扇形的圆心偏移坐标，去改变原点的位置
                canvas.translate((float) (OFFSET * Math.cos(theta)), (float) (OFFSET * Math.sin(theta)));
                drawContent(canvas, startAngle, sweepAngle, theta, i);
                //将canvas的状态恢复成最初保存的状态
                canvas.restore();
            } else {
                drawContent(canvas, startAngle, sweepAngle, theta, i);
            }
            startAngle += sweepAngle;
        }
    }

    private void init() {
        arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arcPaint.setStyle(Paint.Style.FILL);

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStrokeWidth(3);
        linePaint.setColor(Color.WHITE);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(30);
        textPaint.setColor(Color.WHITE);

        rectF = new RectF(-RADIUS, -RADIUS, RADIUS, RADIUS);
    }

    /**
     * 画每个扇形的内容：扇形、线、文字
     *
     * @param canvas
     * @param startAngle
     * @param sweepAngle
     * @param theta
     * @param i
     */
    private void drawContent(Canvas canvas, float startAngle, float sweepAngle, double theta, int i) {
        // 画扇形
        arcPaint.setColor(circleColors[i]);
        canvas.drawArc(rectF, startAngle, sweepAngle, true, arcPaint);

        // 画斜线
        float lineStartX = (float) (RADIUS * Math.cos(theta));
        float lineStartY = (float) (RADIUS * Math.sin(theta));
        float lineStopX = (float) ((RADIUS + LINE_LENGTH) * Math.cos(theta));
        float lineStopY = (float) ((RADIUS + LINE_LENGTH) * Math.sin(theta));
        canvas.drawLine(lineStartX, lineStartY, lineStopX, lineStopY, linePaint);

        // 画横线和文字
        float lineEndX;
        Rect r = getTextBounds(textContent[i], textPaint);
        // 左半边，往左画横线
        if (theta > Math.PI / 2 && theta <= Math.PI * 3 / 2) {
            lineEndX = lineStopX - LINE_LENGTH;
            // 画线
            canvas.drawLine(lineStopX, lineStopY, lineEndX, lineStopY, linePaint);
            // 画文字
            canvas.drawText(textContent[i], lineEndX - r.width() - 10, lineStopY + r.height() / 2, textPaint);
        } else {// 往右画横线
            lineEndX = lineStopX + LINE_LENGTH;
            // 画线
            canvas.drawLine(lineStopX, lineStopY, lineEndX, lineStopY, linePaint);
            // 文字
            canvas.drawText(textContent[i], lineEndX + 10, lineStopY + r.height() / 2, textPaint);
        }
    }

    /**
     * 测量文字大小
     *
     * @param text
     * @param paint
     * @return
     */
    private Rect getTextBounds(String text, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect;
    }
}
