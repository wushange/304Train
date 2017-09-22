package cn.connxun.train.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.entity.CourseType;
import cn.connxun.train.ui.base.BaseActivity;
import cn.connxun.train.ui.home.adapter.HomeListAdapter;
import cn.connxun.train.utils.util.BarUtils;
import cn.connxun.train.widget.AppTitle;

/**
 * Created by wushange on 2017/9/5.
 */

public class ClassListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    public static void callMe(Context context, @NonNull CourseType.MosCourseListBean videoClass) {
        Intent intent = new Intent(context, ClassListActivity.class);
        intent.putExtra("TID", videoClass);
        context.startActivity(intent);
    }

    @BindView(R.id.app_title_id)
    AppTitle appTitle;
    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView easyRecyclerview;

    @Inject
    AppApi appApi;

    @Inject
    HomeListAdapter adapter;
    CourseType.MosCourseListBean mCtye;

    @Override
    public int bindLayout() {
        return R.layout.activity_tyle_list;
    }

    @Override
    public void initParms(Bundle parms) {
        mCtye = (CourseType.MosCourseListBean) parms.get("TID");
    }

    @Override
    public void initView(View view) {
        BarUtils.setStatusBarTextColor(getContext(), true);
        easyRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        easyRecyclerview.addItemDecoration(new SpaceDecoration(10));
        easyRecyclerview.setAdapter(adapter);
        easyRecyclerview.setRefreshListener(this);
        appTitle.setTitle(mCtye.getCoursename());

    }

    @Override
    public void doBusiness(Context mContext) {
        getlist();

    }

    private void getlist() {
        compositeDisposable.add(appApi.getListByType(mCtye.getId() + "").subscribe(videoClasses -> {

            adapter.clear();
            adapter.addAll(videoClasses);
        }, throwable -> {
            easyRecyclerview.setRefreshing(false);
            Toast(throwable.getMessage());
        }));
    }

    @Override
    public void initInjector() {
        getComponent().inject(this);
    }

    @Override
    public void onRefresh() {
        getlist();
    }
}
