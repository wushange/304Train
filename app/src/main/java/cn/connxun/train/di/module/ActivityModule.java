package cn.connxun.train.di.module;

import android.app.Activity;

import cn.connxun.train.di.PerActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

  private final Activity mActivity;

  public ActivityModule(Activity mActivity) {
    this.mActivity = mActivity;
  }

  @Provides
  @PerActivity
  public Activity provideActivity() {
    return mActivity;
  }
}
