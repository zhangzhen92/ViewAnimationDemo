package com.example.zz.workanimationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
/**
 * 类描述：动画实现视图高度由0变为全部
 * 创建人：zz
 * 创建时间：2017/5/25 16:18
 */
public class MainActivity extends Activity implements View.OnClickListener{

    private Button buttonMore;
    private LinearLayout linearMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        buttonMore = ((Button) findViewById(R.id.button_more));
        buttonMore.setOnClickListener(this);
        buttonMore.setTag(0);
        linearMore = ((LinearLayout) findViewById(R.id.linearlayout_more));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_more:
                int viewHeight = getResources().getDimensionPixelOffset(R.dimen.more);      //展开视图的高度
                AnimationLayout animationLayout = new AnimationLayout();

                if(0 == (int)buttonMore.getTag()){
                expendAnimation(animationLayout,viewHeight);
                }else {
                    collapseAnimation(animationLayout,viewHeight);
                }
                break;
        }
    }

    /**
     * 折叠view
     * @param animationLayout
     */
    private void collapseAnimation(AnimationLayout animationLayout,int viewHeight) {
        animationLayout.collapse(linearMore,viewHeight,2000);
        buttonMore.setTag(0);
    }

    /**
     * 展开动画效果
     * @param animationLayout
     * @param viewHeight
     */
    private void expendAnimation(AnimationLayout animationLayout, int viewHeight) {
        animationLayout.expand(linearMore,viewHeight,2000);
        buttonMore.setTag(1);
    }
}
