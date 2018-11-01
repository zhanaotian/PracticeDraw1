package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Util;

/**
 * @author paihaozhan
 * 综合练习
 * 练习内容：使用各种 Canvas.drawXXX() 方法画饼图
 */
public class Practice11PieChartView extends View {
  private Paint mPaint;
  private RectF mRectF = new RectF();
  private static final float PADDING_TOP = Util.dp2px(20);
  private static final int PULLED_OUT_INDEX = 4;
  private static final float ARC_PADDING = 2;
  private static final float ARC_PADDING_FIVE = Util.dp2px(8);
  private int[] angles = { 9, 5, 63, 96, 123, 51, 2 };
  private int[] colors = {
      Color.parseColor("#9C27B0"),
      Color.parseColor("#9E9E9E"),
      Color.parseColor("#009688"),
      Color.parseColor("#2196F3"),
      Color.parseColor("#F44336"),
      Color.parseColor("#FFC107"),
      Color.parseColor("#5A7985")
  };

  public Practice11PieChartView(Context context) {
    super(context);
  }

  public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mRectF.set(getWidth() / 5, PADDING_TOP, getWidth() / 5 * 3 + PADDING_TOP,
        getHeight() / 3 * 2 + PADDING_TOP);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    ///绘制扇形区域
    int currentAngle = 0;
    for (int i = 0; i < colors.length; i++) {
      mPaint.setColor(colors[i]);
      canvas.save();
      if (i == PULLED_OUT_INDEX) {
        ///偏移指定扇形
        canvas.translate(
            (float) Math.cos(Math.toRadians(currentAngle + angles[i] / 2)) * ARC_PADDING_FIVE,
            (float) Math.sin(Math.toRadians(currentAngle + angles[i] / 2)) * ARC_PADDING_FIVE);
      }
      canvas.drawArc(mRectF, currentAngle, angles[i], true, mPaint);
      canvas.restore();
      if (i > 4) {
        currentAngle += angles[i];
      } else {
        currentAngle += angles[i] + ARC_PADDING;
      }
    }
    //绘制文字
    mPaint.setColor(Color.WHITE);
    mPaint.setTextSize(Util.dp2px(18));
    canvas.drawText("饼图", getWidth() / 5 * 2 - PADDING_TOP, getHeight() - PADDING_TOP * 2, mPaint);
    //绘制介绍

  }
}
