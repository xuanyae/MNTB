package com.ydlab.mntb_client;

import android.app.Application;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.ai.BmobAI;

public class BmobApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        Bmob.initialize(this,"e0c50ea935b3b2db9ff1b34ba7dc4670");
    }
}
