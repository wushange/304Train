package cn.connxun.train.di.component;

import android.app.Activity;

import cn.connxun.train.di.PerActivity;
import cn.connxun.train.di.module.ActivityModule;
import cn.connxun.train.ui.home.ClassListActivity;
import cn.connxun.train.ui.home.HomeBroseHistoryActivity;
import cn.connxun.train.ui.home.HomeCFActivity;
import cn.connxun.train.ui.home.HomeHot_New_SpcActivity;
import cn.connxun.train.ui.home.HomeSearchActivity;
import cn.connxun.train.ui.login.LoginActivity;
import cn.connxun.train.ui.regist.RegistActivity;
import cn.connxun.train.ui.setting.AboutActivity;
import cn.connxun.train.ui.setting.HelpActivity;
import cn.connxun.train.ui.splash.SplashActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(RegistActivity activity);

    void inject(SplashActivity activity);

    void inject(LoginActivity baseActivity);

    void inject(AboutActivity aboutActivity);

    void inject(HelpActivity aboutActivity);

    void inject(HomeSearchActivity activity);

    void inject(ClassListActivity activity);

    void inject(HomeHot_New_SpcActivity activity);

    void inject(HomeCFActivity activity);

    void inject(HomeBroseHistoryActivity activity);
}
