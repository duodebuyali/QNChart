package com.yolanda.chart.qnchartlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;


/**
 * @author: hekang
 * @description:图表view的实现基类
 * @date: 2018/11/15 15:35
 */
public abstract class BaseChartView extends View implements IChart {

    public BaseChartView(Context context) {
        this(context, null, 0);
    }

    public BaseChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }
}
