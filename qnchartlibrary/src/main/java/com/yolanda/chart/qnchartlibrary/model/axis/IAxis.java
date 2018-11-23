package com.yolanda.chart.qnchartlibrary.model.axis;

/**
 * @author: hekang
 * @description:基础轴线类不实现，但XAxis和YAxis又确定需要的功能
 * @date: 2018/11/23 20:21
 */
public interface IAxis {

    /**
     * 获取轴线对应的位置
     */
    AxisPosition getAxisPosition();

    /**
     * 设置轴线对应的位置
     */
    void setAxisPosition(AxisPosition axisPosition);

}
