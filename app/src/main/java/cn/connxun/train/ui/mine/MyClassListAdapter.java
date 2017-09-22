package cn.connxun.train.ui.mine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okserver.OkDownload;

import java.io.File;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.train.R;
import cn.connxun.train.constants.Constants;
import cn.connxun.train.entity.SubClass;
import cn.connxun.train.entity.VideoClass;
import cn.connxun.train.ui.download.LogDownloadListener;
import cn.connxun.train.utils.util.FileUtils;
import cn.connxun.train.utils.util.LogUtils;

/**
 * Created by wushange on 2017/7/19.
 */

public class MyClassListAdapter extends RecyclerArrayAdapter<VideoClass> {

    @Inject
    public MyClassListAdapter(Context context) {
        super(context);
    }


    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }


    class ViewHolder extends BaseViewHolder<VideoClass> {

        @BindView(R.id.tv_item_class_title)
        TextView tvItemClassTitle;

        @BindView(R.id.tv_download_t)
        TextView tvDownloadT;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_video_myclass);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(VideoClass data) {
            super.setData(data);
            SubClass subClass = new SubClass();
            subClass.setId((int) data.getId());
            subClass.setPartname(data.getCoursename());
            subClass.setParturl(data.getCoursepic());
            String downloadPath = Constants.BASE_FILE_URL + data.getCoursepic();
            tvItemClassTitle.setText(data.getCoursename());tvDownloadT.setVisibility(View.GONE);
            tvDownloadT.setOnClickListener(v -> {
                LogUtils.e("---"+ FileUtils.getFileLastName(downloadPath));
                GetRequest<File> request = OkGo.<File>get(downloadPath);//
                OkDownload.request(downloadPath, request)//
                        .extra1(subClass)//
                        .save()//
                        .register(new LogDownloadListener())//
                        .start();
                tvDownloadT.setText("已在队列");
            });

            if (OkDownload.getInstance().getTask(downloadPath) != null) {
                tvDownloadT.setText("已在队列");
                tvDownloadT.setEnabled(false);
            } else {
                tvDownloadT.setText("下载");
                tvDownloadT.setEnabled(true);
            }
        }
    }

}
