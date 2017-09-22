package cn.connxun.train.ui.classdetail;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import cn.connxun.train.R;
import cn.connxun.train.di.component.FragmentComponent;
import cn.connxun.train.entity.VideoClass;
import cn.connxun.train.ui.base.BaseFragmentV4;

/**
 * Created by wushange on 2017/7/19.
 */

public class ClassDetailFragment extends BaseFragmentV4 {
    @BindView(R.id.tv_class_detail_text)
    TextView tvClassDetail;

    public static ClassDetailFragment newInstance(VideoClass videoClass) {
        ClassDetailFragment fragment = new ClassDetailFragment();
        fragment.setVideoClass(videoClass);
        return fragment;
    }

    public void setVideoClass(VideoClass videoClass) {
        this.videoClass = videoClass;
    }

    VideoClass videoClass;

    @Override
    public int bindLayout() {
        return R.layout.fragment_class_detail;
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public void initView(View view) {
        if (videoClass != null) {
            tvClassDetail.setText(videoClass.getCoursedesc());
        }
    }

    @Override
    public void doBusiness(Context mContext) {
    }

    @Override
    public void lazyInitBusiness(Context mContext) {
    }


    @Override
    public void initInjector() {
        getComponent(FragmentComponent.class).inject(this);
    }

}
