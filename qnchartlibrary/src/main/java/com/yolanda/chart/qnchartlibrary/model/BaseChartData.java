package com.yolanda.chart.qnchartlibrary.model;

import com.yolanda.chart.qnchartlibrary.model.axis.BaseAxis;

/**
 * @author: hekang
 * @description:用来描述chartView的数据
 * @date: 2018/11/20 15:09
 */
public class BaseChartData implements IChartData {
    /**
     * 底部的X轴
     */
    protected BaseAxis baseAxisXBottom;
    /**
     * 左侧的Y轴
     */
    protected BaseAxis baseAxisYLeft;
    /**
     * 顶部的X轴
     */
    protected BaseAxis baseAxisXTop;
    /**
     * 右侧的Y轴
     */
    protected BaseAxis baseAxisYRight;

    @Override
    public BaseAxis getXAxisBottom() {
        return baseAxisXBottom;
    }

    @Override
    public void setXAxisBottom(BaseAxis axisX) {
        baseAxisXBottom = axisX;
    }

    @Override
    public BaseAxis getYAxisLeft() {
        return baseAxisYLeft;
    }

    @Override
    public void setYAxisLeft(BaseAxis axisY) {
        baseAxisYLeft = axisY;
    }

    @Override
    public BaseAxis getXAxisTop() {
        return baseAxisXTop;
    }

    @Override
    public void setAxisXTop(BaseAxis axisX) {
        baseAxisXTop = axisX;
    }

    @Override
    public BaseAxis getYAxisRight() {
        return baseAxisYRight;
    }

    @Override
    public void setYAxisRight(BaseAxis axisY) {
        baseAxisYRight = axisY;
    }
}
