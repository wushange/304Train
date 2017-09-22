package cn.connxun.train.ui.classdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.stetho.common.LogUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.connxun.train.R;
import cn.connxun.train.api.AppApi;
import cn.connxun.train.constants.Constants;
import cn.connxun.train.data.ACache;
import cn.connxun.train.db.VideoClassDao;
import cn.connxun.train.di.HasComponent;
import cn.connxun.train.di.component.DaggerFragmentComponent;
import cn.connxun.train.di.component.FragmentComponent;
import cn.connxun.train.entity.PUser;
import cn.connxun.train.entity.SubClass;
import cn.connxun.train.entity.VideoClass;
import cn.connxun.train.ui.base.BaseActivity;
import cn.connxun.train.ui.base.BaseEvents;
import cn.connxun.train.ui.base.ViewPagerAdapter;
import cn.connxun.train.ui.filepreview.FilePreviewActivity;
import cn.connxun.train.utils.UserUtil;
import cn.connxun.train.utils.util.BarUtils;
import cn.connxun.train.utils.util.FileUtils;
import cn.connxun.train.utils.util.LogUtils;
import fm.jiecao.jcvideoplayer_lib.JCMediaManager;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by wushange on 2017/8/27.
 */

public class ClassDetailActivity extends BaseActivity implements HasComponent<FragmentComponent> {
    public static String CLASS_DETAIL_TAG = "CLASS_DETAIL_TAG";
    @BindView(R.id.jiecao_video)
    JCVideoPlayerStandard jiecaoVideo;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tv_like_t)
    TextView tvLikeT;
    private ViewPagerAdapter adapter;


    @Inject
    AppApi appApi;
    private FragmentComponent mMainComponent;

    public static void callMe(Context context, @NonNull VideoClass videoClass) {
        Intent intent = new Intent(context, ClassDetailActivity.class);
        intent.putExtra(CLASS_DETAIL_TAG, videoClass);
        context.startActivity(intent);
    }

    VideoClass videoClass;

    @Inject
    VideoClassDao videoClassDao;
    PUser pUser;

    @Override
    public int bindLayout() {
        return R.layout.activity_class_detail;
    }

    @Override
    public void initParms(Bundle parms) {
        videoClass = (VideoClass) parms.get(CLASS_DETAIL_TAG);
    }

    @Override
    public void initView(View view) {
        pUser = (PUser) ACache.get(getContext()).getAsObject(Constants.USER_ID);
        EventBus.getDefault().register(this);
        BarUtils.setStatusBarTextColor(getContext(), true);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        ViewCompat.setElevation(tablayout, 10);
        initPclassView();
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void doBusiness(Context mContext) {
        appApi.isLike(UserUtil.getUser().getId()+"",videoClass.getId()+"").subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

            }

            @Override
            public void onNext(@io.reactivex.annotations.NonNull String o) {
                LogUtil.e(""+o.toString());
                if("1".equals(o.toString())){
                    videoClass.setState(1);
                    tvLikeT.setText("取消收藏");
                }else {
                    tvLikeT.setText("收藏");
                }
            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                LogUtil.e("--"+ e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void initInjector() {
        mMainComponent = DaggerFragmentComponent.builder()
                .applicationComponent(getApplicationComponent())
                .build();
        mMainComponent.inject(this);

    }

    @Override
    public FragmentComponent getFragmentComponent() {
        return mMainComponent;
    }

    private void initPclassView() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(ClassDetailFragment.newInstance(videoClass), "详情");
        adapter.addFragment(ClassListlFragment.newInstance(videoClass), "目录");
        viewpager.setOffscreenPageLimit(2);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
        jiecaoVideo.setUp("http://data.vod.itc.cn/?rb=1&prot=1&key=jbZhEJhlqlUN-Wj_HEI8BjaVqKNFvDrn&prod=flash&pt=1&new=/206/85/XHXUSPbqSTSY9BvB843PTG.mp4"
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, videoClass.getCoursename());
        Glide.with(getContext())
                .load(Constants.BASE_IMAGE_URL+ videoClass.getCoursepic())
                .placeholder(R.mipmap.img_item_def_collect)
                .into(jiecaoVideo.thumbImageView);
        tvLikeT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(videoClass.getState()==1){
                    compositeDisposable.add(appApi.unLike(pUser.getId() + "", videoClass.getId() + "").subscribe(o -> {
                        Toast("取消收藏成功");
                        tvLikeT.setText("收藏");
                        videoClass.setState(0);
                    }, throwable -> Toast(throwable.getMessage())));
                }else{
                    compositeDisposable.add(appApi.like(pUser.getId() + "", videoClass.getId() + "").subscribe(o -> {
                        Toast("收藏成功");
                        tvLikeT.setText("取消收藏");
                        videoClass.setState(1);
                    }, throwable -> Toast(throwable.getMessage())));
                }
            }
        });
    }

    @Subscribe
    public void updatClass(BaseEvents.CommonEvent commonEvent) {
        if (commonEvent.equals(BaseEvents.CommonEvent.UPDATE_PCALSS)) {
            SubClass subClass = (SubClass) commonEvent.getObj();
            String ext = FileUtils.getFileExtension(subClass.getParturl());
            LogUtils.e("---new Class-->>" + subClass.toString());
            switch (ext) {
                case "mp4":
                    JCMediaManager.instance().releaseMediaPlayer();
                    jiecaoVideo.setUp( Constants.BASE_URL+subClass.getParturl()
                            , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL
                            , subClass.getPartname());
                    Glide.with(getContext())
                            .load(Constants.BASE_IMAGE_URL+videoClass.getCoursepic())
                            .placeholder(R.mipmap.img_item_def_collect)
                            .into(jiecaoVideo.thumbImageView);
                    jiecaoVideo.startButton.performClick();
                    break;
                default:
                    LogUtils.e("--"+ AppApi.BASE_URL + subClass.getParturl());
                    FilePreviewActivity.callMe(getContext(), Constants.BASE_URL + subClass.getParturl());
                    break;

            }

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
