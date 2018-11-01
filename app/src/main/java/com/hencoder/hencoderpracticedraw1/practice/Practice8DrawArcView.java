package com.hencoder.hencoderpracticedraw1.practice;

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
 * 练习内容：使用 canvas.drawArc() 方法画弧形和扇形
 */
public class Practice8DrawArcView extends View {
  private Paint mPaint;
  private RectF mRectF = new RectF();
  private static final float OFFSET = Util.dp2px(10);

  public Practice8DrawArcView(Context context) {
    super(context);
  }

  public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint.setColor(Color.BLACK);
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mRectF.set(getWidth() / 3 + OFFSET, getHeight() / 3 + OFFSET, getWidth() / 3 * 2 - OFFSET, getHeight() / 3 * 2 - OFFSET);
  }

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    ///canvas.drawArc(getWidth() / 3, getHeight() / 3, (getWidth() / 3) * 2, (getHeight() / 3) * 2, 0, 30, true, mPaint);
    ///设置为填充模式
    mPaint.setStyle(Paint.Style.FILL);
    ///绘制扇形
    canvas.drawArc(mRectF, 250, 90, true, mPaint);
    ///绘制弧形
    canvas.drawArc(mRectF, 20, 140, false, mPaint);
    ///设置为画线模式
    mPaint.setStyle(Paint.Style.STROKE);
    ///绘制不封口的弧形
    canvas.drawArc(mRectF,180,60,false,mPaint);
  }
}
