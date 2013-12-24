package com.adroid.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.adroid.utils.FontUtils;

public class FontTextView extends TextView {
    Context mContext;

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        TypedArray a = mContext.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.FontTextview,
                0,0);

        String fontFileName = null;
        assert a != null;
        try {
            fontFileName = a.getString(R.styleable.FontTextview_fontFile);
        } finally {
            a.recycle();
        }

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
        FontUtils.setFont(tf, this);
    }
}
