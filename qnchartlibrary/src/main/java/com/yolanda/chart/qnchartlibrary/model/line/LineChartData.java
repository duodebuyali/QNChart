package com.yolanda.chart.qnchartlibrary.model.line;

import com.yolanda.chart.qnchartlibrary.model.BaseChartData;

import java.util.List;

/**
 * @author: hekang
 * @description:线形图的数据
 * @date: 2018/11/21 16:04
 */
public class LineChartData extends BaseChartData {

    /**
     * lineChart中含有的线的数据
     */
    private List<BaseLine> lines;

    public LineChartData() {
    }

    public LineChartData(List<BaseLine> lines) {
        this.lines = lines;
    }

    public List<BaseLine> getLines() {
        return lines;
    }

    public void setLines(List<BaseLine> lines) {
        this.lines = lines;
    }
}
