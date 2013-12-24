package com.adroid.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;

public class FontUtils {
    public static void setFont(Typeface tf, TextView view) {
        view.setTypeface(tf);
        view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }
}
