package com.yolanda.chart.qnchartlibrary.model;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;

import com.yolanda.chart.qnchartlibrary.consts.AxisConst;
import com.yolanda.chart.qnchartlibrary.consts.ComponetConst;
import com.yolanda.health.qnbaselibrary.utils.QNSizeUtils;

/**
 * @author: hekang
 * @description:各个组件的共有的属性描述
 * @date: 2018/11/20 20:11
 */
public abstract class BaseComponent {

    /**
     * 组件是否需要绘制
     */
    protected boolean mEnabled = true;

    /**
     * 绘制字体的字形
     */
    protected Typeface mTypeface = null;

    /**
     * 绘制字体的大小，默认12sp
     */
    protected float mTextSize = QNSizeUtils.sp2px(AxisConst.DEFAULT_TEXT_SIZE_SP);

    /**
     * 绘制字体的颜色
     */
    protected int mTextColor = ComponetConst.DEFAULT_TEXT_COLOR;

    /**
     * 绘制线的颜色
     */
    protected int mLineColor = ComponetConst.DEFAULT_LINE_COLOR;

    /**
     * 用来绘制虚线
     */
    protected DashPathEffect mDashPathEffect = null;

    /**
     * 绘制虚线 "- - - - - -"
     *
     * @param lineLength  一段虚线中线的长度
     * @param spaceLength 一段虚线中空格的长度
     * @param phase       偏移，以度数表示，通常为0
     */
    public void enableDashedLine(float lineLength, float spaceLength, float phase) {
        mDashPathEffect = new DashPathEffect(new float[]{
                lineLength, spaceLength
        }, phase);
    }

    /**
     * 关闭虚线绘制
     */
    public void disableDashedLine() {
        mDashPathEffect = null;
    }

    /**
     * 返回是否开启了虚线绘制
     *
     * @return
     */
    public boolean isDashedLineEnabled() {
        return mDashPathEffect != null;
    }

    public boolean isEnabled() {
        return mEnabled;
    }

    public void setEnabled(boolean mEnabled) {
        this.mEnabled = mEnabled;
    }

    public Typeface getTypeface() {
        return mTypeface;
    }

    public void setTypeface(Typeface mTypeface) {
        this.mTypeface = mTypeface;
    }

    public float getTextSize() {
        return mTextSize;
    }

    public void setTextSize(float mTextSize) {
        this.mTextSize = mTextSize;
    }

    public int getmTextColor() {
        return mTextColor;
    }

    public void setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public int getLineColor() {
        return mLineColor;
    }

    public void setLineColor(int mLineColor) {
        this.mLineColor = mLineColor;
    }

    public DashPathEffect getDashPathEffect() {
        return mDashPathEffect;
    }

    public void setDashPathEffect(DashPathEffect mDashPathEffect) {
        this.mDashPathEffect = mDashPathEffect;
    }
}
