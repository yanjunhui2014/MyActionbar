package com.myactionbar.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.myactionbar.R;
import com.myactionbar.base.FirstBaseActivity;
import com.myactionbar.impl.ActionBarClickListener;

/**
 * Created by 晖仔(Milo) on 2017-03-21.
 * email:303767416@qq.com
 */

public class FirstActivity extends FirstBaseActivity implements ActionBarClickListener {

    TextView tvDes;

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, FirstActivity.class);
        return intent;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_first;
    }

    @Override
    protected void init() {
        setMyActionBar(this.getClass().getSimpleName(), R.mipmap.ic_left_light, "取消", R.mipmap.ic_right_light, "确认", this);
        tvDes = (TextView) findViewById(R.id.tv_description);
        tvDes.setText("该方法优点:\n 1.使用简单;\n 2.不用担心性能问题.\n缺点:\n 1.没有做到高内聚的设计原则;\n 2.扩展性差.");
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
