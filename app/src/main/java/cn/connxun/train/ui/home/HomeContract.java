package cn.connxun.train.ui.home;


import java.util.List;

import cn.connxun.train.entity.Banner;
import cn.connxun.train.entity.Course;
import cn.connxun.train.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface HomeContract {
    interface HomeView extends BasePView {

        void showBannerList(List<Banner> banners);

        void showHistoryList(List<Course> courses);

        void showJingXuanList(List<Course> courses);
    }

    interface HomePresenter {
        void getHomeList();
    }
}
