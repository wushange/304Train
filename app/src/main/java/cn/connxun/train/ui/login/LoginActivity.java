package cn.connxun.train.ui.login;

import android.Manifest;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import cn.connxun.train.R;
import cn.connxun.train.entity.PUser;
import cn.connxun.train.ui.base.BaseSwipeBackActivity;
import cn.connxun.train.ui.main.MainActivity;
import cn.connxun.train.ui.regist.RegistActivity;
import cn.connxun.train.utils.util.AnimatorUtil;
import cn.connxun.train.utils.util.BarUtils;

/**
 * Created by wushange on 2017/7/12.
 */

public class LoginActivity extends BaseSwipeBackActivity implements LoginContract.LoginView {
    @Inject
    LoginPresenter loginPresenter;
    @BindView(R.id.head_logo)
    ImageView      headLogo;
    @BindView(R.id.login_btn)
    Button         loginBtn;
    @BindView(R.id.input_name)
    EditText       inputName;
    @BindView(R.id.input_pwd)
    EditText       inputPwd;
    @BindView(R.id.tv_goregist)
    TextView       tvGoregist;

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initParms(Bundle parms) {
    }

    @Override
    public void initView(View view) {
        BarUtils.setTransparentPadding(this);
        BarUtils.setStatusBarTextColor(this, true);
        setTouchDissIm(true);
        AnimatorUtil.addGlobaLayoutListener(view, headLogo);


        Drawable drawable = getResources().getDrawable(R.mipmap.ic_uname);
        Drawable drawable2 = getResources().getDrawable(R.mipmap.ic_upassword);
        drawable.setBounds(0, 0, 40, 40);
        drawable2.setBounds(0, 0, 40, 40);
        inputName.setCompoundDrawables(drawable, null, null, null);
        inputPwd.setCompoundDrawables(drawable2, null, null, null);
    }

    @Override
    public void doBusiness(Context mContext) {
        new RxPermissions(getContext()).request(Manifest.permission.WRITE_EXTERNAL_STORAGE
                , Manifest.permission.READ_PHONE_STATE
                )
                .subscribe(granded -> {
                    if (granded) {
                    } else {
                        Toast("请先授予应用相关权限");
                    }
                });
        loginPresenter.attachView(this);
        loginBtn.setOnClickListener(v ->
                loginPresenter.login()
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
    public String getUserPassWord() {
        return inputPwd.getText().toString();
    }

    @Override
    public void loginSuccess(PUser token) {
        mOperation.forwardAndFinish(MainActivity.class, LEFT_RIGHT);
    }

    @OnClick(R.id.tv_goregist)
    public void onViewClicked() {
        mOperation.forward(RegistActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView();
    }
}
