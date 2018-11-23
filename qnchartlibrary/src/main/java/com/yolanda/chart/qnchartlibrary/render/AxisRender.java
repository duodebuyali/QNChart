package com.yolanda.chart.qnchartlibrary.render;

import android.graphics.Paint;
import android.graphics.Typeface;

import com.yolanda.chart.qnchartlibrary.consts.AxisConst;
import com.yolanda.chart.qnchartlibrary.model.axis.AxisPosition;
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
     * 用来绘制轴线的limitLine的paint
     */
    private Paint[] limitPaintTab = new Paint[]{new Paint(), new Paint(), new Paint(), new Paint()};
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

    /**
     * chartView的大小改变
     */
    public void onChartSizeChanged() {
        onChartDataOrSizeChanged();
    }

    /**
     * chartView的数据改变
     */
    public void onChartDataChanged() {
        onChartDataOrSizeChanged();
    }

    /**
     * 在chartView的大小或数据改变时，重新设置轴线
     */
    private void onChartDataOrSizeChanged() {
        initAxis(chart.getChartData().getYAxisLeft());
        initAxis(chart.getChartData().getXAxisTop());
        initAxis(chart.getChartData().getYAxisRight());
        initAxis(chart.getChartData().getXAxisBottom());
    }

    /**
     * 重新设置轴线的具体属性
     */
    private void initAxis(BaseAxis axis) {
        if (null == axis) {
            return;
        }
        initAxisAttributes(axis);
        initAxisMargin(axis);
//        initAxisMeasurements(axis, position);
    }

    /**
     * 设置transformHandler的属性
     */
    private void initAxisMargin(BaseAxis axis) {
        int margin = 0;
        int position = axis.getAxisPosition().getCode();
        if (!axis.isLabelsInside() && (axis.getLabelCount() > 0)) {
            margin += QNSizeUtils.dp2px(axis.getAxisMargin()) + labelDimensionForMarginsTab[position];
        }
        insetContentRectWithAxesMargins(margin, position);
    }


    /**
     * 设置由于绘制轴线所占的位置，需要dataViewRect额外间隔的距离
     */
    private void insetContentRectWithAxesMargins(int axisMargin, int position) {
        if (AxisPosition.LEFT.getCode() == position) {
            transformHandler.insetDataViewRect(axisMargin, 0, 0, 0);
        } else if (AxisPosition.RIGHT.getCode() == position) {
            transformHandler.insetDataViewRect(0, 0, axisMargin, 0);
        } else if (AxisPosition.TOP.getCode() == position) {
            transformHandler.insetDataViewRect(0, axisMargin, 0, 0);
        } else if (AxisPosition.BOTTOM.getCode() == position) {
            transformHandler.insetDataViewRect(0, 0, 0, axisMargin);
        }
    }

    /**
     * 实现轴线属性的设置
     */
    private void initAxisAttributes(BaseAxis axis) {
        int position = axis.getAxisPosition().getCode();
        initAxisPaints(axis, position);
        if (axis.isDrawLabels()) {
            initAxisDimensionForTiltedLabels(position);
            initTiltedLabelsTranslation(axis, position);
        } else {
            initAxisDimension(position);
        }
    }

    /**
     * 初始化轴线labels的位置
     */
    private void initTiltedLabelsTranslation(BaseAxis axis, int position) {
        int pythagoreanFromLabelWidth = (int) Math.sqrt(Math.pow(labelWidthTab[position], 2) / 2);
        int pythagoreanFromAscent = (int) Math.sqrt(Math.pow(labelTextAscentTab[position], 2) / 2);
        int dx = 0;
        int dy = 0;
        if (axis.isLabelsInside()) {
            if (AxisPosition.LEFT.getCode() == position) {
                dx = pythagoreanFromAscent;
            } else if (AxisPosition.RIGHT.getCode() == position) {
                dy = -pythagoreanFromLabelWidth / 2;
            } else if (AxisPosition.TOP.getCode() == position) {
                dy = (pythagoreanFromAscent + pythagoreanFromLabelWidth / 2) - labelTextAscentTab[position];
            } else if (AxisPosition.BOTTOM.getCode() == position) {
                dy = -pythagoreanFromLabelWidth / 2;
            }
        } else {
            if (AxisPosition.LEFT.getCode() == position) {
                dy = -pythagoreanFromLabelWidth / 2;
            } else if (AxisPosition.RIGHT.getCode() == position) {
                dx = pythagoreanFromAscent;
            } else if (AxisPosition.TOP.getCode() == position) {
                dy = -pythagoreanFromLabelWidth / 2;
            } else if (AxisPosition.BOTTOM.getCode() == position) {
                dy = (pythagoreanFromAscent + pythagoreanFromLabelWidth / 2) - labelTextAscentTab[position];
            }
        }
        tiltedLabelXTranslation[position] = dx;
        tiltedLabelYTranslation[position] = dy;
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
        if (AxisPosition.LEFT.getCode() == position || AxisPosition.RIGHT.getCode() == position) {
            labelDimensionForMarginsTab[position] = labelWidthTab[position];
            labelDimensionForStepsTab[position] = labelTextAscentTab[position];
        } else if (AxisPosition.TOP.getCode() == position || AxisPosition.BOTTOM.getCode() == position) {
            labelDimensionForMarginsTab[position] = labelTextAscentTab[position] +
                    labelTextDescentTab[position];
            labelDimensionForStepsTab[position] = labelWidthTab[position];
        }
    }

}
