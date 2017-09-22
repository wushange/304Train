package cn.connxun.train.ui.home;

import javax.inject.Inject;

import cn.connxun.train.api.AppApi;
import cn.connxun.train.di.PerActivity;
import cn.connxun.train.ui.base.BasePresenter;
import cn.connxun.train.utils.UserUtil;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class HomePresenter extends BasePresenter<HomeContract.HomeView> implements HomeContract.HomePresenter {

    private AppApi api;

    @Inject
    public HomePresenter(AppApi api) {
        this.api = api;
    }


    @Override
    public void getHomeList() {
        mDisposable.add(api.getBannerList().subscribe(banners -> mView.showBannerList(banners),
                throwable -> mView.onError(throwable.getMessage())));
        mDisposable.add(api.getJingXuan().subscribe(courses -> mView.showJingXuanList(courses),
                throwable -> mView.onError(throwable.getMessage())));
        mDisposable.add(api.getHistorys(UserUtil.getUser().getId() + "", 4).subscribe(courses ->
                        mView.showHistoryList(courses)
                , throwable ->
                        mView.onError(throwable.getMessage())
        ));
    }
}
