package cn.connxun.train.ui.home;

import javax.inject.Inject;

import cn.connxun.train.api.AppApi;
import cn.connxun.train.di.PerActivity;
import cn.connxun.train.ui.base.BasePresenter;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class HomeHotNewPresenter extends BasePresenter<HomeHotNewContract.View> implements HomeHotNewContract.Presenter {

    private AppApi api;

    @Inject
    public HomeHotNewPresenter(AppApi api) {
        this.api = api;
    }


    @Override
    public void getList() {
        if (mView.getType() == 0) {
            //专题
            api.getSpecList().subscribe(courses -> {
                mView.showList(courses);
            }, throwable -> {
                mView.onError(throwable.getMessage());
            });
        } else if (mView.getType() == 1) {
            //最热
            api.getHotList().subscribe(courses -> {
                mView.showList(courses);
            }, throwable -> {
                mView.onError(throwable.getMessage());
            });
        } else if (mView.getType() == 2) {
            //最新
            api.getNewList().subscribe(courses -> {
                mView.showList(courses);
            }, throwable -> {
                mView.onError(throwable.getMessage());
            });
        }
    }
}
