package com.example.zyz_test2.Common;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;

import com.example.zyz_test2.R;
import com.example.zyz_test2.http.HttpMethods;
import com.example.zyz_test2.http.entity.MemberEntity;
import com.example.zyz_test2.http.presenter.MemberPresenter;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;


import java.util.logging.LogRecord;

import rx.Subscriber;

public class MobileShopApp extends Application {

    public static Handler handler=new Handler();
    private static Context sContext;

    public void onCreate(){
        super.onCreate();

        sContext=getApplicationContext();
        initImageLoader();
        HttpMethods.getInstance();
    }
        private void initImageLoader(){
            DisplayImageOptions default_options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.mipmap.image_loading)
                    .showImageForEmptyUri(R.mipmap.image_empty)
                    .showImageOnFail(R.mipmap.image_error)
                    .resetViewBeforeLoading(false)
                    .delayBeforeLoading(1000)
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .considerExifParams(false)
                    .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                    .bitmapConfig(Bitmap.Config.ARGB_8888)
                    .displayer(new SimpleBitmapDisplayer())
                    .handler(new Handler())
                    .build();

           ImageLoaderConfiguration config=new ImageLoaderConfiguration.Builder(getApplicationContext())
                    .memoryCacheExtraOptions(480,800)
                    .memoryCacheSize(2*1024*1024)
                    .memoryCacheSizePercentage(13)
                    .diskCacheSize(50*1024*1024)
                    .diskCacheFileCount(100)
                    .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                    .threadPoolSize(3)
                    .threadPriority(Thread.NORM_PRIORITY-2)
                    .denyCacheImageMultipleSizesInMemory()
                    .imageDownloader(new BaseImageDownloader(getApplicationContext()))
                    .defaultDisplayImageOptions(default_options)
                    .writeDebugLogs()
                    .build();

            ImageLoader.getInstance().init(config);
        }


        public static Context getContext() {
        return sContext;
    }
}
