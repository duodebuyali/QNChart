package com.yolanda.chart.qnchartlibrary.model.axis;

/**
 * @author: hekang
 * @description:
 * @date: 2018/11/23 17:45
 */
public class YAxis extends BaseAxis {
    /**
     * 顶部的额外距离，不纳入计算坐标轴的数据中
     * 具体描述参考[链接](绘制的参考图)
     */
    private float topExtraSpace;

    /**
     * 底部的额外距离，不纳入计算坐标轴的数据中
     */
    private float bottomExtraSpace;

    /**
     * 设置轴线的位置
     */
    private AxisPosition yAxisPos = AxisPosition.LEFT;

    public float getTopExtraSpace() {
        return topExtraSpace;
    }

    public void setTopExtraSpace(float topExtraSpace) {
        this.topExtraSpace = topExtraSpace;
    }

    public float getBottomExtraSpace() {
        return bottomExtraSpace;
    }

    public void setBottomExtraSpace(float bottomExtraSpace) {
        this.bottomExtraSpace = bottomExtraSpace;
    }

    @Override
    public AxisPosition getAxisPosition() {
        return yAxisPos;
    }

    @Override
    public void setAxisPosition(AxisPosition yAxisPos) {
        this.yAxisPos = yAxisPos;
    }

}
