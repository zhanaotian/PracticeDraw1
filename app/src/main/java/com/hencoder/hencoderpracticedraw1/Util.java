package com.hencoder.hencoderpracticedraw1;

import android.content.res.Resources;
import android.util.TypedValue;

public class Util {
  /**
   * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
   * @param dpValue dp
   * @return px 像素
   */
  public static int dp2px(float dpValue) {
    return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue,
        Resources.getSystem().getDisplayMetrics());
  }
}
