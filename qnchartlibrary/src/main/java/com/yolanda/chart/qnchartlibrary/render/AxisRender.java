package com.yolanda.chart.qnchartlibrary.render;

import android.graphics.Paint;
import android.graphics.Typeface;

import com.yolanda.chart.qnchartlibrary.consts.AxisConst;
import com.yolanda.chart.qnchartlibrary.model.axis.BaseAxis;
import com.yolanda.chart.qnchartlibrary.transform.ChartTransformHandler;
import com.yolanda.chart.qnchartlibrary.view.IChart;
import com.yolanda.health.qnbaselibrary.utils.QNSizeUtils;

/**
 * @author: hekang
 * @description:
 * @date: 2018/11/22 17:59
 */
public class AxisRender extends BaseRender {
    /**
     * 用来绘制轴线的paint
     */
    private Paint[] linePaintTab = new Paint[]{new Paint(), new Paint(), new Paint(), new Paint()};
    /**
     * 用来绘制轴线的label的paint
     */
    private Paint[] labelPaintTab = new Paint[]{new Paint(), new Paint(), new Paint(), new Paint()};

    /**
     * 用来绘制轴线的girdLine的paint
     */
    private Paint[] gridPaintTab = new Paint[]{new Paint(), new Paint(), new Paint(), new Paint()};
    /**
     * 绘制轴线的label的宽度
     */
    private int[] labelWidthTab = new int[4];
    /**
     * 绘制轴线的label的ascent
     */
    private int[] labelTextAscentTab = new int[4];
    /**
     * 绘制轴线的label的descent
     */
    private int[] labelTextDescentTab = new int[4];

    private int[] labelDimensionForMarginsTab = new int[4];
    private int[] labelDimensionForStepsTab = new int[4];
    private int[] tiltedLabelXTranslation = new int[4];
    private int[] tiltedLabelYTranslation = new int[4];

    /**
     * 用来测量绘制label的属性
     */
    private Paint.FontMetricsInt[] fontMetricsTab = new Paint.FontMetricsInt[]{new Paint.FontMetricsInt(), new Paint.FontMetricsInt(),
            new Paint.FontMetricsInt(), new Paint.FontMetricsInt()};

    private ChartTransformHandler transformHandler;

    public AxisRender(IChart chart) {
        super(chart);
        transformHandler = chart.getTransformHandler();
        for (int position = 0; position < 4; ++position) {
            labelPaintTab[position].setStyle(Paint.Style.FILL);
            labelPaintTab[position].setAntiAlias(true);

            linePaintTab[position].setStyle(Paint.Style.STROKE);
            linePaintTab[position].setAntiAlias(true);

            gridPaintTab[position].setStyle(Paint.Style.STROKE);
            gridPaintTab[position].setAntiAlias(true);
        }
    }

    public void onChartSizeChanged() {
        onChartDataOrSizeChanged();
    }

    public void onChartDataChanged() {
        onChartDataOrSizeChanged();
    }

    /**
     * 重新设置轴线
     */
    private void onChartDataOrSizeChanged() {
        initAxis(chart.getChartData().getAxisYLeft(), AxisConst.LEFT);
        initAxis(chart.getChartData().getAxisXTop(), AxisConst.TOP);
        initAxis(chart.getChartData().getAxisYRight(), AxisConst.RIGHT);
        initAxis(chart.getChartData().getAxisXBottom(), AxisConst.BOTTOM);
    }

    /**
     * 重新设置轴线的具体属性
     */
    private void initAxis(BaseAxis axis, int position) {
        if (null == axis) {
            return;
        }
        initAxisAttributes(axis, position);
//        initAxisMargin(axis, position);
//        initAxisMeasurements(axis, position);
    }

    /**
     * 实现轴线属性的设置
     */
    private void initAxisAttributes(BaseAxis axis, int position) {
        initAxisPaints(axis, position);
        if (axis.isDrawLabels()) {
            initAxisDimensionForTiltedLabels(position);
            intiTiltedLabelsTranslation(axis, position);
        } else {
            initAxisDimension(position);
        }
    }

    /**
     * 设置轴线的画笔属性
     */
    private void initAxisPaints(BaseAxis axis, int position) {
        Typeface typeface = axis.getTypeface();
        if (null != typeface) {
            labelPaintTab[position].setTypeface(typeface);
        }
        labelPaintTab[position].setColor(axis.getTextColor());
        labelPaintTab[position].setTextSize(QNSizeUtils.sp2px(axis.getTextSize()));
        labelPaintTab[position].getFontMetricsInt(fontMetricsTab[position]);
        linePaintTab[position].setColor(axis.getLineColor());
        gridPaintTab[position].setColor(axis.getGridColor());

        labelTextAscentTab[position] = Math.abs(fontMetricsTab[position].ascent);
        labelTextDescentTab[position] = Math.abs(fontMetricsTab[position].descent);
        labelWidthTab[position] = (int) labelPaintTab[position].measureText(AxisConst.labelWidthChars, 0,
                AxisConst.DEFAULT_LABELS_MAX_NUM);
    }

    private void initAxisDimensionForTiltedLabels(int position) {
        int pythagoreanFromLabelWidth = (int) Math.sqrt(Math.pow(labelWidthTab[position], 2) / 2);
        int pythagoreanFromAscent = (int) Math.sqrt(Math.pow(labelTextAscentTab[position], 2) / 2);
        labelDimensionForMarginsTab[position] = pythagoreanFromAscent + pythagoreanFromLabelWidth;
        labelDimensionForStepsTab[position] = Math.round(labelDimensionForMarginsTab[position] * 0.75f);
    }

    private void initAxisDimension(int position) {
        if (LEFT == position || RIGHT == position) {
            labelDimensionForMarginsTab[position] = labelWidthTab[position];
            labelDimensionForStepsTab[position] = labelTextAscentTab[position];
        } else if (TOP == position || BOTTOM == position) {
            labelDimensionForMarginsTab[position] = labelTextAscentTab[position] +
                    labelTextDescentTab[position];
            labelDimensionForStepsTab[position] = labelWidthTab[position];
        }
    }

}
