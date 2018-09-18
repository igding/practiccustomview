package com.igding.practiccustomview.hencoderview.hencoder1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class OvalView extends View {

    public OvalView(Context context) {
        super(context);
    }

    public OvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);


        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(50, 50, 350, 200, paint);

        //        canvas.drawOval(100, 100, 200, 200, paint);
        /*坐标没写好，硬是把椭圆画成了圆,可能是距离差的问题吧*/

        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        //必须要加大小，默认大小是0
        canvas.drawOval(400, 50, 700, 200, paint);
    }
}
