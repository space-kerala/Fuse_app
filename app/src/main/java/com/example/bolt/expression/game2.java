package com.example.bolt.expression;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class game2 extends AppCompatActivity {

    private ViewPager viewPager,viewPager2;
    private CustomSwipeAdapter adapter;
    private CustomSwipeAdapter1 adapter2;
    private TextView t11,t12,t13;
    private int pi;
    private int count = 0;
    private String p,q,r;
    private String[] str ={"sad" , "disgust", "anger","joy", "fear"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        viewPager = (ViewPager)findViewById(R.id.viewP);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);

        viewPager2 = (ViewPager)findViewById(R.id.viewP2);
        adapter2 = new CustomSwipeAdapter1(this);
        viewPager2.setAdapter(adapter2);
        setName();

    }

    public void fuse(View v){

        if( q.equals(str[viewPager.getCurrentItem()]) && r.equals(str[viewPager2.getCurrentItem()])){
            setName();
            count+=10;
            t13 = (TextView) findViewById(R.id.score);
            t13.setText(Integer.toString(count));
        }

    }

    public String randomName(){
        pi = new Random().nextInt(str.length);
        p=str[pi];
        return p;
    }

    public void setName(){

        t11 = (TextView) findViewById(R.id.ftv1);
        q=randomName();
        t11.setText(q);

        t12 = (TextView) findViewById(R.id.ftv2);
        r=randomName();
        t12.setText(r);



    }

}
