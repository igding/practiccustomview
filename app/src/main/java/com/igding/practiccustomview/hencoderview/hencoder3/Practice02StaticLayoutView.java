package com.igding.practiccustomview.hencoderview.hencoder3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class Practice02StaticLayoutView extends View {
    TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello\nHenCoder";

    public Practice02StaticLayoutView(Context context) {
        super(context);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        textPaint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        StaticLayout staticLayout1 = new StaticLayout(text, textPaint,
                600,//是文字区域的宽度, 文字到达这个宽度后就会自动换行
                Layout.Alignment.ALIGN_NORMAL, //是文字的对齐方向
                1,//是行间距的倍数, 通常情况下填1就好
                0,//是行间距的额外增加值, 通常情况下填0就好
                true//是指是否在文字上下添加额外的空间, 来避免某些过高的字符的绘制出现越界
        );

//        不能在换行符 \n 处换行
//        如果需要绘制多行的文字，你必须自行把文字切断后分多次使用 drawText () 来绘制，或者——使用 StaticLayout
//        StaticLayout 并不是一个 View 或者 ViewGroup ，而是 android.text.Layout 的子类，它是纯粹用来绘制文字的。
//        StaticLayout 支持换行，它既可以为文字设置宽度上限来让文字自动换行，也会在 \n 处主动换行。

        canvas.translate(50, 100);
        staticLayout1.draw(canvas);
    }
}
