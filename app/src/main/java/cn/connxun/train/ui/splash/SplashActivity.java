package cn.connxun.train.ui.splash;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

import cn.connxun.train.R;
import cn.connxun.train.ui.base.BaseActivity;
import cn.connxun.train.ui.login.LoginActivity;
import cn.connxun.train.utils.util.BarUtils;
import io.reactivex.Observable;

/**
 * Created by wushange on 2017/7/12.
 */

public class SplashActivity extends BaseActivity {
    @Override
    public int bindLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initParms(Bundle parms) {
    }

    @Override
    public void initView(View view) {
        BarUtils.setTransparentPadding(this);
        BarUtils.setStatusBarTextColor(this, true);
    }

    @Override
    public void doBusiness(Context mContext) {

        Observable.timer(2, TimeUnit.SECONDS).subscribe(aLong -> {
            mOperation.forwardAndFinish(LoginActivity.class, LEFT_RIGHT);
        });
    }

    @Override
    public void initInjector() {
    }



}
