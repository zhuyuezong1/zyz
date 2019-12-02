package com.example.zyz_test2.Activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.zyz_test2.Common.BaseActivity;
import com.example.zyz_test2.R;
import com.example.zyz_test2.adapter.GoodsListAdapter;
import com.example.zyz_test2.http.entity.GoodsEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class GoodsListActivity extends BaseActivity {

    private int cat_id;

    @BindView(R.id.goodslist_swipe_refresh)
    SwipeRefreshLayout goodlistSwipRefresh;
    @BindView(R.id.goodslist_recyclerview)
    RecyclerView goodslistRecyclerview;
    @BindView(R.id.goodslist_nodata)
    TextView goodsListNoData;

    private List<GoodsEntity>listData;
    private GoodsListAdapter adapter;

    @Override
    public int getContentViewId(){
        return R.layout.activity_goodslist;
    }

    @OnClick(R.id.iv_back)
    void close(){
        finish();
    }
}
