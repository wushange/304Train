/*
 * Copyright 2016 Yan Zhenjie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.connxun.train.utils.util;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.support.annotation.IntRange;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

/**
 * Created on 2016/7/14.
 *
 * @author Yan Zhenjie.
 */
public class AnimatorUtil {


    // 显示view
    public static void scaleShow(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        view.setVisibility(View.VISIBLE);
        ViewCompat.animate(view)
                .scaleX(1.0f)
                .scaleY(1.0f)
                .alpha(1.0f)
                .setDuration(800)
                .setListener(viewPropertyAnimatorListener)
                .setInterpolator(new LinearOutSlowInInterpolator())
                .start();
    }

    // 隐藏view
    public static void scaleHide(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        ViewCompat.animate(view)
                .scaleX(0.0f)
                .scaleY(0.0f)
                .alpha(0.0f)
                .setDuration(800)
                .setInterpolator(new LinearOutSlowInInterpolator())
                .setListener(viewPropertyAnimatorListener)
                .start();
    }

    public static void scaleHide(View view) {
        ViewCompat.animate(view)
                .scaleX(0.0f)
                .scaleY(0.0f)
                .alpha(0.0f)
                .setDuration(800)
                .setInterpolator(new LinearOutSlowInInterpolator())
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {

                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        view.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(View view) {

                    }
                })
                .start();
    }  // 显示view

    public static void scaleShow(View view) {
        view.setVisibility(View.VISIBLE);
        ViewCompat.animate(view)
                .scaleX(1.0f)
                .scaleY(1.0f)
                .alpha(1.0f)
                .setDuration(800)
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {

                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(View view) {

                    }
                })
                .setInterpolator(new LinearOutSlowInInterpolator())
                .start();
    }

    /**
     * 软键盘状态监听
     * <p/>
     * 根据判断根view的可用空间判断
     * 不一定精确
     *
     * @param root
     */
    public static void addGlobaLayoutListener(final View root, final View childView) {
        KeyboardUtils.doMonitorSoftKeyWord(root, new KeyboardUtils.OnSoftKeyWordShowListener() {
            @Override
            public void hasShow(boolean isShow) {
                if (isShow) {
                    AnimatorUtil.scaleHide(childView, new ViewPropertyAnimatorListener() {
                        @Override
                        public void onAnimationStart(View view) {
                            childView.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationEnd(View view) {
                        }

                        @Override
                        public void onAnimationCancel(View view) {
                        }
                    });
                } else {
                    AnimatorUtil.scaleShow(childView, new ViewPropertyAnimatorListener() {
                        @Override
                        public void onAnimationStart(View view) {

                        }

                        @Override
                        public void onAnimationEnd(View view) {

                            childView.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationCancel(View view) {

                        }
                    });
                }

            }
        });
//        root.getViewTreeObserver().addOnGlobalLayoutListener(
//                new ViewTreeObserver.OnGlobalLayoutListener() {
//                    @Override
//                    public void onGlobalLayout() {
//
//                        Rect rect = new Rect();
//                        // 获取root在窗体的可视区域
//                        root.getWindowVisibleDisplayFrame(rect);
//                        // 获取root在窗体的不可视区域高度(被其他View遮挡的区域高度)
//                        int rootInvisibleHeight = root.getRootView()
//                                .getHeight() - rect.bottom;
//                        // 若不可视区域高度大于100，则键盘显示
//                        if (rootInvisibleHeight > 100) {
////                            Logger.e("键盘开启了");
//                            int[] location = new int[2];
//                            AnimatorUtil.scaleHide(childView, new ViewPropertyAnimatorListener() {
//                                @Override
//                                public void onAnimationStart(View view) {
//                                    childView.setVisibility(View.GONE);
//                                }
//
//                                @Override
//                                public void onAnimationEnd(View view) {
//
//
//                                }
//
//                                @Override
//                                public void onAnimationCancel(View view) {
//
//                                }
//                            });
//                        } else {
//                            // 键盘隐藏
////                            Logger.e("键盘关闭了");
//                            AnimatorUtil.scaleShow(childView, new ViewPropertyAnimatorListener() {
//                                @Override
//                                public void onAnimationStart(View view) {
//
//                                }
//
//                                @Override
//                                public void onAnimationEnd(View view) {
//
//                                    childView.setVisibility(View.VISIBLE);
//                                }
//
//                                @Override
//                                public void onAnimationCancel(View view) {
//
//                                }
//                            });
//                        }
//                    }
//                });
    }

    public static ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(300);
        animator.setInterpolator(createInterpolator(LINEAR_INTERPOLATOR));
        return animator;
    }

    public static final int ACCELERATE_DECELERATE_INTERPOLATOR = 0;
    public static final int ACCELERATE_INTERPOLATOR = 1;
    public static final int ANTICIPATE_INTERPOLATOR = 2;
    public static final int ANTICIPATE_OVERSHOOT_INTERPOLATOR = 3;
    public static final int BOUNCE_INTERPOLATOR = 4;
    public static final int DECELERATE_INTERPOLATOR = 5;
    public static final int FAST_OUT_LINEAR_IN_INTERPOLATOR = 6;
    public static final int FAST_OUT_SLOW_IN_INTERPOLATOR = 7;
    public static final int LINEAR_INTERPOLATOR = 8;
    public static final int LINEAR_OUT_SLOW_IN_INTERPOLATOR = 9;
    public static final int OVERSHOOT_INTERPOLATOR = 10;

    /**
     * Creates interpolator.
     *
     * @param interpolatorType
     * @return
     */
    public static TimeInterpolator createInterpolator(@IntRange(from = 0, to = 10) final int interpolatorType) {
        switch (interpolatorType) {
            case ACCELERATE_DECELERATE_INTERPOLATOR:
                return new AccelerateDecelerateInterpolator();
            case ACCELERATE_INTERPOLATOR:
                return new AccelerateInterpolator();
            case ANTICIPATE_INTERPOLATOR:
                return new AnticipateInterpolator();
            case ANTICIPATE_OVERSHOOT_INTERPOLATOR:
                return new AnticipateOvershootInterpolator();
            case BOUNCE_INTERPOLATOR:
                return new BounceInterpolator();
            case DECELERATE_INTERPOLATOR:
                return new DecelerateInterpolator();
            case FAST_OUT_LINEAR_IN_INTERPOLATOR:
                return new FastOutLinearInInterpolator();
            case FAST_OUT_SLOW_IN_INTERPOLATOR:
                return new FastOutSlowInInterpolator();
            case LINEAR_INTERPOLATOR:
                return new LinearInterpolator();
            case LINEAR_OUT_SLOW_IN_INTERPOLATOR:
                return new LinearOutSlowInInterpolator();
            case OVERSHOOT_INTERPOLATOR:
                return new OvershootInterpolator();
            default:
                return new LinearInterpolator();
        }
    }
}
