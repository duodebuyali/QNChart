package com.yolanda.chart.qnchartlibrary.model.line;

import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;

import com.yolanda.chart.qnchartlibrary.consts.ComponetConst;
import com.yolanda.chart.qnchartlibrary.formatter.DefaultDataValueFormatter;
import com.yolanda.chart.qnchartlibrary.formatter.IDataValueFormatter;
import com.yolanda.chart.qnchartlibrary.model.BaseComponent;
import com.yolanda.health.qnbaselibrary.utils.QNSizeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hekang
 * @description:线形图中的一条线
 * @date: 2018/11/21 16:04
 */
public class BaseLine extends BaseComponent {
    /**
     * 是否绘制数据点
     */
    private boolean hasPoints = true;
    /**
     * 是否绘制点的值
     */
    private boolean hasLabels = false;
    /**
     * 是否绘制线条
     */
    private boolean hasLines = true;
    /**
     * 绘制的线的类型
     */
    private LineShape lineShape = LineShape.LINEAR;
    /**
     * 绘制的点的类型
     */
    private PointShape pointShape = PointShape.CIRCLE;
    /**
     * 绘制数据点的图形的第一个宽度
     */
    private float mFirstWidth = ComponetConst.DEFAULT_POINT_FIRST_WIDTH_DP;
    /**
     * 绘制数据点的图形的第二个宽度，如果>0就会绘制第二层图形
     */
    private float mSecondWidth;
    /**
     * 高亮线的线宽,单位dp
     */
    private float mHighlightLineWidth = QNSizeUtils.dp2px(ComponetConst.DEFAULT_LINE_WIDTH_DP);
    /**
     * 是否在数据点选中时，绘制垂直的高亮线
     */
    private boolean mDrawVerticalHighlightIndicator = true;
    /**
     * 是否在数据点选中时，绘制水平的高亮线
     */
    private boolean mDrawHorizontalHighlightIndicator = true;
    /**
     * 绘制高亮线为虚线时，使用的DashPathEffect
     */
    private DashPathEffect mHighlightDashPathEffect = null;
    /**
     * 当前线上的所有点的数据
     */
    private List<LinePointEntry> values = new ArrayList<LinePointEntry>();
    /**
     * 当前线上的点显示的label的样式
     */
    private IDataValueFormatter dataValueFormatter = new DefaultDataValueFormatter();
    /**
     * 当前线与X轴线之间的填充图片
     */
    private Drawable mFillDrawable;

    /**
     * 是否当前线需要填充
     */
    public boolean isFilledLine() {
        return mFillDrawable != null;
    }

    /**
     * 绘制高亮线的虚线 "- - - - - -"
     *
     * @param lineLength  一段虚线中线的长度
     * @param spaceLength 一段虚线中空格的长度
     * @param phase       偏移，以度数表示，通常为0
     */
    public void enableDashedHighlightLine(float lineLength, float spaceLength, float phase) {
        mHighlightDashPathEffect = new DashPathEffect(new float[]{
                lineLength, spaceLength
        }, phase);
    }

    /**
     * 关闭高亮线的虚线绘制
     */
    public void disableDashedHighlightLine() {
        mHighlightDashPathEffect = null;
    }

    /**
     * 返回是否开启了高亮线的虚线绘制
     *
     * @return
     */
    public boolean isDashedHighlightLineEnabled() {
        return mHighlightDashPathEffect != null;
    }

    public boolean isHasPoints() {
        return hasPoints;
    }

    public void setHasPoints(boolean hasPoints) {
        this.hasPoints = hasPoints;
    }

    public boolean isHasLabels() {
        return hasLabels;
    }

    public void setHasLabels(boolean hasLabels) {
        this.hasLabels = hasLabels;
    }

    public boolean isHasLines() {
        return hasLines;
    }

    public void setHasLines(boolean hasLines) {
        this.hasLines = hasLines;
    }

    public LineShape getLineShape() {
        return lineShape;
    }

    public void setLineShape(LineShape lineShape) {
        this.lineShape = lineShape;
    }

    public PointShape getPointShape() {
        return pointShape;
    }

    public void setPointShape(PointShape pointShape) {
        this.pointShape = pointShape;
    }

    public float getFirstWidth() {
        return mFirstWidth;
    }

    public void setFirstWidth(float mFirstWidth) {
        this.mFirstWidth = mFirstWidth;
    }

    public float getSecondWidth() {
        return mSecondWidth;
    }

    public void setSecondWidth(float mSecondWidth) {
        this.mSecondWidth = mSecondWidth;
    }

    public float getHighlightLineWidth() {
        return mHighlightLineWidth;
    }

    public void setHighlightLineWidth(float mHighlightLineWidth) {
        this.mHighlightLineWidth = mHighlightLineWidth;
    }

    public boolean isDrawVerticalHighlightIndicator() {
        return mDrawVerticalHighlightIndicator;
    }

    public void setDrawVerticalHighlightIndicator(boolean mDrawVerticalHighlightIndicator) {
        this.mDrawVerticalHighlightIndicator = mDrawVerticalHighlightIndicator;
    }

    public boolean isDrawHorizontalHighlightIndicator() {
        return mDrawHorizontalHighlightIndicator;
    }

    public void setDrawHorizontalHighlightIndicator(boolean mDrawHorizontalHighlightIndicator) {
        this.mDrawHorizontalHighlightIndicator = mDrawHorizontalHighlightIndicator;
    }

    public DashPathEffect getHighlightDashPathEffect() {
        return mHighlightDashPathEffect;
    }

    public void setHighlightDashPathEffect(DashPathEffect mHighlightDashPathEffect) {
        this.mHighlightDashPathEffect = mHighlightDashPathEffect;
    }

    public List<LinePointEntry> getValues() {
        return values;
    }

    public void setValues(List<LinePointEntry> values) {
        this.values = values;
    }

    public IDataValueFormatter getDataValueFormatter() {
        return dataValueFormatter;
    }

    public void setDataValueFormatter(IDataValueFormatter dataValueFormatter) {
        this.dataValueFormatter = dataValueFormatter;
    }

    public Drawable getFillDrawable() {
        return mFillDrawable;
    }

    public void setFillDrawable(Drawable mFillDrawable) {
        this.mFillDrawable = mFillDrawable;
    }
}
