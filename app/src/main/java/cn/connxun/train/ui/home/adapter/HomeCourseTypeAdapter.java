package cn.connxun.train.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.train.R;
import cn.connxun.train.constants.Constants;
import cn.connxun.train.entity.CourseType;
import cn.connxun.train.ui.home.ClassListActivity;

/**
 * Created by wushange on 2017/9/21.
 */

public class HomeCourseTypeAdapter extends RecyclerArrayAdapter<CourseType> {

    @Inject
    public HomeCourseTypeAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    class ViewHolder extends BaseViewHolder<CourseType> {


        @BindView(R.id.person_face)
        ImageView        personFace;
        @BindView(R.id.c_type_list)
        EasyRecyclerView cTypeList;

        public ViewHolder(ViewGroup group) {
            super(group, R.layout.item_course_type);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(CourseType data) {
            super.setData(data);
            Glide.with(getContext())
                    .load(Constants.BASE_IMAGE_URL+data.getTypepic())
                    .placeholder(R.mipmap.img_item_def_collect)
                    .into(personFace);
            HomeCourseTypesAdapter adapter = new HomeCourseTypesAdapter(getContext());
            cTypeList.setLayoutManager(new GridLayoutManager(getContext(),2));
            cTypeList.setAdapter(adapter);
            adapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    ClassListActivity.callMe(getContext(),adapter.getItem(position));
                }
            });
            adapter.addAll(data.getMosCourseList());

        }
    }

      class HomeCourseTypesAdapter extends RecyclerArrayAdapter<CourseType.MosCourseListBean> {

        HomeCourseTypesAdapter(Context context) {
            super(context);
        }

        @Override
        public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(parent);
        }

        class ViewHolder extends BaseViewHolder<CourseType.MosCourseListBean> {


            @BindView(R.id.tv_item_course_tname)
            TextView tvItemCourseTname;

            public ViewHolder(ViewGroup group) {
                super(group, R.layout.item_course_type_name);
                ButterKnife.bind(this, itemView);
            }

            @Override
            public void setData(CourseType.MosCourseListBean data) {
                super.setData(data);
                tvItemCourseTname.setText(data.getCoursename());
            }
        }
    }

}
