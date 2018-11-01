package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw1.Util;

/**
 * @author paihaozhan
 * 综合练习
 * 练习内容：使用各种 Canvas.drawXXX() 方法画刻度表
 */
public class Practice12DialGaugeView extends View {
  private Paint mPaint;
  private RectF mRectF = new RectF();
  private PathDashPathEffect mEffect;
  private static final int ANGLE = 120;
  private static final int RADIUS = Util.dp2px(120);
  private static final int LENGTH = Util.dp2px(80);
  Path dash = new Path();

  public Practice12DialGaugeView(Context context) {
    super(context);
  }

  public Practice12DialGaugeView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice12DialGaugeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint.setColor(Color.BLACK);
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeWidth(Util.dp2px(2));
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mRectF.set(
        getWidth() / 2 - RADIUS,
        getHeight() / 2 - RADIUS,
        getWidth() / 2 + RADIUS,
        getHeight() / 2 + RADIUS);
    dash.addRect(0, 0, Util.dp2px(2), Util.dp2px(10), Path.Direction.CW);
    Path mArcPath = new Path();
    mArcPath.addArc(mRectF, 90 + ANGLE / 2, 360 - ANGLE);
    PathMeasure pathMeasure = new PathMeasure(mArcPath, false);
    mEffect = new PathDashPathEffect(dash, (pathMeasure.getLength() - Util.dp2px(2)) / 20, 0,
        PathDashPathEffect.Style.ROTATE);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    //绘制弧线
    canvas.drawArc(mRectF, 90 + ANGLE / 2, 360 - ANGLE, false, mPaint);
    mPaint.setPathEffect(mEffect);
    //绘制刻度
    canvas.drawArc(mRectF, 90 + ANGLE / 2, 360 - ANGLE, false, mPaint);
    mPaint.setPathEffect(null);
    //绘制指针
    canvas.drawLine(
        getWidth() / 2,
        getHeight() / 2,
        (float) Math.cos(Math.toRadians(getAngleFromMark(5))) * LENGTH + getWidth() / 2,
        (float) Math.sin(Math.toRadians(getAngleFromMark(5))) * LENGTH + getHeight() / 2,
        mPaint);
  }

  private int getAngleFromMark(int mark) {
    return (int) (90 + (float) ANGLE / 2 + (360 - ANGLE) / 20 * mark);
  }
}
