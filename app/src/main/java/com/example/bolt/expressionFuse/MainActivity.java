package com.example.bolt.expressionFuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import com.example.bolt.expression.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button btnClickMe = (Button) findViewById(R.id.button);

        TourGuide mTourGuideHandler = TourGuide.init(this).with(TourGuide.Technique.Click)
                .setPointer(new Pointer())
                .setToolTip(new ToolTip().setTitle("Welcome!").setDescription("Click on Get Started to begin..."))
                .setOverlay(new Overlay())
                .playOn(btnClickMe);

*/

    }


   /* public void cameraClick(final View v) {
        if (v.getId() == R.id.cam) {

            Intent i = new Intent(MainActivity.this, Camera.class);
            startActivity(i);
        }
    }*/


  /*  public void videoClick(final View v) {
        if (v.getId() == vio) {
            ImageButton btnClickMe = (ImageButton) findViewById(vio);

        }
    }*/


    public void level2Click(View v ){
        Intent q = new Intent(MainActivity.this , Game2.class);
        startActivity(q);
    }


    public void level4Click(View v ){
        Intent d = new Intent(MainActivity.this , Game4.class);
        startActivity(d);
    }

    public void level1Click(View v ){
        Intent q = new Intent(MainActivity.this , Game1.class);
        startActivity(q);
    }
    public void level3Click(View v ){
        Intent q = new Intent(MainActivity.this , Game3.class);
        startActivity(q);
    }



    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }

}
