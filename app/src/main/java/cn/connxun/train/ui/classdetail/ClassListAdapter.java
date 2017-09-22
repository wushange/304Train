package cn.connxun.train.ui.classdetail;

import android.content.Context;
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
import cn.connxun.train.ui.download.LogDownloadListener;
import cn.connxun.train.utils.util.FileUtils;
import cn.connxun.train.utils.util.LogUtils;

/**
 * Created by wushange on 2017/7/19.
 */

public class ClassListAdapter extends RecyclerArrayAdapter<SubClass> {

    @Inject
    public ClassListAdapter(Context context) {
        super(context);
    }

    OnDownloadClickListener onDownloadClickListener;

    public void setOnDownloadClickListener(OnDownloadClickListener onDownloadClickListener) {
        this.onDownloadClickListener = onDownloadClickListener;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }


    class ViewHolder extends BaseViewHolder<SubClass> {

        @BindView(R.id.tv_item_class_title)
        TextView tvItemClassTitle;
        @BindView(R.id.tv_download_t)
        TextView tvDownloadT;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_video_subclass);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(SubClass data) {
            super.setData(data);
            String downloadPath =""+ Constants.BASE_URL+ data.getParturl();
            tvItemClassTitle.setText(data.getPartname());
            tvDownloadT.setOnClickListener(v -> {
                LogUtils.e("---"+ FileUtils.getFileLastName(downloadPath));
                String fileName   =  data.getPartname()+"."+ FileUtils.getFileExtension(downloadPath);
                LogUtils.e("-file all name ->>" +fileName);
                GetRequest<File> request = OkGo.<File>get(downloadPath);//
                //这里第一个参数是tag，代表下载任务的唯一标识，传任意字符串都行，需要保证唯一,我这里用url作为了tag
                OkDownload.request(downloadPath, request)//
                        .fileName(fileName)
                        .extra1(data)//
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

    public interface OnDownloadClickListener {
        void OnDownloadListener(int pos, TextView v);
    }
}
