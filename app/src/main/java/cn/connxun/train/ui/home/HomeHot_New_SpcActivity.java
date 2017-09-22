package cn.connxun.train.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.entity.Course;
import cn.connxun.train.ui.base.BaseActivity;
import cn.connxun.train.ui.home.adapter.HomeHotNewListAdapter;
import cn.connxun.train.widget.AppTitle;

/**
 * Created by wushange on 2017/9/20.
 */

public class HomeHot_New_SpcActivity extends BaseActivity implements HomeHotNewContract.View {


    private static final String TYPE_TAG = "TYPE_TAG";
    @BindView(R.id.appbar)
    AppBarLayout     appbar;
    @BindView(R.id.app_title_id)
    AppTitle         apptitle;
    @BindView(R.id.easy_recyclerview)
    EasyRecyclerView easyRecyclerview;

    @Inject
    HomeHotNewListAdapter adapter;
    @Inject
    HomeHotNewPresenter   presenter;

    public static void callMe(Context context, int type) {
        Intent intent = new Intent(context, HomeHot_New_SpcActivity.class);
        intent.putExtra(TYPE_TAG, type);
        context.startActivity(intent);
    }

    int type = 0;

    @Override
    public int bindLayout() {
        return R.layout.activity_homw_hot;
    }

    @Override
    public void initParms(Bundle parms) {
        type = parms.getInt(TYPE_TAG);
    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        if (0 == type) {
            apptitle.setTitle("专题");
        } else if (1 == type) {
            apptitle.setTitle("最热");
        } else if (2 == type) {
            apptitle.setTitle("最新");
        }
        easyRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        easyRecyclerview.addItemDecoration(new SpaceDecoration(10));
        easyRecyclerview.setAdapter(adapter);

    }

    @Override
    public void doBusiness(Context mContext) {
        presenter.getList();
    }

    @Override
    public void initInjector() {

        getComponent().inject(this);
    }


    @Override
    public void startLoading() {

    }

    @Override
    public void endLoading() {

    }

    @Override
    public void onError(String error) {
        Toast(error);

    }

    @Override
    public void showList(List<Course> courses) {
        adapter.clear();
        adapter.addAll(courses);
    }

    @Override
    public int getType() {
        return type;
    }
}
