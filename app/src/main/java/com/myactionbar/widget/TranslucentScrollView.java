package com.myactionbar.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;


/**
 * Created by 晖仔(Milo) on 2017/2/13.
 * email:303767416@qq.com
 */

public class TranslucentScrollView extends ScrollView {

    static final String TAG = "TranslucentScrollView";

    //渐变颜色
    private int transColor = Color.WHITE;
    //渐变开始位置
    private int transStartY = 50;
    //渐变结束位置
    private int transEndY = 300;

    //渐变开始默认位置，Y轴，50dp
    private final int DFT_TRANSSTARTY = 50;
    //渐变结束默认位置，Y轴，300dp
    private final int DFT_TRANSENDY = 300;

    private TranslucentScrollView.TranslucentChangedListener translucentChangedListener;

    public interface TranslucentChangedListener {
        /**
         * 透明度变化，取值范围0-255
         *
         * @param transAlpha
         */
        void onTranslucentChanged(int transAlpha);
    }

    public TranslucentScrollView(Context context) {
        super(context);
    }

    public TranslucentScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TranslucentScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTranslucentChangedListener(TranslucentScrollView.TranslucentChangedListener translucentChangedListener) {
        this.translucentChangedListener = translucentChangedListener;
    }

    /**
     * 设置渐变视图
     *
     * @param transColor  渐变颜色
     * @param transStartY 渐变结束位置
     * @param transEndY   渐变结束位置
     */
    public void setParams(@ColorInt int transColor, int transStartY, int transEndY) {
        Log.i(TAG, "transStartY == " + transStartY + ", transEndY == " + transEndY);
        this.transColor = transColor;
        this.transStartY = transStartY;
        this.transEndY = transEndY;
        if (transStartY > transEndY) {
            throw new IllegalArgumentException("transStartY 不得大于 transEndY .. ");
        }
    }

    /**
     * 获取透明度
     *
     * @return
     */
    private int getTransAlpha() {
        float scrollY = getScrollY();
        if (scrollY <= transStartY) {
            return 0;
        } else if (scrollY >= transEndY) {
            return 255;
        } else {
            return (int) ((scrollY - transStartY) / (transEndY - transStartY) * 255);
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        int transAlpha = getTransAlpha();

        if (translucentChangedListener != null) {
            Log.d(TAG, "transAlpha == " + transAlpha);
            translucentChangedListener.onTranslucentChanged(transAlpha);
        }
    }


}
