package cn.connxun.train.di.component;

import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import cn.connxun.train.MyApplication;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.db.VideoClassDao;
import cn.connxun.train.di.module.ApiModule;
import cn.connxun.train.di.module.ApplicationModule;
import cn.connxun.train.di.module.DBModule;
import cn.connxun.train.ui.base.BaseActivity;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, DBModule.class})
public interface ApplicationComponent {
    Context getContext();

    LayoutInflater getLayoutInflater();

    AppApi getAccountApi();

    VideoClassDao getVideoClassDao();

    void inject(MyApplication mApplication);

    void inject(BaseActivity mBaseActivity);
}
