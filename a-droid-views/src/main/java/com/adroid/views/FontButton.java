package com.adroid.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.adroid.utils.FontUtils;

/**
 * A Button that can apply font from 'fontFile' XML attribute
 */
public class FontButton extends Button {
  Context mContext;

  public FontButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.mContext = context;

    TypedArray a = mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.FontView, 0, 0);

    String fontFileName = null;
    assert a != null;
    try {
      fontFileName = a.getString(R.styleable.FontView_fontFile);
    } finally {
      a.recycle();
    }

    if (fontFileName != null & !isInEditMode()) {
      init(fontFileName);
    }
  }

  public FontButton(Context context, String fontFileName) {
    super(context);
    this.mContext = context;

    if (!isInEditMode()) {
      init(fontFileName);
    }
  }

  private void init(String fileName) {
    Typeface font = Typeface.createFromAsset(mContext.getAssets(), fileName);
    setTypeface(font);
  }

  @Override
  public void setTypeface(Typeface tf) {
    super.setTypeface(tf);
    FontUtils.setFontProperties(this, tf);
  }
}
