package com.example.google.map_list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Custom CardView class that intercepts touch events that would otherwise be passed to its
 * children. Useful when one of the children is a MapView, which receives touch event to markers
 * and info windows.
 */
public class MapCardView extends android.support.v7.widget.CardView {
    public MapCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
