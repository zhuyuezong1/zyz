package com.example.zyz_test2.Activity;

import android.widget.TextView;

import com.example.zyz_test2.Common.BaseActivity;
import com.example.zyz_test2.R;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangePwdActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView textView;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_change_pwd;
    }

    @Override
    protected void initView(){
        super.initView();
        textView.setText("修改密码");
        toastShort("功能尚在开发中");
    }

    @OnClick(R.id.iv_back)
    public void close(){
        finish();
    }
}
