package cn.connxun.train.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.di.component.FragmentComponent;
import cn.connxun.train.entity.Banner;
import cn.connxun.train.entity.Course;
import cn.connxun.train.ui.base.BaseFragmentV4;
import cn.connxun.train.ui.download.DownloadAllActivity;
import cn.connxun.train.ui.home.adapter.HomeBannerAdapter;
import cn.connxun.train.ui.home.adapter.HomeHistoryAdapter;
import cn.connxun.train.ui.home.adapter.HomeListAdapter;
import cn.connxun.train.ui.home.adapter.JingXuanAdapter;

import static cn.connxun.train.utils.Utils.convertDpToPixel;


/**
 * Created by wushange on 2017/7/19.
 */

public class HomeFragment extends BaseFragmentV4 implements HomeContract.HomeView, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView recyclerView;
    @Inject
    HomePresenter    presenter;
    @Inject
    HomeListAdapter  adapter;
    @BindView(R.id.iv_search)
    EditText         seView;
    @BindView(R.id.iv_download)
    ImageView        downloadView;

    HomeBannerAdapter bannerAdapter;
    @Inject
    JingXuanAdapter    jingXuanAdapter;
    @Inject
    HomeHistoryAdapter historyAdapter;
    @Inject
    AppApi             appApi;
    Unbinder unbinder;
    @BindView(R.id.iv_history)
    ImageView ivHistory;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new SpaceDecoration(10));
        recyclerView.setRefreshListener(this);
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                RollPagerView header = new RollPagerView(getContext());
                header.setHintView(new ColorPointHintView(getContext(), Color.YELLOW, Color.GRAY));
                header.setHintPadding(0, 0, 0, (int) convertDpToPixel(8, getContext()));
                header.setPlayDelay(2000);
                header.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) convertDpToPixel(200, getContext())));
                header.setAdapter(bannerAdapter = new HomeBannerAdapter(getContext()));
                return header;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                View headView = getContext().getLayoutInflater().inflate(R.layout.header_top_view, null);
                return headView;
            }

            @Override
            public void onBindView(View headerView) {
                headerView.findViewById(R.id.tv_head_fenlei).setOnClickListener(v -> mOperation.forward(HomeCFActivity.class));
                headerView.findViewById(R.id.tv_head_zhuanti).setOnClickListener(v ->HomeHot_New_SpcActivity.callMe(getContext(),0));
                headerView.findViewById(R.id.tv_head_hot).setOnClickListener(v -> HomeHot_New_SpcActivity.callMe(getContext(),1));
                headerView.findViewById(R.id.tv_head_new).setOnClickListener(v ->HomeHot_New_SpcActivity.callMe(getContext(),2));
            }
        });
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                View             view1            = getContext().getLayoutInflater().inflate(R.layout.header_jingxuan, null);
                EasyRecyclerView easyRecyclerView = (EasyRecyclerView) view1.findViewById(R.id.type_listview);
                easyRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                easyRecyclerView.addItemDecoration(new SpaceDecoration(10));
                easyRecyclerView.setAdapter(jingXuanAdapter);
//                jingXuanAdapter.setOnItemClickListener(position -> ClassListActivity.callMe(getContext(), typeAdapter.getItem(position)));
                return view1;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                return getContext().getLayoutInflater().inflate(R.layout.header_history_view, null);
            }


            @Override
            public void onBindView(View headerView) {
                EasyRecyclerView easyRecyclerView = (EasyRecyclerView) headerView.findViewById(R.id.history_listview);
                easyRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                easyRecyclerView.addItemDecoration(new SpaceDecoration(10));
                easyRecyclerView.setAdapter(historyAdapter);
//                historyAdapter.setOnItemClickListener(position -> ClassListActivity.callMe(getContext(), jingXuanAdapter.getItem(position)));
            }
        });
        seView.setOnClickListener(v -> mOperation.forward(HomeSearchActivity.class));
        downloadView.setOnClickListener(v -> mOperation.forward(DownloadAllActivity.class));
        ivHistory.setOnClickListener(v -> mOperation.forward(HomeBroseHistoryActivity.class));
    }

    @Override
    public void doBusiness(Context mContext) {
        presenter.getHomeList();
    }

    @Override
    public void lazyInitBusiness(Context mContext) {
    }

    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }

    @Override
    public void startLoading() {
    }

    @Override
    public void endLoading() {
    }

    @Override
    public void onError(String error) {
        mOperation.showBasicDialog(error);
    }


    @Override
    public void showBannerList(List<Banner> banners) {
        bannerAdapter.setList(banners);
        recyclerView.setRefreshing(false);
    }

    @Override
    public void showHistoryList(List<Course> courses) {
        historyAdapter.clear();
        historyAdapter.addAll(courses);
        recyclerView.setRefreshing(false);
    }

    @Override
    public void showJingXuanList(List<Course> courses) {
        jingXuanAdapter.clear();
        jingXuanAdapter.addAll(courses);
        recyclerView.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        presenter.getHomeList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
