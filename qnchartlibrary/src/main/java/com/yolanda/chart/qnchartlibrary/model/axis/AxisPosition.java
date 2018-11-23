package com.yolanda.chart.qnchartlibrary.model.axis;

/**
 * @author: hekang
 * @description:用来描述轴线的方位
 * @date: 2018/11/23 17:08
 */
public enum AxisPosition {
    /**
     * 四条轴线的方向，表示左侧的轴线
     */
    LEFT(0, "left"),
    /**
     * 四条轴线的方向，表示顶部的轴线
     */
    TOP(1, "top"),
    /**
     * 四条轴线的方向，表示右侧的轴线
     */
    RIGHT(2, "right"),
    /**
     * 四条轴线的方向，表示底部的轴线
     */
    BOTTOM(3, "bottom");

    private int code;
    private String name;

    private AxisPosition(int index, String name) {
        this.code = index;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
