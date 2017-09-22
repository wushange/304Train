package cn.connxun.train.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.ui.base.BaseActivity;
import cn.connxun.train.ui.home.adapter.HomeListAdapter;
import cn.connxun.train.utils.util.BarUtils;

/**
 * Created by wushange on 2017/8/30.
 */

public class HomeSearchActivity extends BaseActivity {
    @BindView(R.id.erl_searchlist)
    EasyRecyclerView easyRecyclerView;
    @BindView(R.id.search)
    SearchView       searchView;
    @Inject
    HomeListAdapter  adapter;
    @Inject
    AppApi           appApi;

    @Override
    public int bindLayout() {
        return R.layout.activity_searchlist;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        BarUtils.setStatusBarTextColor(getContext(), true);
        easyRecyclerView.setAdapter(adapter);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
        searchView.setQueryHint("输入课程名称搜索");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                showProgressDialog("搜索中...");
                compositeDisposable.add(appApi.search(query, "").subscribe(videoClasses -> {
                    dissmissDialog();
                    if (videoClasses.size() <= 0) {
                        mOperation.showBasicDialog("暂未搜索到数据");
                    }
                    adapter.clear();
                    adapter.addAll(videoClasses);
                }, throwable -> {
                    dissmissDialog();
                    Toast(throwable.getMessage());
                }));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void doBusiness(Context mContext) {


    }

    @Override
    public void initInjector() {

        getComponent().inject(this);
    }
}
