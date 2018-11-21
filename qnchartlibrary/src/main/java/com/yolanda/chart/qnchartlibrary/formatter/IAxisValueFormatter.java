package com.yolanda.chart.qnchartlibrary.formatter;

import com.yolanda.chart.qnchartlibrary.model.axis.BaseAxis;

/**
 * @author: hekang
 * @description: 用来指定轴线的label
 * @date: 2018/11/21 14:18
 */
public interface IAxisValueFormatter {
    /**
     * @param value 当前需要显示label的值
     * @param axis  当前轴线对象
     */
    String getFormattedValue(float value, BaseAxis axis);
}
