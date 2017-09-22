package cn.connxun.train.widget.swipebacklayout.activity;


import cn.connxun.train.widget.swipebacklayout.SwipeBackLayout;

public interface SwipeBackActivityBase {
    public abstract SwipeBackLayout getSwipeBackLayout();

    public abstract void setSwipeBackEnable(boolean enable);
    public abstract void scrollToFinishActivity();

}
