package com.example.bolt.expression;

/**
 * Created by root on 2/4/18.
 */


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomSwipeAdapter1 extends PagerAdapter{

    private int[] images = { R.raw.sad, R.raw.disgust, R.raw.anger, R.raw.joy , R.raw.cry,R.raw.surprise,R.raw.smiling,R.raw.satisfied};

    private Context ctx;
    private LayoutInflater lF;;

    public CustomSwipeAdapter1(Context ctx){
        this.ctx=ctx;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == ((LinearLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        lF=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = lF.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView)item.findViewById(R.id.fiv2);
        imageView.setImageResource(images[position]);
        container.addView(item);
        return item;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}

