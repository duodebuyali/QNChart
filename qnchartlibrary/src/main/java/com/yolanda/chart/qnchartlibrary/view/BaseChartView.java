package com.yolanda.chart.qnchartlibrary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import com.yolanda.chart.qnchartlibrary.gesture.ChartTouchHandler;
import com.yolanda.chart.qnchartlibrary.render.AxisRender;
import com.yolanda.chart.qnchartlibrary.transform.ChartTransformHandler;


/**
 * @author: hekang
 * @description:图表view的实现基类
 * @date: 2018/11/15 15:35
 */
public abstract class BaseChartView extends View implements IChart {

    /**
     * 用来处理数据点和canvas上的像素点的转换
     */
    private ChartTransformHandler transformHandler;

    /**
     * 处理chartView的触摸事件
     */
    private ChartTouchHandler touchHandler;

    private AxisRender axesRenderer;

    public BaseChartView(Context context) {
        this(context, null, 0);
    }

    public BaseChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        transformHandler = new ChartTransformHandler();
        touchHandler = new ChartTouchHandler();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        transformHandler.setChartViewRect(getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(),
                getPaddingBottom());
//        chartRenderer.onChartSizeChanged();
//        axesRenderer.onChartSizeChanged();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isEnabled()) {
//            axesRenderer.drawInBackground(canvas);
//            int clipRestoreCount = canvas.save();
//            canvas.clipRect(chartComputator.getContentRectMinusAllMargins());
//            chartRenderer.draw(canvas);//在裁剪之后的画布绘制图表值和线
//            canvas.restoreToCount(clipRestoreCount);//获取裁剪之前的画布状态
//            chartRenderer.drawUnclipped(canvas);//在裁剪之前的画布上绘制一些东西
//            axesRenderer.drawInForeground(canvas);
        } else {
            canvas.drawColor(Color.GRAY);
        }
    }

    @Override
    public ChartTransformHandler getTransformHandler() {
        return transformHandler;
    }

    @Override
    public ChartTouchHandler getTouchHandler() {
        return touchHandler;
    }
}
