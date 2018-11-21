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
    public BaseAxis getAxisXBottom() {
        return baseAxisXBottom;
    }

    @Override
    public void setAxisXBottom(BaseAxis axisX) {
        baseAxisXBottom = axisX;
    }

    @Override
    public BaseAxis getAxisYLeft() {
        return baseAxisYLeft;
    }

    @Override
    public void setAxisYLeft(BaseAxis axisY) {
        baseAxisYLeft = axisY;
    }

    @Override
    public BaseAxis getAxisXTop() {
        return baseAxisXTop;
    }

    @Override
    public void setAxisXTop(BaseAxis axisX) {
        baseAxisXTop = axisX;
    }

    @Override
    public BaseAxis getAxisYRight() {
        return baseAxisYRight;
    }

    @Override
    public void setAxisYRight(BaseAxis axisY) {
        baseAxisYRight = axisY;
    }
}
