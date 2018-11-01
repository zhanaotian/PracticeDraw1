package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Util;

/**
 * @author cszdz
 * 练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
 */
public class Practice7DrawRoundRectView extends View {
  private Paint mPaint;
  private RectF mRectF = new RectF();

  public Practice7DrawRoundRectView(Context context) {
    super(context);
  }

  public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint.setColor(Color.BLACK);
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mRectF.set(getWidth() / 3, getHeight() / 3, getWidth() / 3 * 2, getHeight() / 3 * 2);
  }

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  @SuppressLint("DrawAllocation")
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    ///绘制实心圆
    canvas.drawRoundRect(mRectF, 50, 50, mPaint);
    ///绘制空心圆
    ///mPaint.setStrokeWidth(Util.dp2px(2));
    ///mPaint.setStyle(Paint.Style.STROKE);
    ///canvas.drawRoundRect(getWidth() / 3, getHeight() / 3, getWidth() / 3 * 2, getHeight() / 3 * 2, Util.dp2px(10), Util.dp2px(10), mPaint);
  }
}
