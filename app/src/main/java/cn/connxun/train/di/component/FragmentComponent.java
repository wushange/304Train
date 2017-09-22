package cn.connxun.train.di.component;


import cn.connxun.train.di.PerActivity;
import cn.connxun.train.di.module.ActivityModule;
import cn.connxun.train.ui.classdetail.ClassDetailActivity;
import cn.connxun.train.ui.classdetail.ClassDetailFragment;
import cn.connxun.train.ui.classdetail.ClassListlFragment;
import cn.connxun.train.ui.home.HomeFragment;
import cn.connxun.train.ui.main.MainActivity;
import cn.connxun.train.ui.mine.MineFragment;
import cn.connxun.train.ui.mine.MyClassFragment;
import cn.connxun.train.ui.mine.MyDownloadFragment;
import cn.connxun.train.ui.mine.MyStudyFragment;
import cn.connxun.train.ui.setting.SettingFragment;
import dagger.Component;

/**
 * Created by sll on 2016/5/13.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface FragmentComponent {
    void inject(MainActivity activity);

    void inject(ClassDetailActivity aboutActivity);

    void inject(HomeFragment fragment);

    void inject(MineFragment fragment);

    void inject(MyStudyFragment fragment);

    void inject(MyDownloadFragment fragment);

    void inject(MyClassFragment fragment);

    void inject(ClassDetailFragment fragment);

    void inject(SettingFragment fragment);

    void inject(ClassListlFragment fragment);

}
