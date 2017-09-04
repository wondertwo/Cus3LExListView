package com.cheetah.adapter;

import android.content.Context;
import android.widget.ExpandableListView;

/** Cus3LListView. Created by wangyao1 on 2017.08.30. */

public class Cus3LListView extends ExpandableListView {

    public Cus3LListView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 999999 is a size in pixels.
        // ExpandableListView requires a maximum height in order to do measurement calculations.
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
