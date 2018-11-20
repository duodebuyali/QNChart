package com.yolanda.chart.qnchartlibrary.view;

import com.yolanda.chart.qnchartlibrary.gesture.ChartTouchHandler;
import com.yolanda.chart.qnchartlibrary.transform.ChartTransformHandler;

/**
 * @author: hekang
 * @description:用来描述ChartView的基本属性
 * @date: 2018/11/20 14:44
 */
public interface IChart {

    /**
     * 获取转化工具
     */
    ChartTransformHandler getTransformHandler();

    /**
     * 获取触摸监听
     */
    ChartTouchHandler getTouchHandler();
}
