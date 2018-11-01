package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author cszdz
 * 练习内容：使用 canvas.drawOval() 方法画椭圆
 */
public class Practice5DrawOvalView extends View {
  private Paint mPaint;
  private RectF mRectF = new RectF();

  public Practice5DrawOvalView(Context context) {
    super(context);
  }

  public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint.setColor(Color.BLACK);
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mRectF.set(getWidth() / 3, getHeight() / 3, (getWidth() / 3) * 2, (getHeight() / 3) * 2);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    //设置线性模式
    mPaint.setStyle(Paint.Style.STROKE);
    //绘制空心椭圆
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      canvas.drawOval(getWidth() / 3, 0, (getWidth() / 3) * 2, getHeight() / 3, mPaint);
    }
    //设置填充模式
    mPaint.setStyle(Paint.Style.FILL);
    //绘制实心椭圆
    canvas.drawOval(mRectF, mPaint);
  }
}
