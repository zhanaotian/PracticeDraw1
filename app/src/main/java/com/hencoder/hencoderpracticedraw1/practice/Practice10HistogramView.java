package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Util;

/**
 * @author paihaozhan
 * 综合练习
 * 练习内容：使用各种 Canvas.drawXXX() 方法画直方图
 */
public class Practice10HistogramView extends View {
  private Paint mPaint;
  private float[] points;
  private String[] mTexts;
  private static final float OFFSET = Util.dp2px(30);
  private static final float GAP = Util.dp2px(7);
  private int mRectCount;
  private double mRandom;
  private float mRectWidth;
  private float mRectHeight;

  public Practice10HistogramView(Context context) {
    super(context);
  }

  public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint.setStrokeWidth(Util.dp2px(1));
    mPaint.setColor(Color.WHITE);
    mRectCount = 7;
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    points = new float[]{
        OFFSET, OFFSET, OFFSET, getHeight() - OFFSET * 2, OFFSET,
        getHeight() - OFFSET * 2, getWidth() - OFFSET, getHeight() - OFFSET * 2
    };
    mTexts = new String[]{"Froyo", "GB", "lC S", "JB", "KitKat", "L", "M"};

  }

  @SuppressLint("DrawAllocation")
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    ///绘制线段
    canvas.drawLines(points, mPaint);
    //文字大小
    mPaint.setTextSize(Util.dp2px(16));
    //绘制文字
    canvas.drawText("直方图", (getWidth() - OFFSET * 2) / 2, getHeight() - OFFSET, mPaint);
    //获取矩形的宽度
    mRectWidth = (getWidth() - OFFSET * 2 - GAP * mRectCount) / mRectCount;
    for (int i = 0; i < mRectCount; i++) {
      mRandom = Math.random();
      mRectHeight = (float) (getHeight() * 0.4 * mRandom);
      //设置为绿色
      mPaint.setColor(Color.parseColor("#7DC116"));
      //绘制柱状图
      canvas.drawRect(
          OFFSET + mRectWidth * i + GAP,
          mRectHeight,
          OFFSET + mRectWidth * (i + 1),
          getHeight() - OFFSET * 2 - 1,
          mPaint
      );
      //文字大小,颜色
      mPaint.setTextSize(Util.dp2px(10));
      mPaint.setColor(Color.WHITE);
      //绘制底部文字
      canvas.drawText(mTexts[i], OFFSET + mRectWidth * i + GAP,
          getHeight() - OFFSET * 2 + Util.dp2px(10), mPaint);
    }
  }
}
