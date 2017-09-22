package cn.connxun.train.ui.mine;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.Util;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.constants.Constants;
import cn.connxun.train.data.ACache;
import cn.connxun.train.di.component.FragmentComponent;
import cn.connxun.train.entity.PUser;
import cn.connxun.train.ui.base.BaseFragmentV4;
import cn.connxun.train.ui.classdetail.ClassDetailActivity;

/**
 * Created by wushange on 2017/7/19.
 */

public class MyStudyFragment extends BaseFragmentV4 implements SwipeRefreshLayout.OnRefreshListener {
    public static MyStudyFragment newInstance() {
        MyStudyFragment fragment = new MyStudyFragment();
        return fragment;
    }

    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView recyclerView;
    @Inject
    MyClassListAdapter adapter;

    PUser pUser;
    @Inject
    AppApi appApi;

    @Override
    public int bindLayout() {
        return R.layout.fragment_my_study;
    }

    @Override
    public void initParams(Bundle params) {
        pUser = (PUser) ACache.get(getContext()).getAsObject(Constants.USER_ID);
    }


    @Override
    public void initView(View view) {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, Util.dip2px(getContext(), 0.5f));
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setRefreshListener(this);
        adapter.setOnItemClickListener(position -> ClassDetailActivity.callMe(getContext(), adapter.getItem(position)));
    }

    @Override
    public void doBusiness(Context mContext) {
        getList();


    }

    private void getList() {
        compositeDisposable.add(appApi.getMyClassList(pUser.getId() + "", "1").subscribe(subClasses -> {
            adapter.clear();
            adapter.addAll(subClasses);
        }, throwable -> {
            recyclerView.setRefreshing(false);
            mOperation.showToast(throwable.getMessage());
        }));
    }

    @Override
    public void lazyInitBusiness(Context mContext) {
    }


    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }

    @Override
    public void onRefresh() {
        getList();
    }
}
