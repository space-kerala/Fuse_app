package com.example.bolt.expressionFuse;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.bolt.expression.R;

import java.util.ArrayList;
import java.util.Random;

import android.content.Intent;
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

import com.example.bolt.expression.R;

import java.util.ArrayList;
import java.util.Random;

public class Game1 extends AppCompatActivity {

    private ViewPager viewPager,viewPager2;
    private CustomSwipeAdapter4 adapter;
    private CustomSwipeAdapter1 adapter2;
    private TextView t11,t12,t13,textView,level,right,wrong;
    private int pi,temp=1,ran;
    private int count = 0,x=0;
    private String p,q,r;
    private String[] str ={"വിഷമം" , "വെറുപ്പ്", "ദേഷ്യം","ആനന്ദം", "കരച്ചിൽ","അത്ഭുതം","പുഞ്ചിരി","തൃപ്തി"};
    private Animation shake;
    private ArrayList<Integer> sounds;
    private MediaPlayer wrongVoice,mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4);

        t11 = (TextView) findViewById(R.id.ftv1);
        // t12 = (TextView) findViewById(R.id.ftv2);
        t13 = (TextView) findViewById(R.id.score);
        level = (TextView) findViewById(R.id.levelNo_id);
        textView = (TextView)findViewById(R.id.textView);
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        mediaPlayer = MediaPlayer.create(this,R.raw.alternative_correct);
        wrongVoice = MediaPlayer.create(this, R.raw.wrong);

        right = (TextView) findViewById(R.id.rightNo_id);
        wrong = (TextView) findViewById(R.id.wrongNo_id);

        viewPager = (ViewPager)findViewById(R.id.viewP);
        adapter = new CustomSwipeAdapter4(this);
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

        setName();

        /*viewPager2 = (ViewPager)findViewById(R.id.viewP2);
        adapter2 = new CustomSwipeAdapter1(this);
        viewPager2.setAdapter(adapter2);
        viewPager2.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                *//*final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setScaleX(normalizedposition / 2 + 0.5f);
                page.setScaleY(normalizedposition / 2 + 0.5f);*//*
                page.setRotationY(position * -30);
            }
        });
        setName();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots1);
        tabLayout.setupWithViewPager(viewPager2, true);*/

        sounds = new ArrayList<>();
        sounds.add(R.raw.correct1);
        sounds.add(R.raw.correct2);
        sounds.add(R.raw.correct3);
        sounds.add(R.raw.correct4);
        sounds.add(R.raw.correct5);
        sounds.add(R.raw.correct6);

    }

    public void fuse(View v){



        if( q.equals(str[viewPager.getCurrentItem()]) ){

            SceneTracker.setCorrectedItem((SceneTracker.getCorrectedItem()+1));

            right.setText(String.valueOf(SceneTracker.getCorrectedItem()));

            if(temp==10){
                SceneTracker.setLevel(2);
                Intent intent = new Intent(this,nameGame.class);
                startActivity(intent);
            }
            else {

                SceneTracker.setLevel(1);

                if(x!=1) {


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
                                    ran = new Random().nextInt(str.length);
                                    viewPager.setCurrentItem(ran);
                                    count += 10;
                                    x=0;
                                    t13.setText(Integer.toString(count));
                                    temp++;
                                    level.setText(String.valueOf(temp));
                                }
                            });
                        }
                    });


                   /* setName();
                    count+=10;
                    t13 = (TextView) findViewById(R.id.score);
                    t13.setText(Integer.toString(count));*/


                    t11.setTextColor(Color.GREEN);
                    // t12.setTextColor(Color.GREEN);
                    t13.setTextColor(Color.GREEN);
                    textView.setTextColor(Color.GREEN);
                    new CountDownTimer(1000, 1000) {

                        @Override
                        public void onTick(long arg0) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onFinish() {

                            t11.setTextColor(Color.WHITE);
                            // t12.setTextColor(Color.WHITE);
                            t13.setTextColor(Color.GRAY);
                            textView.setTextColor(Color.GRAY);
                        }
                    }.start();
                    x=1;
                }

            }

        }
        else{
            SceneTracker.setWrongItem((SceneTracker.getWrongItem()+1));
            wrong.setText(String.valueOf(SceneTracker.getWrongItem()));
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


       /* r=randomName();
        t12.setText(r);*/



    }
    public void setHome(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

}
