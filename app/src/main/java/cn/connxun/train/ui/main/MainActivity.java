package cn.connxun.train.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.view.View;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.di.HasComponent;
import cn.connxun.train.di.component.DaggerFragmentComponent;
import cn.connxun.train.di.component.FragmentComponent;
import cn.connxun.train.ui.base.BaseActivity;
import cn.connxun.train.ui.base.ViewPagerAdapter;
import cn.connxun.train.ui.home.HomeFragment;
import cn.connxun.train.ui.mine.MineFragment;
import cn.connxun.train.ui.setting.SettingFragment;
import cn.connxun.train.utils.util.BarUtils;
import cn.connxun.train.widget.MyViewPager;


/**
 * 首页
 */
public class MainActivity extends BaseActivity implements HasComponent<FragmentComponent> {

    @BindView(R.id.tablayout)
    TabLayout   tablayout;
    @BindView(R.id.viewpager)
    MyViewPager viewpager;
    private ViewPagerAdapter  adapter;
    private FragmentComponent mMainComponent;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initParms(Bundle parms) {
    }

    @Override
    public void initView(View view) {
        setTouchDissIm(true);
        BarUtils.setTransparentPadding(this);
        BarUtils.setStatusBarTextColor(getContext(),true);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.setSelectedTabIndicatorHeight(0);
        ViewCompat.setElevation(tablayout, 10);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(HomeFragment.newInstance(), "首页");
        adapter.addFragment(MineFragment.newInstance(), "我的");
        adapter.addFragment(SettingFragment.newInstance(), "设置");
        viewpager.setOffscreenPageLimit(3);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setIcon(R.drawable.tab_home);
        tablayout.getTabAt(1).setIcon(R.drawable.tab_mine);
        tablayout.getTabAt(2).setIcon(R.drawable.tab_setting);

    }

    @Override
    public void doBusiness(Context mContext) {
    }

    @Override
    public void initInjector() {
        mMainComponent = DaggerFragmentComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build();
        mMainComponent.inject(this);
    }

    @Override
    public FragmentComponent getFragmentComponent() {
        return mMainComponent;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
