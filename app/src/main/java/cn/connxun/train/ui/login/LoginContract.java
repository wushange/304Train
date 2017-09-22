package cn.connxun.train.ui.login;


import cn.connxun.train.entity.PUser;
import cn.connxun.train.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface LoginContract {
    interface LoginView extends BasePView {
        String getUserName();

        String getUserPassWord();

        void loginSuccess(PUser token);
    }

    interface LoginPresenter {
        void login();

    }
}
