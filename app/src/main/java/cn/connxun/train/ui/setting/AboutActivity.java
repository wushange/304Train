package cn.connxun.train.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.entity.AppInfo;
import cn.connxun.train.ui.base.BaseActivity;
import cn.connxun.train.utils.util.BarUtils;

/**
 * Created by wushange on 2017/8/27.
 */

public class AboutActivity extends BaseActivity {
    @Inject
    AppApi appApi;

    @BindView(R.id.tv_app_context)
    WebView tvAppContext;
    private AppInfo mAppInfo;

    @Override
    public int bindLayout() {
        return R.layout.activity_about_us;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        BarUtils.setStatusBarTextColor(getContext(), true);
    }

    @Override
    public void doBusiness(Context mContext) {
        compositeDisposable.add(appApi.getAboutInfo("").subscribe(appInfo -> {
            mAppInfo = appInfo;
            tvAppContext.loadDataWithBaseURL(null, appInfo.getContent(), "text/html", "UTF-8", null);
        }, throwable -> Toast(throwable.getMessage())));

    }

    @Override
    public void initInjector() {

        getComponent().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
