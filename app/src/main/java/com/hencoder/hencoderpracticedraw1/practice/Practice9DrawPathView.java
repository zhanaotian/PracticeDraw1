package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Util;

/**
 * @author cszdz
 * 练习内容：使用 canvas.drawPath() 方法画心形
 */
public class Practice9DrawPathView extends View {
  private Paint mPaint;
  private RectF mRectF = new RectF();
  private Path mPath = new Path();
  private static final float R = 50;

  public Practice9DrawPathView(Context context) {
    super(context);
  }

  public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint.setColor(Color.BLACK);
    mPaint.setStrokeWidth(Util.dp2px(2));
  }

  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mPath.addArc(getWidth() / 3, getHeight() / 3, getWidth() / 3 + Util.dp2px(R), getHeight() / 3 + Util.dp2px(R), -225, 225);
    mPath.arcTo(getWidth() / 3 + Util.dp2px(R), getHeight() / 3, getWidth() / 3 + Util.dp2px(R) * 2, getHeight() / 3 + Util.dp2px(R), -180, 225, false);
    mPath.lineTo(getWidth() / 3 + Util.dp2px(R), (float) (getHeight() / 3 + Util.dp2px(R) * 1.7));
    ///mPaint.setStyle(Paint.Style.STROKE);
    ///mRectF.set(getWidth() / 3, getHeight() / 3, (getWidth() / 3) * 2, (getHeight() / 3) * 2);
    //    ///第一组： addXxx() ——添加子图形
//    ///mPath.addArc(mRectF,0,190);
//    ///第二组：xxxTo() —— 画线（直线或曲线）
//    ///移动到目标位置
//    mPath.moveTo(20,20);
//    ///绘制一阶贝塞尔曲线
//    mPath.lineTo(100,100);
//    mPath.rLineTo(200,0);
//    ///绘制二阶贝塞尔曲线
//    mPath.rQuadTo(300,0,300,300);
//    ///绘制三阶贝塞尔曲线
//    mPath.cubicTo(200,200,100,250,300,350);
//    ///绘制弧形
//    mPath.arcTo(mRectF,0,190,false);
//    //close() 封闭当前子图形
//    mPath.close();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawPath(mPath, mPaint);
  }
}
