package com.yolanda.chart.qnchartlibrary.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;

import com.yolanda.chart.qnchartlibrary.consts.AxisConst;

import java.util.List;

/**
 * @author: hekang
 * @description:用来描述轴线
 * @date: 2018/11/20 15:36
 */
public class BaseAxis extends BaseComponent {

    /**
     * 是否绘制轴线
     */
    protected boolean mDrawAxisLine = true;
    /**
     * 轴线的颜色
     */
    private int mAxisLineColor = mLineColor;
    /**
     * 轴线的宽度，默认1px
     */
    private float mAxisLineWidth = 1f;

    /**
     * 是否绘制轴线上的网格线
     */
    protected boolean mDrawGridLines;
    /**
     * 轴线上的网格线的颜色
     */
    private int mGridColor = Color.GRAY;
    /**
     * 轴线上的网格线的宽度，默认1px
     */
    private float mGridLineWidth = 1f;
    /**
     * 轴线上网格线绘制时，轴线上的点的间隔数(绘制轴线点的间隔)
     */
    private int mGridInterval = 1;
    /**
     * 轴线上的网格线，绘制虚线使用的DashPathEffect
     */
    private DashPathEffect mGridDashPathEffect = null;

    /**
     * 是否绘制轴线上点的label
     */
    protected boolean mDrawLabels = true;
    /**
     * 轴线上点的个数，默认{@link AxisConst#DEFAULT_MAX_AXIS_NUM_X}
     */
    private int mLabelCount = AxisConst.DEFAULT_MAX_AXIS_NUM_X;

    /**
     * 相对于轴线的限制线
     */
    protected List<LimitLine> mLimitLines;

    /**
     * 轴线的最小值
     */
    protected float mAxisMin;

    /**
     * 轴线的最大值
     */
    protected float mAxisMax;


}
