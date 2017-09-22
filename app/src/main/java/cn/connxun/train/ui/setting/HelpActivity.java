package cn.connxun.train.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.entity.QuestBean;
import cn.connxun.train.ui.base.BaseActivity;
import cn.connxun.train.utils.util.BarUtils;
import cn.connxun.train.utils.util.LogUtils;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by wushange on 2017/8/27.
 */

public class HelpActivity extends BaseActivity {

    @Inject
    AppApi appApi;
    @Inject
    HelpListAdapter adapter;

    @BindView(R.id.qlist)
    EasyRecyclerView easyRecyclerView;
    @Override
    public int bindLayout() {
        return R.layout.activity_helper;
    }

    @Override
    public void initParms(Bundle parms) {


    }

    @Override
    public void initView(View view) {
        BarUtils.setStatusBarTextColor(getContext(),true);
    }

    @Override
    public void doBusiness(Context mContext) {
        easyRecyclerView.setAdapter(adapter);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        appApi.getQuestList().subscribe(new Consumer<List<QuestBean>>() {
            @Override
            public void accept(@NonNull List<QuestBean> questBeen) throws Exception {
                LogUtils.e("--->>" + questBeen.toString());
                adapter.addAll(questBeen);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Toast(throwable.getMessage());
            }
        });
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mOperation.showBasicDialog(adapter.getItem(position).getAnswer());
            }
        });
    }

    @Override
    public void initInjector() {

        getComponent().inject(this);
    }
}
