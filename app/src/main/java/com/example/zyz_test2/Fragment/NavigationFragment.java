package com.example.zyz_test2.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;

import com.example.zyz_test2.Common.BaseFragment;
import com.example.zyz_test2.R;

public class NavigationFragment extends BaseFragment implements View.OnClickListener {
    private ImageButton mIbHome;
    private ImageButton mIbShopping;
    private ImageButton mIbPersonal;
    private ImageButton mIbSort;
    private HomeFragment homeFragment;
    private SortFragment sortFragment;
    private ShoppingFragment shoppingFragment;
    private PersonalFragment personalFragment;

    @Override
    public int getContentViewId(){
        return R.layout.show_main_lay;
    }

    @Override

    protected void initView(View view){
        super.initView(view);
        mIbHome=view.findViewById(R.id.img_shouye);
        mIbSort=view.findViewById(R.id.img_sort);
        mIbShopping=view.findViewById(R.id.img_shopping);
        mIbPersonal=view.findViewById(R.id.img_my);
        mIbHome.setOnClickListener(this);
        mIbSort.setOnClickListener(this);
        mIbShopping.setOnClickListener(this);
        mIbPersonal.setOnClickListener(this);
        select(mIbHome);
    }

    private void select(View v) {
        mIbHome.setImageResource(R.mipmap.tab_item_home_normal);
        mIbSort.setImageResource(R.mipmap.tab_item_category_normal);
        mIbShopping.setImageResource(R.mipmap.tab_item_cart_normal);
        mIbPersonal.setImageResource(R.mipmap.tab_item_personal_normal);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if (homeFragment!=null){
            fragmentTransaction.hide(homeFragment);
        }
        if (sortFragment!=null){
            fragmentTransaction.hide(sortFragment);
        }
        if (shoppingFragment!=null){
            fragmentTransaction.hide(shoppingFragment);
        }
        if (personalFragment!=null){
            fragmentTransaction.hide(personalFragment);
        }
        switch (v.getId()){
            case R.id.img_shouye:
                mIbHome.setImageResource(R.mipmap.tab_item_home_focus);
                if (homeFragment==null){
                    homeFragment=new HomeFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,homeFragment);
                }else{
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.img_sort:
                mIbSort.setImageResource(R.mipmap.tab_item_category_focus);
                if (sortFragment==null){
                    sortFragment=new SortFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,sortFragment);
                }else{
                    fragmentTransaction.show(sortFragment);
                }
                break;
            case R.id.img_shopping:
                mIbShopping.setImageResource(R.mipmap.tab_item_cart_focus);
                if (shoppingFragment==null){
                    shoppingFragment=new ShoppingFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,shoppingFragment);
                }else{
                    fragmentTransaction.show(shoppingFragment);
                }
                break;
            case R.id.img_my:
                mIbPersonal.setImageResource(R.mipmap.tab_item_personal_focus);
                if (personalFragment==null){
                    personalFragment=new PersonalFragment();
                    fragmentTransaction.add(R.id.fl_main_navigation,personalFragment);
                }else{
                    fragmentTransaction.show(personalFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        select(v);
    }
}
