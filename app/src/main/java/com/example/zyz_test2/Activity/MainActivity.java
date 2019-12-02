package com.example.zyz_test2.Activity;

import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.zyz_test2.Common.BaseActivity;
import com.example.zyz_test2.Fragment.NavigationFragment;
import com.example.zyz_test2.R;

public class MainActivity extends BaseActivity {

    @Override
   public @LayoutRes
    int getContentViewId(){
        return R.layout.activity_main;
    }

    @Override
    protected void initView(){
        super.initView();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fl_main,new NavigationFragment());
        transaction.commit();
    }
}
