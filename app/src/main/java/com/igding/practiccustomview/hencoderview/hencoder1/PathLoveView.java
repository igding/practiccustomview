package com.igding.practiccustomview.hencoderview.hencoder1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
 *     desc   : 自定义图形
 *     version: 1.0
 * </pre>
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class PathLoveView extends View {

    Paint paint = new Paint();
    Path path = new Path(); // 初始化 Path 对象

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        // 绘制出 path 描述的图形（心形），大功告成
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);

//        path.addRect(10,20,30,40,Path.Direction.CCW);
//        path.addCircle(10,20,30,Path.Direction.CCW);
        //后面的dir代表顺时针还是逆时针
        canvas.drawPath(path, paint);
    }

    public PathLoveView(Context context) {
        super(context);
    }

    public PathLoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
