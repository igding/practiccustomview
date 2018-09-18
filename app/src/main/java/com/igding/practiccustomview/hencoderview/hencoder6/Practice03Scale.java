package com.igding.practiccustomview.hencoderview.hencoder6;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.igding.practiccustomview.R;


public class Practice03Scale extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    int a = 0;

    public Practice03Scale(Context context) {
        super(context);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (a) {
                    case 0:
                        /*这里的值，指的是缩放的倍数*/
                        imageView.animate().scaleX(1.5f);
                        break;
                    case 1:
                        imageView.animate().scaleX(1);
                        break;
                    case 2:
                        imageView.animate().scaleY(0.5f);
                        break;
                    case 3:
                        imageView.animate().scaleY(1);
                        break;
                    default:
                }
                a++;
                if (a == 5) {
                    a = 0;
                }
                // TODO 在这里处理点击事件，通过 View.animate().scaleX/Y() 来让 View 放缩
            }
        });
    }
}
