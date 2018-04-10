package com.example.bolt.expression;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomSwipeAdapter extends PagerAdapter{

    private int[] images = { R.drawable.sad, R.drawable.disgust, R.drawable.anger, R.drawable.joy, R.drawable.cry,R.drawable.surprise,R.drawable.smiling,R.drawable.satisfied};

    private Context ctx;
    private LayoutInflater lF;;

    public CustomSwipeAdapter(Context ctx){
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

