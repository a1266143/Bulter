package com.xiaojun.bulter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * BaseActivity
 * Create at 2017/5/24
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        ButterKnife.bind(this);
    }

    /* 获取布局文件 */
    protected abstract int getLayoutRes();
}
