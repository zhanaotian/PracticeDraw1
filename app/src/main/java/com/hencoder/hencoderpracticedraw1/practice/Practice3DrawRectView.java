package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw1.Util;

/**
 * @author paihaozhan
 * 练习内容：使用 canvas.drawRect() 方法画矩形
 */
public class Practice3DrawRectView extends View {
  private Paint mPaint;
  private Rect mRect = new Rect();
  private RectF mRectF =  new RectF();

  public Practice3DrawRectView(Context context) {
    super(context);
  }

  public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint.setColor(Color.BLACK);
  }

  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mRect.set(Util.dp2px(110), Util.dp2px(60), Util.dp2px(250), Util.dp2px(200));
    mRectF.set(Util.dp2px(110), Util.dp2px(60), Util.dp2px(250), Util.dp2px(200));
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    ///canvas.drawRect(Util.dp2px(110), Util.dp2px(60), Util.dp2px(250), Util.dp2px(200),mPaint);
    ///canvas.drawRect(mRect, mPaint);
    canvas.drawRect(mRectF, mPaint);
  }
}
