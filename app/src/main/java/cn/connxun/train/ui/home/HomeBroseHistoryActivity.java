package cn.connxun.train.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.ui.base.BaseActivity;
import cn.connxun.train.ui.home.adapter.BrowseListAdapter;
import cn.connxun.train.utils.UserUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wushange on 2017/9/21.
 */

public class HomeBroseHistoryActivity extends BaseActivity {
    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView  easyRecyclerview;
    @Inject
    BrowseListAdapter adapter;

    @Inject
    AppApi appApi;
    @Override
    public int bindLayout() {
        return R.layout.activity_browse_list;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        easyRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        easyRecyclerview.addItemDecoration(new DividerDecoration(Color.GRAY, 1));
        easyRecyclerview.setAdapter(adapter);

    }

    @Override
    public void doBusiness(Context mContext) {
        appApi.getBrowseHistory(UserUtil.getUser().getId()+"").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        browserHistories -> adapter.addAll(browserHistories),
                        throwable -> Toast(throwable.getMessage()));

    }

    @Override
    public void initInjector() {
        getComponent().inject(this);
    }

}
