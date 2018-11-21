package com.yolanda.chart.qnchartlibrary.model;

import android.graphics.drawable.Drawable;

/**
 * @author: hekang
 * @description:用来描述图表数据属性的基类
 * @date: 2018/11/15 13:58
 */
public class BaseEntry {
    /**
     * 数据对应的x值
     */
    private float xValue;

    /**
     * 数据对应的y值
     */
    private float yValue;

    /**
     * 数据对应的图标
     */
    private Drawable icon;

    public BaseEntry() {
    }

    public BaseEntry(float xValue, float yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public BaseEntry(float xValue, float yValue, Drawable icon) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.icon = icon;
    }

    public float getXValue() {
        return xValue;
    }

    public void setXValue(float xValue) {
        this.xValue = xValue;
    }

    public float getYValue() {
        return yValue;
    }

    public void setYValue(float yValue) {
        this.yValue = yValue;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
