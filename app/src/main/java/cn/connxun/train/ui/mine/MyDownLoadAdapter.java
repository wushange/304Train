package cn.connxun.train.ui.mine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.lzy.okserver.download.DownloadTask;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.train.R;

/**
 * Created by wushange on 2017/7/19.
 */

public class MyDownLoadAdapter extends RecyclerArrayAdapter<DownloadTask> {

    @Inject
    public MyDownLoadAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<DownloadTask> {

        @BindView(R.id.tv_item_class_title)
        TextView tvItemClassTitle;
        @BindView(R.id.tv_download_t)
        TextView tvDownloadT;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_video_subclass);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(DownloadTask data) {
            super.setData(data);
            tvDownloadT.setVisibility(View.GONE);
            tvItemClassTitle.setText(data.progress.fileName);
        }
    }
}
