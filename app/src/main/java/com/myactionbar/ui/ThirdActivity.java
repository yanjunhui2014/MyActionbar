package com.myactionbar.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.myactionbar.R;
import com.myactionbar.base.BaseActivity;
import com.myactionbar.impl.ActionBarClickListener;
import com.myactionbar.utils.SizeUtils;
import com.myactionbar.widget.TranslucentScrollView;

/**
 * Created by 晖仔(Milo) on 2017-03-21.
 * email:303767416@qq.com
 */

public class ThirdActivity extends BaseActivity implements ActionBarClickListener {

    TranslucentScrollView scrollView;

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, ThirdActivity.class);
        return intent;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_third;
    }

    @Override
    protected void init() {
        setMyActionBar(this.getClass().getSimpleName(), R.mipmap.ic_left_light, "取消", R.mipmap.ic_right_light, "确认", this);
        scrollView = (TranslucentScrollView) findViewById(R.id.scrollview);
        scrollView.setParams(getResources().getColor(R.color.primary), SizeUtils.dip2px(this, 0), SizeUtils.dip2px(this, 400));
        scrollView.setTranslucentChangedListener(new TranslucentScrollView.TranslucentChangedListener() {
            @Override
            public void onTranslucentChanged(int transAlpha) {
                getMyActionBar().setTranslucent(transAlpha);
            }
        });
        getMyActionBar().setTranslucent(0);
    }

    @Override
    public void onLeftClick() {
        finish();
    }

    @Override
    public void onRightClick() {
        Toast.makeText(this, "确定", Toast.LENGTH_SHORT).show();
    }
}
