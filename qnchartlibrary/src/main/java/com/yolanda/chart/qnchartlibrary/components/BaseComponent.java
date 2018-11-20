package com.yolanda.chart.qnchartlibrary.components;

import android.graphics.Color;
import android.graphics.Typeface;

import com.yolanda.chart.qnchartlibrary.consts.AxisConst;
import com.yolanda.health.qnbaselibrary.utils.QNSizeUtils;

/**
 * @author: hekang
 * @description:各个组件的共有的属性描述
 * @date: 2018/11/20 20:11
 */
abstract class BaseComponent {

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
    protected int mTextColor = Color.BLACK;

    /**
     * 绘制线的颜色
     */
    protected int mLineColor = Color.BLACK;

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
}
