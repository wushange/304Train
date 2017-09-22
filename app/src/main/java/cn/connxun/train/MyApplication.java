package cn.connxun.train;

import android.content.Context;
import android.os.StrictMode;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;

import com.facebook.stetho.Stetho;
import com.lzy.okgo.OkGo;
import com.tencent.bugly.Bugly;
import com.tencent.smtt.sdk.QbSdk;
import com.zgh.stylelib.style.StyleHelper;

import cn.connxun.train.constants.Constants;
import cn.connxun.train.di.component.ApplicationComponent;
import cn.connxun.train.di.component.DaggerApplicationComponent;
import cn.connxun.train.di.module.ApplicationModule;
import cn.connxun.train.ui.base.BaseApplication;
import cn.connxun.train.utils.util.FileUtils;
import cn.connxun.train.utils.util.SPUtils;
import cn.connxun.train.utils.util.Utils;

import static cn.connxun.train.constants.Constants.BUGLY_APPID;

/**
 * Created by wushange on 2017/7/11.
 */

public class MyApplication extends BaseApplication {

    private ApplicationComponent mApplicationComponent;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        StyleHelper.init(this, "wangyi", "baidu", "day");
        initComponent();//依赖注入
        Utils.init(this);//工具类
        Bugly.init(getApplicationContext(), BUGLY_APPID, true);//bugly
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {

            }
        });
        Stetho.initializeWithDefaults(this);//调试工具

        OkGo.getInstance().init(this);
        FileUtils.createOrExistsDir(Constants.DOWNLOAD_PATH);

        if (SPUtils.getInstance().getBoolean(Constants.NIGHT_THEME)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


    }

    @Override
    public void exit() {
        removeAllActivity();
    }

    private void initComponent() {
        mApplicationComponent =
                DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }


    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
