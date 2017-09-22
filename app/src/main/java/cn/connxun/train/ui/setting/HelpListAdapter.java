package cn.connxun.train.ui.setting;

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
import cn.connxun.train.entity.QuestBean;
import cn.connxun.train.entity.SubClass;
import cn.connxun.train.ui.download.LogDownloadListener;
import cn.connxun.train.utils.util.FileUtils;
import cn.connxun.train.utils.util.LogUtils;

/**
 * Created by wushange on 2017/7/19.
 */

public class HelpListAdapter extends RecyclerArrayAdapter<QuestBean> {

    @Inject
    public HelpListAdapter(Context context) {
        super(context);
    }


    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }


    class ViewHolder extends BaseViewHolder<QuestBean> {

        @BindView(R.id.qname)
        TextView tvItemClassTitle;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_help_quest);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(QuestBean data) {
            super.setData(data);
            tvItemClassTitle.setText(data.getQuestion());


        }
    }

}
