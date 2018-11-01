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
 * <p>
 * 练习内容：使用 canvas.drawPoint() 方法画点
 * 一个圆点，一个方点
 * 圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
 */
public class Practice4DrawPointView extends View {
  private Paint mPaint;
  private float[] points = {0, 0, 150, 150, 150, 200, 200, 150, 200, 200, 250, 150, 250, 200};

  public Practice4DrawPointView(Context context) {
    super(context);
  }

  public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint.setColor(Color.BLACK);
    //设置线宽
    mPaint.setStrokeWidth(Util.dp2px(30));
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    //设置点的形状为圆头
    mPaint.setStrokeCap(Paint.Cap.ROUND);
    canvas.drawPoint(getWidth() / 3, getHeight() / 2, mPaint);
    //设置点的形状为平头
    mPaint.setStrokeCap(Paint.Cap.BUTT);
    canvas.drawPoint(getWidth() / 3 * 2, getHeight() / 2, mPaint);
    //设置点的形状为方头
    mPaint.setStrokeCap(Paint.Cap.SQUARE);
    canvas.drawPoint(getWidth() / 2, getHeight() / 2, mPaint);
    ///绘制多个点
    canvas.drawPoints(points, 2, 8, mPaint);

  }
}
