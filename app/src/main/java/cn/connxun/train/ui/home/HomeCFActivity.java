package cn.connxun.train.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.ui.base.BaseActivity;
import cn.connxun.train.ui.home.adapter.HomeCourseTypeAdapter;

/**
 * Created by wushange on 2017/9/20.
 */

public class HomeCFActivity extends BaseActivity {
    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView      easyRecyclerview;
    @Inject
    HomeCourseTypeAdapter adapter;
    @Inject
    AppApi                appApi;


    @Override
    public int bindLayout() {
        return R.layout.activity_homw_cf;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        easyRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        easyRecyclerview.addItemDecoration(new SpaceDecoration(10));
        easyRecyclerview.setAdapter(adapter);

    }

    @Override
    public void doBusiness(Context mContext) {
        appApi.getCourseTypeList().subscribe(courseTypes -> adapter.addAll(courseTypes),
                throwable -> Toast(throwable.getMessage()));

    }

    @Override
    public void initInjector() {
        getComponent().inject(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
