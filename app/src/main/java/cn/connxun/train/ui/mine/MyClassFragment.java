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

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.constants.Constants;
import cn.connxun.train.data.ACache;
import cn.connxun.train.di.component.FragmentComponent;
import cn.connxun.train.entity.Course;
import cn.connxun.train.entity.MyCourse;
import cn.connxun.train.entity.PUser;
import cn.connxun.train.ui.base.BaseFragmentV4;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by wushange on 2017/7/19.
 */

public class MyClassFragment extends BaseFragmentV4 implements SwipeRefreshLayout.OnRefreshListener {

    public static MyClassFragment newInstance() {
        MyClassFragment fragment = new MyClassFragment();
        return fragment;
    }

    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView    recyclerView;
    @Inject
    MyClassList1Adapter adapter;

    PUser pUser;
    @Inject
    AppApi appApi;

    @Override
    public int bindLayout() {
        return R.layout.fragment_my_class;
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
        adapter.setOnItemClickListener(position -> {
//
//            SBCLASS.MosCourseTypeBean sbclass = adapter.getItem(position).getMosCourseType();
//
//            VideoClass videoClass = new VideoClass();
//            videoClass.setId(sbclass.getId());
//            videoClass.setCourseid(sbclass.getId());
//            videoClass.setCoursename(sbclass.getTypename());
//            videoClass.setCoursepic(sbclass.getCoursepic());
//            ClassDetailActivity.callMe(getContext(), videoClass);
        });
    }

    @Override
    public void doBusiness(Context mContext) {
        getList();

    }

    private void getList() {

        appApi.getMyPushClassList(pUser.getId() + "", pUser.getUsertype() == null ? "" : pUser.getUsertype())
                .subscribe(new Observer<List<MyCourse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(@NonNull List<MyCourse> sbclasses) {
                        adapter.clear();
                        adapter.addAll(sbclasses);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        recyclerView.setRefreshing(false);
                    }

                    @Override
                    public void onComplete() {

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

    @Override
    public void onRefresh() {
        getList();
    }

}
