package cn.connxun.train.ui.home;


import java.util.List;

import cn.connxun.train.entity.Course;
import cn.connxun.train.ui.base.BasePView;

/**
 * Created by sll on 2016/5/11.
 */
public interface HomeHotNewContract {
    interface View extends BasePView {
        void showList(List<Course> courses);

        int getType();
    }

    interface Presenter {
        void getList();
    }
}
