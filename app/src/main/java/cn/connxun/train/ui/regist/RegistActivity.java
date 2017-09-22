package cn.connxun.train.ui.regist;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.ui.base.BaseSwipeBackActivity;
import cn.connxun.train.ui.login.LoginActivity;
import cn.connxun.train.utils.util.BarUtils;

/**
 * Created by wushange on 2017/7/12.
 */

public class RegistActivity extends BaseSwipeBackActivity implements RegistContract.RegistView {
    @Inject
    RegistPresenter presenter;
    @BindView(R.id.input_name)
    EditText        inputName;
    @BindView(R.id.input_code)
    EditText        inputCode;
    @BindView(R.id.input_pwd)
    EditText        inputPwd;
    @BindView(R.id.input_repwd)
    EditText        inputRepwd;
    @BindView(R.id.btn_regist)
    Button          btnRegist;

    @Override
    public int bindLayout() {
        return R.layout.activity_regist;
    }

    @Override
    public void initParms(Bundle parms) {
    }

    @Override
    public void initView(View view) {
        BarUtils.setTransparentPadding(this);
        BarUtils.setStatusBarTextColor(this, true);
        setTouchDissIm(true);
    }

    @Override
    public void doBusiness(Context mContext) {
        presenter.attachView(this);
        btnRegist.setOnClickListener(v ->
                presenter.regist()

        );
    }

    @Override
    public void initInjector() {
        getComponent().inject(this);
    }

    @Override
    public void startLoading() {
        mOperation.showProgress("正在登录...", false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void endLoading() {
        dissmissDialog();
    }

    @Override
    public void onError(String error) {
        Toast(error);
    }

    @Override
    public String getUserName() {
        return inputName.getText().toString();
    }

    @Override
    public String getUserCode() {return inputCode.getText().toString();}

    @Override
    public String getUserPassWord() {
        return inputPwd.getText().toString();
    }

    @Override
    public String getUserRePassWord() {
        return inputRepwd.getText().toString();
    }

    @Override
    public void registSuccess() {
        mOperation.showToast("注册成功，请联系管理员进行审核。");
        mOperation.forwardAndFinish(LoginActivity.class);
    }


}
