package com.shangxiaom.animationdemo;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private ImageView mImageView2;

    private TextView mTextView;

    private Animation mAnimation;
    private AnimationDrawable mAnimationDrawable;
    private AnimatorSet mAnimatorSet;


    private Button mAlpha;
    private Button mRotate;
    private Button mScale;
    private Button mSet;
    private Button mTrans;

    private Button mFrame;

    private Button mPropertyAlpha;
    private Button mPropertyScale;
    private Button mPropertySet;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);
        mImageView2 = findViewById(R.id.imageView2);
        mImageView2.setBackgroundResource(R.drawable.frame_drawable);
        mTextView = findViewById(R.id.textView3);

        mAlpha = findViewById(R.id.view_anim_alpha);
        mRotate = findViewById(R.id.view_anim_rotate);
        mScale = findViewById(R.id.view_anim_scale);
        mSet = findViewById(R.id.view_anim_set);
        mTrans = findViewById(R.id.view_anim_trans);
        mFrame = findViewById(R.id.view_anim_frame);

        mPropertyAlpha = findViewById(R.id.property_anim_alpha);
        mPropertyScale = findViewById(R.id.property_anim_scale);
        mPropertySet = findViewById(R.id.property_anim_set);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mAlpha.setOnClickListener(mOnClickListener);
        mRotate.setOnClickListener(mOnClickListener);
        mScale.setOnClickListener(mOnClickListener);
        mSet.setOnClickListener(mOnClickListener);
        mTrans.setOnClickListener(mOnClickListener);
        mFrame.setOnClickListener(mOnClickListener);

        mPropertyAlpha.setOnClickListener(mOnClickListener);
        mPropertyScale.setOnClickListener(mOnClickListener);
        mPropertySet.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.view_anim_alpha:
                    mAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.view_alpha);
                    break;
                case R.id.view_anim_rotate:
                    mAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.view_rotate);
                    break;
                case R.id.view_anim_scale:
                    mAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.view_scale);
                    break;
                case R.id.view_anim_set:
                    mAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.view_set);
                    break;
                case R.id.view_anim_trans:
                    mAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.view_trans);
                    break;
                case R.id.view_anim_frame:
                    mAnimationDrawable = (AnimationDrawable) mImageView2.getBackground();
                    if (mAnimationDrawable.isRunning()) {
                        mAnimationDrawable.stop();
                    } else {
                        mAnimationDrawable.start();
                    }
                    return;
                case R.id.property_anim_alpha:
                    mAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.property_anim_alpha);
                    mAnimatorSet.setTarget(mTextView);
                    if (mAnimatorSet.isStarted()) {
                        mAnimatorSet.cancel();
                    }
                    mAnimatorSet.start();
                    return;
                case R.id.property_anim_scale:
                    mAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.property_anim_scale);
                    mAnimatorSet.setTarget(mTextView);
                    if (mAnimatorSet.isStarted()) {
                        mAnimatorSet.cancel();
                    }
                    mAnimatorSet.start();
                    return;
                case R.id.property_anim_set:
                    mAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.property_anim_set);
                    mAnimatorSet.setTarget(mTextView);
                    if (mAnimatorSet.isStarted()) {
                        mAnimatorSet.cancel();
                    }
                    mAnimatorSet.start();
                    return;

            }
            mImageView.startAnimation(mAnimation);
        }
    };

}
