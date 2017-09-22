/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.connxun.train.ui.download;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.Util;
import com.lzy.okgo.model.Progress;
import com.lzy.okserver.OkDownload;
import com.lzy.okserver.task.XExecutor;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;
import cn.connxun.train.R;
import cn.connxun.train.ui.base.BaseActivity;
import cn.connxun.train.ui.base.BaseEvents;
import cn.connxun.train.utils.util.BarUtils;
import cn.connxun.train.utils.util.FileUtils;
import cn.connxun.train.widget.AppTitle;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/11
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class DownloadAllActivity extends BaseActivity implements XExecutor.OnAllTaskEndListener {

    @BindView(R.id.app_title_id)
    AppTitle     appTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private DownloadAdapter adapter;
    private OkDownload      okDownload;

    @Override
    public int bindLayout() {
        return R.layout.activity_download_all;
    }

    @Override
    public void initInjector() {

    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        BarUtils.setStatusBarTextColor(getContext(), true);

    }

    @Override
    public void doBusiness(Context mContext) {
        okDownload = OkDownload.getInstance();
        adapter = new DownloadAdapter(this);
        adapter.updateData(DownloadAdapter.TYPE_ALL);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, Util.dip2px(getContext(), 0.5f));
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
        okDownload.addOnAllTaskEndListener(this);
        adapter.setOnItemClickListener(new DownloadAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(Progress filePath) {
                if (filePath.status == Progress.FINISH && filePath.filePath != null) {

                    FileUtils.startActionFile(filePath.filePath);
                }
            }
        });
    }

    @Override
    public void onAllTaskEnd() {
        Toast("所有下载任务已结束");
        EventBus.getDefault().postSticky(BaseEvents.CommonEvent.UPDATE_LIST);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        okDownload.removeOnAllTaskEndListener(this);
        adapter.unRegister();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.removeAll)
    public void removeAll(View view) {
        mOperation.showBasicDialog("删除所有及本地文件？", (dialog, which) -> {
            dialog.dismiss();
            okDownload.removeAll();
            adapter.updateData(DownloadAdapter.TYPE_ALL);
            adapter.notifyDataSetChanged();
        });

    }

    @OnClick(R.id.pauseAll)
    public void pauseAll(View view) {
        okDownload.pauseAll();
    }

    @OnClick(R.id.startAll)
    public void startAll(View view) {
        okDownload.startAll();
    }

}
