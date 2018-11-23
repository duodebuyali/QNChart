package com.yolanda.chart.qnchartlibrary.model.axis;

/**
 * @author: hekang
 * @description:
 * @date: 2018/11/23 14:52
 */
public class XAxis extends BaseAxis {

    /**
     * 左侧的额外距离，不纳入计算坐标轴的数据中
     * 具体描述参考[链接](绘制的参考图)
     */
    private float leftExtraSpace;

    /**
     * 右侧的额外距离，不纳入计算坐标轴的数据中
     */
    private float rightExtraSpace;

    /**
     * 设置轴线的位置
     */
    private AxisPosition xAxisPos = AxisPosition.BOTTOM;

    public float getLeftExtraSpace() {
        return leftExtraSpace;
    }

    public void setLeftExtraSpace(float leftExtraSpace) {
        this.leftExtraSpace = leftExtraSpace;
    }

    public float getRightExtraSpace() {
        return rightExtraSpace;
    }

    public void setRightExtraSpace(float rightExtraSpace) {
        this.rightExtraSpace = rightExtraSpace;
    }

    @Override
    public AxisPosition getAxisPosition() {
        return xAxisPos;
    }

    @Override
    public void setAxisPosition(AxisPosition xAxisPos) {
        this.xAxisPos = xAxisPos;
    }
}
