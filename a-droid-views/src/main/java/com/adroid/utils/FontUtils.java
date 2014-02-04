package com.adroid.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;

/**
* A utility class to set particular properties on font typefaces used
* by views in the com.adroid.views package
*/
public class FontUtils {
    public static void setFontProperties(TextView view, Typeface tf) {
        view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }
}
