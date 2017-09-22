package cn.connxun.train.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.zgh.stylelib.style.StyleHelper;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.constants.Constants;
import cn.connxun.train.ui.base.BaseFragmentV4;
import cn.connxun.train.ui.login.LoginActivity;
import cn.connxun.train.di.component.FragmentComponent;
import cn.connxun.train.utils.util.AppUtils;
import cn.connxun.train.utils.util.SPUtils;

/**
 * Created by wushange on 2017/7/19.
 */

public class SettingFragment extends BaseFragmentV4 {

    @BindView(R.id.rl_aboutus)
    RelativeLayout rlAboutus;
    @BindView(R.id.rl_help)
    RelativeLayout rlHelp;
    @BindView(R.id.ll_exit)
    LinearLayout llExit;

    @BindView(R.id.sw_night)
    Switch aSwitch;

    public static SettingFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
        rlAboutus.setOnClickListener(v -> mOperation.forward(AboutActivity.class));
        rlHelp.setOnClickListener(v -> mOperation.forward(HelpActivity.class));
        llExit.setOnClickListener(v -> mOperation.showBasicDialog("退出应用?", (dialog, which) -> mOperation.forwardAndFinish(LoginActivity.class)));
        aSwitch.setChecked(SPUtils.getInstance().getBoolean(Constants.NIGHT_THEME));

    }

    @Override
    public void doBusiness(Context mContext) {
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SPUtils.getInstance().put(Constants.NIGHT_THEME, true);
                    StyleHelper.changeStyle(0,1);
                    reload();
                } else {
                    StyleHelper.changeStyle(1,0);
                    SPUtils.getInstance().put(Constants.NIGHT_THEME, false);
                    reload();
                }

            }
        });

    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }

    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }


}
