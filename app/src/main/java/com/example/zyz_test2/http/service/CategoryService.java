package com.example.zyz_test2.http.service;

import com.example.zyz_test2.http.entity.CategoryEntity;
import com.example.zyz_test2.http.entity.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface CategoryService {
    /**
     * 加载一级分类
     *
     * @return
     */
    @GET("cat")
    Observable<HttpResult<List<CategoryEntity>>> getTopList();

    /**
     * 加载二级分类
     *
     * @param parentId
     * @return
     */
    @GET("cat/parent/{parentId}")
    Observable<HttpResult<List<CategoryEntity>>> getSecondList(
            @Path("parentId") int parentId
    );
}