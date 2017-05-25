package com.example.zz.workanimationdemo;

import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

/**
 * 类描述：动画实现视图高度由0转为全部，以及由全部转为0
 * 创建人：zz
 * 创建时间： 2017/5/25 15:44
 */


public class AnimationLayout {
    private boolean isAnimating=false;
    protected void expand(final View targetView, final int to, int duration) {
        final Interpolator accInterpolator = new FastOutSlowInInterpolator();
        Animation animation = new Animation() {

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                targetView.getLayoutParams().height = (int) (to * interpolatedTime);
                targetView.requestLayout();
            }
        };
        animation.setInterpolator(accInterpolator);
        animation.setDuration(duration);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                isAnimating = true;
                targetView.getLayoutParams().height = 0;
                targetView.requestLayout();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isAnimating = false;
                targetView.getLayoutParams().height = to;
                targetView.requestLayout();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        targetView.startAnimation(animation);
    }

    protected void collapse(final View targetView, final int to, int duration) {
//        targetView.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        final int currentHeight = targetView.getMeasuredHeight();
        final int currentHeight = to;
        final Interpolator accInterpolator = new FastOutSlowInInterpolator();
        Animation animation = new Animation() {

            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                targetView.getLayoutParams().height = (int) (currentHeight - currentHeight * interpolatedTime);
                targetView.requestLayout();
            }
        };
        animation.setInterpolator(accInterpolator);
        animation.setDuration(duration);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                isAnimating = true;
                targetView.getLayoutParams().height = currentHeight;
                targetView.requestLayout();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isAnimating = false;
                targetView.getLayoutParams().height = 0;
                targetView.requestLayout();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        targetView.startAnimation(animation);
    }
}
