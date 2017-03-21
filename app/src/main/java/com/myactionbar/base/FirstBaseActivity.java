package com.myactionbar.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.myactionbar.R;
import com.myactionbar.impl.ActionBarClickListener;

/**
 * Created by 晖仔(Milo) on 2017-03-21.
 * email:303767416@qq.com
 */

public abstract class FirstBaseActivity extends AppCompatActivity {

    protected View layRoot;
    protected View vStatusBar;
    protected View layLeft;
    protected View layRight;
    protected TextView tvTitle;
    protected TextView tvLeft;
    protected TextView tvRight;
    protected View iconLeft;
    protected View iconRight;

    protected abstract int getContentViewId();

    protected abstract void init();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        init();
    }

    /**
     * 设置数据
     *
     * @param strTitle
     * @param resIdLeft
     * @param strLeft
     * @param resIdRight
     * @param strRight
     * @param listener
     */
    public void setMyActionBar(String strTitle, int resIdLeft, String strLeft, int resIdRight, String strRight, final ActionBarClickListener listener) {
        View actionBar = findViewById(R.id.actionbar);
        layRoot = actionBar.findViewById(R.id.lay_transroot);
        vStatusBar = actionBar.findViewById(R.id.v_statusbar);
        tvTitle = (TextView) actionBar.findViewById(R.id.tv_actionbar_title);
        tvLeft = (TextView) actionBar.findViewById(R.id.tv_actionbar_left);
        tvRight = (TextView) actionBar.findViewById(R.id.tv_actionbar_right);
        iconLeft = actionBar.findViewById(R.id.iv_actionbar_left);
        iconRight = actionBar.findViewById(R.id.v_actionbar_right);

        if (!TextUtils.isEmpty(strTitle)) {
            tvTitle.setText(strTitle);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(strLeft)) {
            tvLeft.setText(strLeft);
            tvLeft.setVisibility(View.VISIBLE);
        } else {
            tvLeft.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(strRight)) {
            tvRight.setText(strRight);
            tvRight.setVisibility(View.VISIBLE);
        } else {
            tvRight.setVisibility(View.GONE);
        }

        if (resIdLeft == 0) {
            iconLeft.setVisibility(View.GONE);
        } else {
            iconLeft.setBackgroundResource(resIdLeft);
            iconLeft.setVisibility(View.VISIBLE);
        }

        if (resIdRight == 0) {
            iconRight.setVisibility(View.GONE);
        } else {
            iconRight.setBackgroundResource(resIdRight);
            iconRight.setVisibility(View.VISIBLE);
        }

        if (listener != null) {
            layLeft = findViewById(R.id.lay_actionbar_left);
            layRight = findViewById(R.id.lay_actionbar_right);
            layLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onLeftClick();
                }
            });
            layRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onRightClick();
                }
            });
        }
    }

}
