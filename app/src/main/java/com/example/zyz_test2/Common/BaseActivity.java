package com.example.zyz_test2.Common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        setContentView(getContentViewId());
        initData();
        initView();
    }

    protected void initData(){

    }

    protected void initView(){

    }

    protected abstract int getContentViewId();

    public void toastShort(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public void toastLong(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
