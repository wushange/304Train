package cn.connxun.train.ui.mine;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.constants.Constants;
import cn.connxun.train.data.ACache;
import cn.connxun.train.di.component.FragmentComponent;
import cn.connxun.train.entity.PUser;
import cn.connxun.train.ui.base.BaseFragmentV4;
import cn.connxun.train.ui.base.ViewPagerAdapter;

/**
 * Created by wushange on 2017/7/19.
 */

public class MineFragment extends BaseFragmentV4 {
    @BindView(R.id.tab_mine_layout)
    TabLayout tablayout;
    @BindView(R.id.vp_mine)
    ViewPager viewpager;
    @BindView(R.id.tv_username)
    TextView  tvUsername;
    private ViewPagerAdapter adapter;

    PUser pUser;
    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        ViewCompat.setElevation(tablayout, 10);
        adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(MyClassFragment.newInstance(), "我的课程");
        adapter.addFragment(MyStudyFragment.newInstance(), "我的自学");
        adapter.addFragment(MyDownloadFragment.newInstance(), "已下载");
        viewpager.setOffscreenPageLimit(3);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    public void doBusiness(Context mContext) {
        pUser = (PUser) ACache.get(getContext()).getAsObject(Constants.USER_ID);

        if(pUser!=null){
            tvUsername.setText(pUser.getUsername());
        }
    }

    @Override
    public void lazyInitBusiness(Context mContext) {
    }


    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }
}
