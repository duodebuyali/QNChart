package com.yolanda.chart.qnchartlibrary.model.axis;

import android.graphics.Bitmap;
import android.graphics.DashPathEffect;
import android.graphics.Paint;

import com.yolanda.chart.qnchartlibrary.consts.AxisConst;
import com.yolanda.chart.qnchartlibrary.model.BaseComponent;
import com.yolanda.health.qnbaselibrary.utils.QNSizeUtils;

/**
 * @author: hekang
 * @description:限制线
 * @date: 2018/11/20 21:19
 */
public class LimitLine extends BaseComponent {

    /**
     * 设置绘制限制线时的类型
     */
    private AxisLimitType mAxisLimitType;

    /**
     * 设置绘制限制线时的位置类型；
     * NORMAL为默认，表示绘制范围在Y轴以内
     * LEFT_FULL表示绘制范围在左侧占满，右侧在Y轴以内
     * RIGHT_FULL表示绘制范围在右侧占满，左侧在Y轴以内
     * HORIZONTAL_FULL表示绘制范围左右侧都占满
     * TOP_FULL表示绘制范围在上方占满，底部在X轴以内
     * BOTTOM_FULL表示绘制范围在底部占满，上方在X轴以内
     * VERTICAL_FULL表示绘制范围上下方都占满
     */
    public enum AxisLimitType {
        NORMAL, LEFT_FULL, RIGHT_FULL, HORIZONTAL_FULL, TOP_FULL, BOTTOM_FULL, VERTICAL_FULL
    }

    /**
     * 设置限制线的描述包含图片
     */
    private Bitmap mBitmap;
    /**
     * 描述限制线的图片的位置
     */
    private LimitBitmapPosition mBitmapPosition = LimitBitmapPosition.RIGHT_TOP;

    /**
     * 绘制描述限制线的图片的位置类型
     */
    public enum LimitBitmapPosition {
        LEFT_TOP, LEFT_BOTTOM, RIGHT_TOP, RIGHT_BOTTOM
        //新增4个位置，内部左侧中间和内部右侧中间，外部左侧中间和外部右侧中间；内部外部是相对于轴线来说
        , OUTSIDE_LEFT_CENTER, OUTSIDE_RIGHT_CENTER, INSIDE_LEFT_CENTER, INSIDE_RIGHT_CENTER
    }

    /**
     * 限制线对应的值
     */
    private float mLimit = 0f;

    /**
     * 绘制限制线时的文字类型
     */
    private Paint.Style mTextStyle = Paint.Style.FILL_AND_STROKE;

    /**
     * 限制线的描述文字
     */
    private String mLabel = "";
    /**
     * 绘制限制线描述文字时的位置
     */
    private LimitLabelPosition mLabelPosition = LimitLabelPosition.RIGHT_TOP;

    /**
     * 绘制限制线描述文字时的位置类型
     */
    public enum LimitLabelPosition {
        LEFT_TOP, LEFT_BOTTOM, RIGHT_TOP, RIGHT_BOTTOM
        //新增4个位置，内部左侧中间和内部右侧中间，外部左侧中间和外部右侧中间；内部外部是相对于Y轴来说
        , OUTSIDE_LEFT_CENTER, OUTSIDE_RIGHT_CENTER, INSIDE_LEFT_CENTER, INSIDE_RIGHT_CENTER
        //新增对外部位置的补充
        , OUTSIDE_LEFT_TOP, OUTSIDE_LEFT_BOTTOM, OUTSIDE_RIGHT_TOP, OUTSIDE_RIGHT_BOTTOM
    }

    /**
     * 限制线的宽度
     */
    private float mLineWidth = AxisConst.DEFAULT_LIMIT_LINE_WIDTH_PX;

    public LimitLine(float limit) {
        mLimit = limit;
    }

    public LimitLine(float limit, String label) {
        mLimit = limit;
        mLabel = label;
    }

    public AxisLimitType getAxisLimitType() {
        return mAxisLimitType;
    }

    public void setAxisLimitType(AxisLimitType mAxisLimitType) {
        this.mAxisLimitType = mAxisLimitType;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void setBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }

    public LimitBitmapPosition getBitmapPosition() {
        return mBitmapPosition;
    }

    public void setBitmapPosition(LimitBitmapPosition mBitmapPosition) {
        this.mBitmapPosition = mBitmapPosition;
    }

    public float getLimit() {
        return mLimit;
    }

    public void setLimit(float mLimit) {
        this.mLimit = mLimit;
    }

    public Paint.Style getTextStyle() {
        return mTextStyle;
    }

    public void setTextStyle(Paint.Style mTextStyle) {
        this.mTextStyle = mTextStyle;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String mLabel) {
        this.mLabel = mLabel;
    }

    public LimitLabelPosition getLabelPosition() {
        return mLabelPosition;
    }

    public void setLabelPosition(LimitLabelPosition mLabelPosition) {
        this.mLabelPosition = mLabelPosition;
    }

    public float getLineWidth() {
        return mLineWidth;
    }

    /**
     * 设置线宽，范围为0.2dp~12dp
     */
    public void setLineWidth(float width) {
        if (width < 0.2f)
            width = 0.2f;
        if (width > 12.0f)
            width = 12.0f;
        mLineWidth = QNSizeUtils.dp2px(width);
    }

}
