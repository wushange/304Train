package cn.connxun.train.ui.web;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.train.R;
import cn.connxun.train.ui.base.BaseActivity;

/**
 * Created by wushange on 2017/8/27.
 */

public class WebviewActivity extends BaseActivity {
    @BindView(R.id.fl_web)
    FrameLayout flWeb;

    @Override
    public int bindLayout() {
        return R.layout.activity_web;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void initInjector() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
