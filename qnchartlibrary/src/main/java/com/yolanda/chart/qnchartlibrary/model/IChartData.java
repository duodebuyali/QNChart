package com.yolanda.chart.qnchartlibrary.model;

import com.yolanda.chart.qnchartlibrary.model.axis.XAxis;
import com.yolanda.chart.qnchartlibrary.model.axis.YAxis;

/**
 * @author: hekang
 * @description:用来描述chartView使用的数据应该具有的属性
 * @date: 2018/11/20 15:05
 */
public interface IChartData {

    /**
     * 获取底部的X轴
     */
    XAxis getXAxisBottom();

    /**
     * 设置底部的X轴
     */
    void setXAxisBottom(XAxis xAxis);

    /**
     * 获取左侧的Y轴
     */
    YAxis getYAxisLeft();

    /**
     * 设置左侧的Y轴
     */
    void setYAxisLeft(YAxis yAxis);

    /**
     * 获取顶部的X轴
     */
    XAxis getXAxisTop();

    /**
     * 设置顶部的X轴
     */
    void setXAxisTop(XAxis xAxis);

    /**
     * 获取右侧的Y轴
     */
    YAxis getYAxisRight();

    /**
     * 设置右侧的Y轴
     */
    void setYAxisRight(YAxis yAxis);

}
