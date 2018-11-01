package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Util;

/**
 * @author cszdz
 * 练习内容：使用 canvas.drawLine() 方法画直线
 */
public class Practice6DrawLineView extends View {
  private Paint mPaint;
  private float[] points;

  public Practice6DrawLineView(Context context) {
    super(context);
  }

  public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint.setColor(Color.BLACK);
    mPaint.setStrokeWidth(Util.dp2px(3));
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    points = new float[]{20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 120, 150, 20, 250, 20, 150, 20, 150, 120, 250, 20, 250, 120, 150, 120, 250, 120};
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    ///绘制直线
    //canvas.drawLine(getWidth() / 3, getHeight() / 3, getWidth() / 3 * 2, getHeight() / 3 * 2, mPaint);
    ///绘制多条直线
    canvas.drawLines(points, mPaint);
  }
}
