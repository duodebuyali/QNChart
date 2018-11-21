package com.yolanda.chart.qnchartlibrary.model.axis;

import android.graphics.Color;
import android.graphics.DashPathEffect;

import com.yolanda.chart.qnchartlibrary.consts.AxisConst;
import com.yolanda.chart.qnchartlibrary.model.BaseComponent;

import java.util.ArrayList;
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
    private float mAxisLineWidth = AxisConst.DEFAULT_AXIS_LINE_WIDTH_PX;

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
    private float mGridLineWidth = AxisConst.DEFAULT_AXIS_LINE_WIDTH_PX;
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
     * 轴线上点的个数，默认{@link AxisConst#DEFAULT_MAX_AXIS_NUM}
     */
    private int mLabelCount = AxisConst.DEFAULT_MAX_AXIS_NUM;

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

    /**
     * 绘制虚线 "- - - - - -"
     *
     * @param lineLength  一段虚线中线的长度
     * @param spaceLength 一段虚线中空格的长度
     * @param phase       偏移，以度数表示，通常为0
     */
    public void enableGridDashedLine(float lineLength, float spaceLength, float phase) {
        mGridDashPathEffect = new DashPathEffect(new float[]{
                lineLength, spaceLength
        }, phase);
    }

    public void setGridDashedLine(DashPathEffect effect) {
        mGridDashPathEffect = effect;
    }

    public DashPathEffect getGridDashPathEffect() {
        return mGridDashPathEffect;
    }

    /**
     * 关闭虚线绘制
     */
    public void disableGridDashedLine() {
        mGridDashPathEffect = null;
    }

    /**
     * 返回是否开启了虚线绘制
     *
     * @return
     */
    public boolean isGridDashedLineEnabled() {
        return mGridDashPathEffect != null;
    }


    /**
     * 增加限制线
     *
     * @param l 限制线
     */
    public void addLimitLine(LimitLine l) {
        if (mLimitLines == null) {
            mLimitLines = new ArrayList<>();
        }
        mLimitLines.add(l);
    }

    /**
     * 移除指定的限制线
     *
     * @param l
     */
    public boolean removeLimitLine(LimitLine l) {
        if (mLimitLines != null) {
            return mLimitLines.remove(l);
        }
        return false;
    }

    /**
     * 移除所有的限制线
     */
    public void removeAllLimitLines() {
        if (mLimitLines != null) {
            mLimitLines.clear();
        }
    }

    public boolean isDrawAxisLine() {
        return mDrawAxisLine;
    }

    public void setDrawAxisLine(boolean mDrawAxisLine) {
        this.mDrawAxisLine = mDrawAxisLine;
    }

    public int getAxisLineColor() {
        return mAxisLineColor;
    }

    public void setAxisLineColor(int mAxisLineColor) {
        this.mAxisLineColor = mAxisLineColor;
    }

    public float getAxisLineWidth() {
        return mAxisLineWidth;
    }

    public void setAxisLineWidth(float mAxisLineWidth) {
        this.mAxisLineWidth = mAxisLineWidth;
    }

    public boolean isDrawGridLines() {
        return mDrawGridLines;
    }

    public void setDrawGridLines(boolean mDrawGridLines) {
        this.mDrawGridLines = mDrawGridLines;
    }

    public int getGridColor() {
        return mGridColor;
    }

    public void setGridColor(int mGridColor) {
        this.mGridColor = mGridColor;
    }

    public float getGridLineWidth() {
        return mGridLineWidth;
    }

    public void setGridLineWidth(float mGridLineWidth) {
        this.mGridLineWidth = mGridLineWidth;
    }

    public int getGridInterval() {
        return mGridInterval;
    }

    public void setGridInterval(int mGridInterval) {
        this.mGridInterval = mGridInterval;
    }

    public boolean isDrawLabels() {
        return mDrawLabels;
    }

    public void setDrawLabels(boolean mDrawLabels) {
        this.mDrawLabels = mDrawLabels;
    }

    public int getLabelCount() {
        return mLabelCount;
    }

    public void setLabelCount(int mLabelCount) {
        this.mLabelCount = mLabelCount;
    }

    public List<LimitLine> getLimitLines() {
        return mLimitLines;
    }

    public void setLimitLines(List<LimitLine> mLimitLines) {
        this.mLimitLines = mLimitLines;
    }

    public float getAxisMin() {
        return mAxisMin;
    }

    public void setAxisMin(float mAxisMin) {
        this.mAxisMin = mAxisMin;
    }

    public float getAxisMax() {
        return mAxisMax;
    }

    public void setmAxisMax(float mAxisMax) {
        this.mAxisMax = mAxisMax;
    }
}
