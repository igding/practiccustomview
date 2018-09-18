package com.igding.practiccustomview.hencoderview.hencoder6;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.igding.practiccustomview.R;


public class Practice04Alpha extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    boolean isVisible = false;

    public Practice04Alpha(Context context) {
        super(context);
    }

    public Practice04Alpha(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04Alpha(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
                if (isVisible) {
                    imageView.animate().alpha(1);
                    isVisible = false;
                    return;
                }
                imageView.animate().alpha(0);
                isVisible = true;
            }
        });
    }
}