package com.yolanda.chart.qnchartlibrary.consts;

/**
 * @author: hekang
 * @description:使用在轴线中的常量
 * @date: 2018/11/20 18:01
 */
public interface AxisConst {
    /**
     * 默认轴线label的字体大小
     */
    int DEFAULT_TEXT_SIZE_SP = 12;
    /**
     * 默认X轴线上的点的最大个数
     */
    int DEFAULT_MAX_AXIS_NUM = 10;
    /**
     * 默认X轴线上的点的最小个数
     */
    int DEFAULT_MIN_AXIS_NUM_X = 2;
    /**
     * 默认的轴线交互处之外的距离
     */
    int DEFAULT_AXIS_SPACE_DP = 2;

    /**
     * 默认的轴线宽度
     */
    float DEFAULT_AXIS_LINE_WIDTH_PX = 1f;

    /**
     * 默认的限制线宽度
     */
    float DEFAULT_LIMIT_LINE_WIDTH_PX = 2f;

    /**
     * 四条轴线的方向，表示左侧的轴线
     */
    int LEFT = 0;
    /**
     * 四条轴线的方向，表示顶部的轴线
     */
    int TOP = 1;
    /**
     * 四条轴线的方向，表示右侧的轴线
     */
    int RIGHT = 2;
    /**
     * 四条轴线的方向，表示底部的轴线
     */
    int BOTTOM = 3;

    /**
     * 轴线上label的绘制时，一行最宽的字符串个数
     */
    int DEFAULT_LABELS_MAX_NUM = 8;

    /**
     * 总共64个char，用来测量文本属性时使用
     */
    char[] labelWidthChars = new char[]{
            '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
            '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
            '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
            '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};


}
