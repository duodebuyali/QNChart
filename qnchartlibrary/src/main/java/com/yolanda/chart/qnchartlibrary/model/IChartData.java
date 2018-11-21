package com.yolanda.chart.qnchartlibrary.model;

import com.yolanda.chart.qnchartlibrary.model.axis.BaseAxis;

/**
 * @author: hekang
 * @description:用来描述chartView使用的数据应该具有的属性
 * @date: 2018/11/20 15:05
 */
public interface IChartData {

    /**
     * 获取底部的X轴
     */
    BaseAxis getAxisXBottom();

    /**
     * 设置底部的X轴
     */
    void setAxisXBottom(BaseAxis axisX);

    /**
     * 获取左侧的Y轴
     */
    BaseAxis getAxisYLeft();

    /**
     * 设置左侧的Y轴
     */
    void setAxisYLeft(BaseAxis axisY);

    /**
     * 获取顶部的X轴
     */
    BaseAxis getAxisXTop();

    /**
     * 设置顶部的X轴
     */
    void setAxisXTop(BaseAxis axisX);

    /**
     * 获取右侧的Y轴
     */
    BaseAxis getAxisYRight();

    /**
     * 设置右侧的Y轴
     */
    void setAxisYRight(BaseAxis axisY);

}
