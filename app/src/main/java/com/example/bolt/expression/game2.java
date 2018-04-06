package com.example.bolt.expression;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class game2 extends AppCompatActivity {

    private ViewPager viewPager,viewPager2;
    private CustomSwipeAdapter adapter;
    private CustomSwipeAdapter1 adapter2;
    private TextView t11,t12,t13,textView;
    private int pi;
    private int count = 0;
    private String p,q,r;
    private String[] str ={"വിഷമം" , "വെറുപ്പ്", "ദേഷ്യം","ആനന്ദം", "കരച്ചിൽ"};
    private Animation shake;
    private ArrayList<Integer> sounds;
    private MediaPlayer wrongVoice,mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        t11 = (TextView) findViewById(R.id.ftv1);
        t12 = (TextView) findViewById(R.id.ftv2);
        t13 = (TextView) findViewById(R.id.score);
        textView = (TextView)findViewById(R.id.textView);
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        mediaPlayer = MediaPlayer.create(this,R.raw.alternative_correct);
        wrongVoice = MediaPlayer.create(this, R.raw.wrong);

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

        TabLayout tabLayout1 = (TabLayout) findViewById(R.id.tabDots);
        tabLayout1.setupWithViewPager(viewPager, true);


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
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots1);
        tabLayout.setupWithViewPager(viewPager2, true);

        sounds = new ArrayList<>();
        sounds.add(R.raw.correct1);
        sounds.add(R.raw.correct2);
        sounds.add(R.raw.correct3);
        sounds.add(R.raw.correct4);
        sounds.add(R.raw.correct5);
        sounds.add(R.raw.correct6);

    }

    public void fuse(View v){

        if( q.equals(str[viewPager.getCurrentItem()]) && r.equals(str[viewPager2.getCurrentItem()])){


            v.startAnimation(shake);
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    int randomInt = (new Random().nextInt(sounds.size()));
                    int sound = sounds.get(randomInt);
                    mp = MediaPlayer.create(getApplicationContext(), sound);
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {

                            setName();
                            count+=10;

                            t13.setText(Integer.toString(count));
                        }
                    });
                }
            });


                   /* setName();
                    count+=10;
                    t13 = (TextView) findViewById(R.id.score);
                    t13.setText(Integer.toString(count));*/



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
        else{
            wrongVoice.start();
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
