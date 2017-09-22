package cn.connxun.train.ui.home.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.util.List;

import cn.connxun.train.R;
import cn.connxun.train.constants.Constants;
import cn.connxun.train.entity.Banner;
import cn.connxun.train.ui.base.WebActivity;
import cn.connxun.train.utils.util.LogUtils;
import cn.connxun.train.utils.util.StringUtils;

public class HomeBannerAdapter extends StaticPagerAdapter {

    private Context      ctx;
    private List<Banner> list;

    public HomeBannerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public void setList(List<Banner> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        ImageView imageView = new ImageView(ctx);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LogUtils.e("--img path-->>>" + Constants.BASE_IMAGE_URL + list.get(position).getBannerPic());
        //加载图片
        Glide.with(ctx)
                .load(Constants.BASE_IMAGE_URL + list.get(position).getBannerPic())
                .placeholder(R.drawable.default_image)
                .into(imageView);
        //点击事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!StringUtils.isEmpty(list.get(position).getBannerUrl())) {
                    WebActivity.callMe(ctx, Uri.parse(list.get(position).getBannerUrl()).toString());
                }
            }
        });
        return imageView;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }
}