package com.yolanda.chart.qnchartlibrary.formatter;

import com.yolanda.chart.qnchartlibrary.model.axis.BaseAxis;

/**
 * @author: hekang
 * @description:默认的坐标轴上label的显示
 * @date: 2018/11/21 14:43
 */
public class DefaultAxisValueFormatter implements IAxisValueFormatter {

    @Override
    public String getFormattedValue(float value, BaseAxis axis) {
        return value + "";
    }
}
