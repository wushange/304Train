package cn.connxun.train.ui.classdetail;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jude.easyrecyclerview.EasyRecyclerView;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.di.component.FragmentComponent;
import cn.connxun.train.entity.VideoClass;
import cn.connxun.train.ui.base.BaseEvents;
import cn.connxun.train.ui.base.BaseFragmentV4;
import cn.connxun.train.ui.download.DownloadAllActivity;
import cn.connxun.train.utils.UserUtil;
import cn.connxun.train.utils.util.LogUtils;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by wushange on 2017/7/19.
 */

public class ClassListlFragment extends BaseFragmentV4 implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.btn_download_manager)
    Button btnDownloadManager;
    Unbinder unbinder;

    public static ClassListlFragment newInstance(VideoClass videoClass) {
        ClassListlFragment fragment = new ClassListlFragment();
        fragment.setVideoClass(videoClass);
        return fragment;
    }

    public void setVideoClass(VideoClass videoClass) {
        this.videoClass = videoClass;
    }

    VideoClass videoClass;
    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView recyclerView;
    @Inject
    ClassListAdapter adapter;

    @Inject
    AppApi appApi;

    @Override
    public int bindLayout() {
        return R.layout.fragment_class_lists;
    }

    @Override
    public void initParams(Bundle params) {

    }


    @Override
    public void initView(View view) {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setRefreshListener(this);
        adapter.setOnItemClickListener(position -> {
            appApi.insertLog(UserUtil.getUser().getId()+"",adapter.getItem(position).getId()+"",0)
            .subscribe(integer -> LogUtils.e("插入成功"), throwable -> LogUtils.e("插入失败"));
            BaseEvents.CommonEvent commonEvent = BaseEvents.CommonEvent.UPDATE_PCALSS;
            commonEvent.setObj(adapter.getItem(position));
            EventBus.getDefault().post(commonEvent);
        });
        btnDownloadManager.setOnClickListener(v -> {

            mOperation.forward(DownloadAllActivity.class);});
    }


    @Override
    public void doBusiness(Context mContext) {
        getSubList();
    }

    @Override
    public void lazyInitBusiness(Context mContext) {
    }

    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

    @Override
    public void onRefresh() {
        getSubList();
    }

    private void getSubList() {
        recyclerView.showProgress();
        compositeDisposable.add(appApi.getSublist("" + videoClass.getId()).subscribe(videoClasses -> {
            adapter.clear();
            adapter.addAll(videoClasses);
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                mOperation.showToast(throwable.getMessage());
            }
        }));
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
