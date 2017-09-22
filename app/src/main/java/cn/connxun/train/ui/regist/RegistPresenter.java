package cn.connxun.train.ui.regist;


import javax.inject.Inject;

import cn.connxun.train.api.AppApi;
import cn.connxun.train.di.PerActivity;
import cn.connxun.train.ui.base.BasePresenter;
import cn.connxun.train.utils.util.EncryptUtils;
import cn.connxun.train.utils.util.StringUtils;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class RegistPresenter extends BasePresenter<RegistContract.RegistView> implements RegistContract.RegistPresenter {

    private AppApi accountApi;

    @Inject
    public RegistPresenter(AppApi accountApi) {
        this.accountApi = accountApi;
    }

    @Override
    public void regist() {
        String userName = mView.getUserName();
        String userPwd = mView.getUserPassWord();
        String userRePwd = mView.getUserRePassWord();
        String userCard = mView.getUserCode();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPwd)) {
            mView.endLoading();
            mView.onError("用户名密码不能为空请检查！");
            return;
        }
        if (!userPwd.equals(userRePwd)) {
            mView.endLoading();
            mView.onError("两次输入密码不一致请检查！");
            return;
        }
        String md5 = EncryptUtils.encryptMD5ToString(userPwd).toLowerCase();
        mDisposable.add(accountApi.regist(userName, md5, userCard).subscribe(s -> mView.registSuccess(),
                throwable -> mView.onError(throwable.getMessage())));
    }
}
