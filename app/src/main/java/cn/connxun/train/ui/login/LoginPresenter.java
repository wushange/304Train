package cn.connxun.train.ui.login;

import android.content.Context;

import javax.inject.Inject;

import cn.connxun.train.api.AppApi;
import cn.connxun.train.constants.Constants;
import cn.connxun.train.data.ACache;
import cn.connxun.train.di.PerActivity;
import cn.connxun.train.entity.PUser;
import cn.connxun.train.ui.base.BasePresenter;
import cn.connxun.train.utils.util.EncryptUtils;
import cn.connxun.train.utils.util.LogUtils;
import cn.connxun.train.utils.util.StringUtils;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class LoginPresenter extends BasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {

    Context context;
    private AppApi accountApi;

    @Inject
    public LoginPresenter(Context context, AppApi accountApi) {
        this.context = context;
        this.accountApi = accountApi;
    }


    @Override
    public void login() {
        String userName = mView.getUserName();
        String userPwd = mView.getUserPassWord();

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPwd)) {
            mView.endLoading();
            mView.onError("用户名密码不能为空请检查！");
            return;
        }

        String md5 = EncryptUtils.encryptMD5ToString(userPwd).toLowerCase();
        mView.startLoading();
        accountApi.login(userName, md5).subscribe(new Observer<PUser>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable.add(d);
            }

            @Override
            public void onNext(@NonNull PUser pUser) {
                LogUtils.e("---" + pUser);
                ACache.get(context).put(Constants.USER_ID, pUser);
                mView.loginSuccess(pUser);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                  mView.onError(e.getMessage());
                mView.endLoading();
            }

            @Override
            public void onComplete() {
                mView.endLoading();
            }
        });

    }
}
