package cn.connxun.train.ui.home.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.train.R;
import cn.connxun.train.constants.Constants;
import cn.connxun.train.entity.Course;

/**
 * Created by wushange on 2017/9/5.
 */

public class JingXuanAdapter extends RecyclerArrayAdapter<Course> {

    @Inject
    public JingXuanAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new JingXuanAdapter.ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<Course> {

        @BindView(R.id.iv_item_class_img)
        ImageView ivItemClassImg;
        @BindView(R.id.tv_item_class_title)
        TextView tvItemClassTitle;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_types_class);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(Course data) {
            super.setData(data);
            tvItemClassTitle.setText(data.getCoursename());
            Glide.with(getContext())
                    .load(Constants.BASE_IMAGE_URL+data.getCoursepic())
                    .placeholder(R.mipmap.img_item_def_collect)
                    .into(ivItemClassImg);
        }
    }
}
