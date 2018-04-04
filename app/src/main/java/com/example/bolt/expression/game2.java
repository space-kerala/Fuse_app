package com.example.bolt.expression;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Random;

public class game2 extends AppCompatActivity {

    private ViewPager viewPager,viewPager2;
    private CustomSwipeAdapter adapter;
    private CustomSwipeAdapter1 adapter2;
    private TextView t11,t12,t13,textView;
    private int pi;
    private int count = 0;
    private String p,q,r;
    private String[] str ={"sad" , "disgust", "anger","joy", "fear"};
    private Animation shake;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        t11 = (TextView) findViewById(R.id.ftv1);
        t12 = (TextView) findViewById(R.id.ftv2);
        textView = (TextView)findViewById(R.id.textView);
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        viewPager = (ViewPager)findViewById(R.id.viewP);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(5);

        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                /*final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setScaleX(normalizedposition / 2 + 0.5f);
                page.setScaleY(normalizedposition / 2 + 0.5f);*/
                page.setRotationY(position * -30);
            }
        });


        viewPager2 = (ViewPager)findViewById(R.id.viewP2);
        adapter2 = new CustomSwipeAdapter1(this);
        viewPager2.setAdapter(adapter2);
        viewPager2.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                /*final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setScaleX(normalizedposition / 2 + 0.5f);
                page.setScaleY(normalizedposition / 2 + 0.5f);*/
                page.setRotationY(position * -30);
            }
        });
        setName();



    }

    public void fuse(View v){

        if( q.equals(str[viewPager.getCurrentItem()]) && r.equals(str[viewPager2.getCurrentItem()])){
            setName();
            count+=10;
            t13 = (TextView) findViewById(R.id.score);
            t13.setText(Integer.toString(count));


            v.startAnimation(shake);
            t11.setTextColor(Color.GREEN);
            t12.setTextColor(Color.GREEN);
            t13.setTextColor(Color.GREEN);
            textView.setTextColor(Color.GREEN);
            new CountDownTimer(1000, 1000) {

                @Override
                public void onTick(long arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onFinish() {

                    t11.setTextColor(Color.GRAY);
                    t12.setTextColor(Color.GRAY);
                    t13.setTextColor(Color.GRAY);
                    textView.setTextColor(Color.GRAY);
                }
            }.start();

        }

    }

    public String randomName(){
        pi = new Random().nextInt(str.length);
        p=str[pi];
        return p;
    }

    public void setName(){


        q=randomName();
        t11.setText(q);


        r=randomName();
        t12.setText(r);



    }

}
