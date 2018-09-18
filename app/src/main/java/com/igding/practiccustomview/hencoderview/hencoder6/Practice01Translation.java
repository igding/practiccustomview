package com.igding.practiccustomview.hencoderview.hencoder6;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.igding.practiccustomview.R;

import static android.os.Build.VERSION.SDK_INT;
import static com.igding.practiccustomview.hencoderview.hencoder6.Utils.dpToPixel;

public class Practice01Translation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    int a = 0;

    public Practice01Translation(Context context) {
        super(context);
    }

    public Practice01Translation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01Translation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            // 给音乐图标加上合适的阴影
            imageView.setOutlineProvider(new MusicOutlineProvider());
        }

        animateBt.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(final View v) {
                switch (a) {
                    case 0:
                        /*这里的参数代表的是坐标，而不是距离*/
                        imageView.animate().translationX(400);
                        break;
                    case 1:
                        imageView.animate().translationX(0);
                        break;
                    case 2:
                        imageView.animate().translationY(100);
                        break;
                    case 3:
                        imageView.animate().translationY(0);
                        break;
                    case 4:
                        /*因为Z轴是外正内负，所以向Z轴移动的话，会有阴影效果出现*/
                        imageView.animate().translationZ(dpToPixel(15));
                        break;
                    case 5:
                        imageView.animate().translationZ(0);
                        break;
                    default:
                }
                a++;
                if (a == 6) {
                    a = 0;
                }
            }
        });
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class MusicOutlineProvider extends ViewOutlineProvider {
        Path path = new Path();

        {
            path.moveTo(0, dpToPixel(10));
            path.lineTo(dpToPixel(7), dpToPixel(2));
            path.lineTo(dpToPixel(116), dpToPixel(58));
            path.lineTo(dpToPixel(116), dpToPixel(70));
            path.lineTo(dpToPixel(7), dpToPixel(128));
            path.lineTo(0, dpToPixel(120));
            path.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }
    }
}