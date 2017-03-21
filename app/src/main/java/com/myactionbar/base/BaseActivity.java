package com.myactionbar.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.myactionbar.R;
import com.myactionbar.impl.ActionBarClickListener;
import com.myactionbar.widget.MyActionBar;

/**
 * Created by 晖仔(Milo) on 2017-03-21.
 * email:303767416@qq.com
 */

public abstract class BaseActivity extends AppCompatActivity {

    private MyActionBar actionBar;

    protected abstract int getContentViewId();

    protected abstract void init();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        init();
    }

    /**
     * 设置ActionBar
     *
     * @param strTitle
     * @param resIdLeft
     * @param strLeft
     * @param resIdRight
     * @param strRight
     * @param listener
     */
    protected void setMyActionBar(String strTitle, int resIdLeft, String strLeft, int resIdRight, String strRight, final ActionBarClickListener listener) {
        actionBar = (MyActionBar) findViewById(R.id.actionbar);
        actionBar.setData(strTitle, resIdLeft, strLeft, resIdRight, strRight, listener);
    }

    /**
     * 获取actionBar
     *
     * @return
     */
    protected MyActionBar getMyActionBar() {
        return actionBar;
    }

}
