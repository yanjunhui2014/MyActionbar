package com.myactionbar.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.myactionbar.R;
import com.myactionbar.base.BaseActivity;
import com.myactionbar.impl.ActionBarClickListener;

/**
 * Created by 晖仔(Milo) on 2017-03-21.
 * email:303767416@qq.com
 */

public class SecondActivity extends BaseActivity implements ActionBarClickListener {

    TextView tvDes;

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, SecondActivity.class);
        return intent;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_senond;
    }

    @Override
    protected void init() {
        setMyActionBar(this.getClass().getSimpleName(), R.mipmap.ic_left_light, "取消", R.mipmap.ic_right_light, "确认", this);
        tvDes = (TextView) findViewById(R.id.tv_description);
        tvDes.setText("该方法优点:\n 1.使用简单;\n 2.高内聚;\n 3.易于扩展.");
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
