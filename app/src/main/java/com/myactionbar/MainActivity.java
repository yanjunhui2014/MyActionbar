package com.myactionbar;

import android.view.View;
import android.widget.Button;

import com.myactionbar.base.BaseActivity;
import com.myactionbar.ui.FirstActivity;
import com.myactionbar.ui.SecondActivity;
import com.myactionbar.ui.ThirdActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    Button btnFirst;
    Button btnSecond;
    Button btnThird;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        btnFirst = (Button) findViewById(R.id.btn_first);
        btnFirst.setOnClickListener(this);
        btnSecond = (Button) findViewById(R.id.btn_second);
        btnSecond.setOnClickListener(this);
        btnThird = (Button) findViewById(R.id.btn_third);
        btnThird.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_first:
                startActivity(FirstActivity.createIntent(this));
                break;
            case R.id.btn_second:
                startActivity(SecondActivity.createIntent(this));
                break;
            case R.id.btn_third:
                startActivity(ThirdActivity.createIntent(this));
                break;
        }
    }

}
