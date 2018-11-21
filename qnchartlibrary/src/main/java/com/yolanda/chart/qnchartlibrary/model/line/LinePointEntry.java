package com.yolanda.chart.qnchartlibrary.model.line;

import android.graphics.drawable.Drawable;

import com.yolanda.chart.qnchartlibrary.model.BaseEntry;

/**
 * @author: hekang
 * @description:线形图的点的数据 是否可以直接在点这里，指定绘制的形状
 * 这样可以做到每个点的样式都进行定制
 * @date: 2018/11/21 16:03
 */
public class LinePointEntry extends BaseEntry {
    /**
     * 选中时点的显示图片
     */
    private Drawable pressedIcon;

    public LinePointEntry() {
    }

    public LinePointEntry(float xValue, float yValue) {
        super(xValue, yValue);
    }

    public LinePointEntry(float xValue, float yValue, Drawable icon) {
        super(xValue, yValue, icon);
    }

    public LinePointEntry(float xValue, float yValue, Drawable icon, Drawable pressedIcon) {
        super(xValue, yValue, icon);
        this.pressedIcon = pressedIcon;
    }

    public Drawable getPressedIcon() {
        return pressedIcon;
    }

    public void setPressedIcon(Drawable pressedIcon) {
        this.pressedIcon = pressedIcon;
    }
}
