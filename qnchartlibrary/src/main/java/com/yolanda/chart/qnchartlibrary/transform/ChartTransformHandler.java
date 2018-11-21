package com.yolanda.chart.qnchartlibrary.transform;

import android.graphics.Rect;

import com.yolanda.chart.qnchartlibrary.model.Viewport;

/**
 * @author: hekang
 * @description:用来处理绘制数据的矩形位置和图表数据的对应关系
 * @date: 2018/11/20 11:18
 */
public class ChartTransformHandler {
    /**
     * 默认图表的最大缩放倍数
     */
    protected static final float DEFAULT_MAX_ZOOM = 10f;
    /**
     * 默认图表的最小缩放倍数
     */
    protected static final float DEFAULT_MIN_ZOOM = 0.1f;
    /**
     * 当前设置的最大放大倍数
     */
    protected float maxXScale = DEFAULT_MAX_ZOOM;

    /**
     * 当前设置的最小缩放倍数
     */
    protected float minXScale = DEFAULT_MAX_ZOOM;
    /**
     * 当前view的宽度
     */
    protected int chartWidth;
    /**
     * 当前view的高度
     */
    protected int chartHeight;

    /**
     * 当前X轴的缩放倍数
     */
    private float mScaleX = 1f;

    /**
     * 当前Y轴的缩放倍数
     */
    private float mScaleY = 1f;

    /**
     * 当前X轴的平移距离
     */
    private float mTransX = 0f;

    /**
     * 当前Y轴的平移距离
     */
    private float mTransY = 0f;

    /**
     * 整个view的大小，除去了padding
     */
    protected Rect chartViewRect = new Rect();
    /**
     * 绘制图表数据的矩形，是传统意义上图表的四个边界包裹的位置
     */
    protected Rect dataViewRect = new Rect();
    /**
     * 描述dataViewRect绘制数据的范围
     */
    protected Viewport currentViewport = new Viewport();


}
