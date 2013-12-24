package com.adroid.views;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class FontTextView extends TextView {
    Context mContext;
    public static final String ATTR_FONT_FILE = "fontFileName";

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        final String fontFileName = attrs.getAttributeValue(
                    "http://schemas.android.com/apk/res-auto", ATTR_FONT_FILE);

        if (fontFileName != null & !isInEditMode()) {
            init(fontFileName);
        }
    }

    public FontTextView(Context context, String fontFileName) {
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
        super.setPaintFlags(this.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }
}
