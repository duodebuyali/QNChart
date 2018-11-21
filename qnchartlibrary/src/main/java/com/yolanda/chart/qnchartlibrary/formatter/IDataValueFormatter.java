package com.yolanda.chart.qnchartlibrary.formatter;

import com.yolanda.chart.qnchartlibrary.model.BaseEntry;

/**
 * @author: hekang
 * @description:指定数据的显示label
 * @date: 2018/11/21 14:24
 */
public interface IDataValueFormatter {
    /**
     * @param value        需要显示的值
     * @param entry        需要显示的点的数据
     * @param dataSetIndex 需要显示的点对应在chartView中的数据的下标
     */
    String getFormattedValue(float value, BaseEntry entry, int dataSetIndex);
}
