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
import com.lzy.okgo.db.DownloadManager;
import com.lzy.okserver.OkDownload;
import com.lzy.okserver.download.DownloadTask;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.di.component.FragmentComponent;
import cn.connxun.train.entity.SubClass;
import cn.connxun.train.ui.base.BaseEvents;
import cn.connxun.train.ui.base.BaseFragmentV4;
import cn.connxun.train.utils.UserUtil;
import cn.connxun.train.utils.util.FileUtils;
import cn.connxun.train.utils.util.LogUtils;

/**
 * Created by wushange on 2017/7/19.
 */

public class MyDownloadFragment extends BaseFragmentV4 implements SwipeRefreshLayout.OnRefreshListener {
    public static MyDownloadFragment newInstance() {
        MyDownloadFragment fragment = new MyDownloadFragment();
        return fragment;
    }

    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView  recyclerView;
    @Inject
    MyDownLoadAdapter adapter;
    List<DownloadTask> values;

    @Inject
    AppApi appApi;
    @Override
    public int bindLayout() {
        return R.layout.fragment_my_download;
    }

    @Override
    public void initParams(Bundle params) {
//
    }

    @Override
    public void initView(View view) {
        recyclerView.setAdapter(adapter);
        recyclerView.setRefreshListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, Util.dip2px(getContext(), 0.5f));
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void doBusiness(Context mContext) {
        EventBus.getDefault().register(this);
        values = OkDownload.restore(DownloadManager.getInstance().getFinished());
        adapter.addAll(values);
        adapter.setOnItemClickListener(position ->{
            SubClass subClass = (SubClass) adapter.getItem(position).progress.extra1;
            appApi.insertLog(UserUtil.getUser().getId()+"",subClass.getId()+"",0)
                    .subscribe(integer -> LogUtils.e("插入成功"), throwable -> LogUtils.e("插入失败"));
                FileUtils.startActionFile(adapter.getItem(position).progress.filePath);});
    }

    @Override
    public void lazyInitBusiness(Context mContext) {
    }


    @Subscribe
    public void update(BaseEvents.CommonEvent commonEvent) {
        if (commonEvent == BaseEvents.CommonEvent.UPDATE_LIST) {
            adapter.clear();
            values = OkDownload.restore(DownloadManager.getInstance().getFinished());
            adapter.addAll(values);
        }

    }


    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }

    @Override
    public void onRefresh() {
        adapter.clear();
        values = OkDownload.restore(DownloadManager.getInstance().getFinished());
        adapter.addAll(values);
    }
}
