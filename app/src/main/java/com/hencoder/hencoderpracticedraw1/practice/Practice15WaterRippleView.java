package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author paihaozhan
 * 综合练习
 * 练习内容：使用各种 Canvas.drawXXX() 方法实现水波纹效果
 */
public class Practice15WaterRippleView extends View {

    public Practice15WaterRippleView(Context context) {
        super(context);
    }

    public Practice15WaterRippleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice15WaterRippleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
    }
}
