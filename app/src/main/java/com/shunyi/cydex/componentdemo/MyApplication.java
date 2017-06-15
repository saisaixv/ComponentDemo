package com.shunyi.cydex.componentdemo;

import com.github.mzule.activityrouter.annotation.Modules;
import com.shunyi.cydex.common.base.BaseApplication;

/**
 * Created by saisai on 2017/6/14.
 */
@Modules({"main", "girls", "news"})
public class MyApplication extends BaseApplication {

    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        this.app=this;
    }
}
