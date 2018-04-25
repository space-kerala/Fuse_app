package com.example.bolt.expressionFuse;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.bolt.expression.R;

public class CustomSwipeAdapter4 extends PagerAdapter{

    private int[] images = { R.drawable.sad1, R.drawable.disgust1, R.drawable.anger1, R.drawable.joy1, R.drawable.cry1,R.drawable.surprise1,R.drawable.smiling1,R.drawable.satisfied1};

    private Context ctx;
    private LayoutInflater lF;;

    public CustomSwipeAdapter4(Context ctx){
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

