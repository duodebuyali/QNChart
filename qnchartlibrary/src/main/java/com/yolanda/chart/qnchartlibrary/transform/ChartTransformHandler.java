package com.yolanda.chart.qnchartlibrary.transform;

import android.graphics.Rect;

import com.yolanda.chart.qnchartlibrary.model.Viewport;
import com.yolanda.chart.qnchartlibrary.model.axis.BaseAxis;

/**
 * @author: hekang
 * @description:用来处理绘制数据的矩形位置和图表数据的对应关系
 * @date: 2018/11/20 11:18
 */
public class ChartTransformHandler {
    /**
     * 当前view的宽度
     */
    protected int chartViewWidth;
    /**
     * 当前view的高度
     */
    protected int chartViewHeight;
    /**
     * 当前dataView的宽度
     */
    protected int dataViewWidth;
    /**
     * 当前dataView的高度
     */
    protected int dataViewHeight;

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
     * 绘制轴线的最大边界所对应的矩形,即除去BaseAxis中设置的axisMargin之后的范围
     * 参考{@link BaseAxis#setAxisMargin(float)}
     */
    protected Rect axisViewRect = new Rect();
    /**
     * 绘制图表数据的矩形，是传统意义上图表的四个边界包裹的位置
     */
    protected Rect dataViewRect = new Rect();
    /**
     * 描述dataViewRect绘制数据的当前范围
     */
    protected Viewport currentViewport = new Viewport();
    /**
     * 描述dataViewRect绘制数据的最大范围，即为开发者设置的X和Y轴中minAxis与maxAxis的内容
     */
    protected Viewport maxViewport = new Viewport();


    /**
     * 设置chartView的范围
     */
    public void setChartViewRect(int width, int height, int paddingLeft, int paddingTop, int paddingRight,
                                 int paddingBottom) {
        chartViewWidth = width;
        chartViewHeight = height;
        chartViewRect.set(paddingLeft, paddingTop, width - paddingRight, height - paddingBottom);
        //设置最外层的chartViewRect时，也初始化dataViewRect
        setDataViewRect(width, height, paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    /**
     * 设置dataView的范围
     */
    public void setDataViewRect(int width, int height, int paddingLeft, int paddingTop, int paddingRight,
                                int paddingBottom) {
        dataViewWidth = width;
        dataViewHeight = height;
        dataViewRect.set(paddingLeft, paddingTop, width - paddingRight, height - paddingBottom);
    }

    /**
     * 设置dataView的额外间隔
     */
    public void insetDataViewRect(int deltaLeft, int deltaTop, int deltaRight, int deltaBottom) {
        dataViewRect.left = dataViewRect.left + deltaLeft;
        dataViewRect.top = dataViewRect.top + deltaTop;
        dataViewRect.right = dataViewRect.right - deltaRight;
        dataViewRect.bottom = dataViewRect.bottom - deltaBottom;

        dataViewWidth = dataViewRect.width();
        dataViewHeight = dataViewRect.height();

    }

    /**
     * 设置当前的viewport的数据范围
     *
     * @param left   当前显示的dataView的最左侧的点对应的坐标值
     * @param top    当前显示的dataView的最顶端的点对应的坐标值
     * @param right  当前显示的dataView的最右侧的点对应的坐标值
     * @param bottom 当前显示的dataView的最底部的点对应的坐标值
     */
    public void setCurrentViewport(float left, float top, float right, float bottom) {
        currentViewport.set(left, top, right, bottom);
    }

    /**
     * 判断对应坐标值的点，是否属于当前viewport
     */
    public boolean containPoint(float xCoordinate, float yCoordinate) {
        return currentViewport.contains(xCoordinate, yCoordinate);
    }

    /**
     * 判断对应canvas像素点，是否属于当前viewport
     */
    public boolean containPixel(float xPixel, float yPixel) {
        return dataViewRect.contains((int) xPixel, (int) yPixel);
    }


    /**
     * 计算像素点对应的坐标值
     *
     * @param xPixel 对应的canvas像素点的x
     */
    public float xPixelToCoordinate(float xPixel) {
        float xRange = currentViewport.width();
        return xRange / dataViewWidth * xPixel + currentViewport.left;
    }

    /**
     * 计算点的坐标值对应的像素点
     *
     * @param xCoordinate 对应的x坐标值
     */
    public float xCoordinateToPixel(float xCoordinate) {
        float xRange = currentViewport.width();
        float curWidth = dataViewWidth / xRange * (xCoordinate - currentViewport.left);
        return chartViewWidth - dataViewWidth - curWidth;
    }

    /**
     * 转化指定的像素距离，为指定点对应的像素点
     *
     * @param xDistance 与左侧对应的像素距离
     */
    public float xDistanceToPixel(float xDistance) {
        return xDistance * (dataViewWidth / currentViewport.width());
    }


    /**
     * 计算像素点对应的坐标值
     *
     * @param yPixel 对应的canvas像素点的y
     */
    public float yPixelToCoordinate(float yPixel) {
        float yRange = currentViewport.height();
        return yRange / dataViewHeight * yPixel + currentViewport.bottom;
    }

    /**
     * 计算点的坐标值对应的像素点
     *
     * @param yCoordinate 对应的y坐标值
     */
    public float yCoordinateToPixel(float yCoordinate) {
        float yRange = currentViewport.height();
        float curHeight = dataViewHeight / yRange * (yCoordinate - currentViewport.bottom);
        return chartViewHeight - dataViewHeight - curHeight;
    }

    /**
     * 转化指定的像素距离，为指定点对应的像素点
     *
     * @param yDistance 与底部对应的像素距离
     */
    public float yDistanceToPixel(float yDistance) {
        return yDistance * (dataViewHeight / currentViewport.height());
    }
}
