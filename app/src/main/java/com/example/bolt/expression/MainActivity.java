package com.example.bolt.expression;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


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


    public void nameClick(View v ){
        Intent q = new Intent(MainActivity.this , game1.class);
        startActivity(q);
    }


    public void fuseClick(View v ){
        Intent d = new Intent(MainActivity.this , game2.class);
        startActivity(d);
    }
    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }

}
