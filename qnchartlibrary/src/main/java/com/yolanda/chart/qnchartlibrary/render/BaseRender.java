package com.yolanda.chart.qnchartlibrary.render;

import com.yolanda.chart.qnchartlibrary.view.IChart;

/**
 * @author: hekang
 * @description:绘制canvas上图表的具体实现的基类
 * @date: 2018/11/15 15:15
 */
public class BaseRender {

    /**
     * 当前需要绘制的chart
     */
    protected IChart chart;

    public BaseRender(IChart chart) {
        this.chart = chart;
    }
}
