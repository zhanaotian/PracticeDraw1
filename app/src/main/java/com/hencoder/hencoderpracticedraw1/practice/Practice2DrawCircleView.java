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
 * @author paihaozhan
 * 练习内容：使用 canvas.drawCircle() 方法画圆
 * 一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
 */
public class Practice2DrawCircleView extends View {
  private Paint mPaint;
  private static final int RADIUS = 50;
  private static final int SKEWING = 10;

  public Practice2DrawCircleView(Context context) {
    super(context);
  }

  public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    ///设置画笔为黑色
    mPaint.setColor(Color.BLACK);
  }

  /**
   * 前两个参数 centerX centerY 是圆心的坐标。
   * 第三个参数 radius 是圆的半径，单位都是像素。
   * 第四个参数 paint 它提供基本信息之外的所有风格信息，例如颜色、线条粗细、阴影等。
   */
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    ///绘制第一个实心圆
    canvas.drawCircle(getWidth() / 3, getHeight() / 5 + Util.dp2px(SKEWING), Util.dp2px(RADIUS),
        mPaint);
    ///保存画布
    canvas.save();
    ///将坐标系移动到第二个宽的3/1处
    canvas.translate(getWidth() / 3, 0);
    ///设置画线模式
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeWidth(Util.dp2px(1));
    ///绘制第二个空心圆
    canvas.drawCircle(getWidth() / 3, getHeight() / 5 + Util.dp2px(SKEWING), Util.dp2px(RADIUS),
        mPaint);
    ///还原画布
    canvas.restore();
    ///设置填充模式
    mPaint.setStyle(Paint.Style.FILL);
    ///设置画笔为蓝色
    mPaint.setColor(Color.parseColor("#549AE6"));
    ///绘制第三个蓝色实心圆
    canvas.drawCircle(getWidth() / 3, getHeight() / 5 * 4 - Util.dp2px(SKEWING), Util.dp2px(RADIUS),
        mPaint);
    ///保存画布
    canvas.save();
    ///将坐标系移动到第二个宽的3/1处
    canvas.translate(getWidth() / 3, 0);
    ///设置画线模式
    mPaint.setColor(Color.BLACK);
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeWidth(Util.dp2px(20));
    //绘制线宽为 20 的空心圆
    canvas.drawCircle(getWidth() / 3, getHeight() / 5 * 4 - Util.dp2px(15), Util.dp2px(RADIUS),
        mPaint);
    ///还原画布
    canvas.restore();
  }
}
