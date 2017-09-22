package cn.connxun.train.ui.regist;


import cn.connxun.train.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface RegistContract {
    interface RegistView extends BasePView {
        String getUserName();

        String getUserCode();

        String getUserPassWord();
        String getUserRePassWord();
        void registSuccess( );
    }

    interface RegistPresenter {
        void regist();

    }
}
