package cn.connxun.train.ui.mine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.train.R;
import cn.connxun.train.entity.MyCourse;

/**
 * Created by wushange on 2017/7/19.
 */

public class MyClassList1Adapter extends RecyclerArrayAdapter<MyCourse> {

    @Inject
    public MyClassList1Adapter(Context context) {
        super(context);
    }


    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }


    class ViewHolder extends BaseViewHolder<MyCourse> {

        @BindView(R.id.tv_item_class_title)
        TextView tvItemClassTitle;

        @BindView(R.id.tv_download_t)
        TextView tvDownloadT;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_video_myclass);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(MyCourse data) {
            super.setData(data);
            tvDownloadT.setVisibility(View.GONE);
            tvItemClassTitle.setText(data.getMosCourse().getCoursename());

        }
    }

}
