package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author paihaozhan
 * 综合练习
 * 练习内容：使用各种 Canvas.drawXXX() 方法画圆形头像
 */
public class Practice13CricleImageView extends View {

    public Practice13CricleImageView(Context context) {
        super(context);
    }

    public Practice13CricleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13CricleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       
    }
}
