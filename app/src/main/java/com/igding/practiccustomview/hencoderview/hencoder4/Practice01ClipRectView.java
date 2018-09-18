package com.igding.practiccustomview.hencoderview.hencoder4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.igding.practiccustomview.R;


public class Practice01ClipRectView extends View {

    private static final String TAG = Practice01ClipRectView.class.getSimpleName();

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice01ClipRectView(Context context) {
        super(context);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int left = (getWidth() - bitmap.getWidth()) / 2;
        int top = (getHeight() - bitmap.getHeight()) / 2;
        Log.i(TAG, "onDraw: " + left);
        Log.i(TAG, "onDraw: " + top);

        Log.i(TAG, "bitmap.getWidth(): " + bitmap.getWidth());
        Log.i(TAG, "bitmap.getHeight(): " + bitmap.getHeight());
        canvas.save();
//        canvas.clipRect(left + 1, top + 1, left - 1, top - 1);
        canvas.clipRect(left + 50, top + 50, left + 300, top + 200);
        /*
            这里的上下左右是代表的view坐标系的角度
            所以right要多加300
        */
        canvas.drawBitmap(bitmap, left, top, paint);
        canvas.restore();

    }
}
