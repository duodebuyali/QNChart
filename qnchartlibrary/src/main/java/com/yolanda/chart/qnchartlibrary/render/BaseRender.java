package com.yolanda.chart.qnchartlibrary.render;

import com.yolanda.chart.qnchartlibrary.transform.ChartTransformHandler;

/**
 * @author: hekang
 * @description:绘制canvas上图表的具体实现的基类
 * @date: 2018/11/15 15:15
 */
public class BaseRender {

    /**
     * 描述当前显示的数据范围
     */
    protected ChartTransformHandler mChartTransformHandler;

    public BaseRender(ChartTransformHandler chartTransformHandler) {
        this.mChartTransformHandler = chartTransformHandler;
    }
}
