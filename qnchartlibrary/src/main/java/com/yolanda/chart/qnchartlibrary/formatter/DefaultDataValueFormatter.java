package com.yolanda.chart.qnchartlibrary.formatter;

import com.yolanda.chart.qnchartlibrary.model.BaseEntry;

/**
 * @author: hekang
 * @description:默认需要绘制数据点的label显示
 * @date: 2018/11/21 14:44
 */
public class DefaultDataValueFormatter implements IDataValueFormatter {

    @Override
    public String getFormattedValue(float value, BaseEntry entry, int dataSetIndex) {
        return value + "";
    }
}
