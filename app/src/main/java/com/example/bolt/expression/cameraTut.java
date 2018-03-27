package com.example.bolt.expression;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

public class cameraTut extends AppCompatActivity {

    public TourGuide mTutorialHandler;
    public Activity mActivity;
    public ImageButton imgCamera;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_camera_tut);
        final ImageButton button = (ImageButton)findViewById(R.id.iBcapture);
        final ImageButton button2 = (ImageButton)findViewById(R.id.iBsettings);
        final ImageButton button3 = (ImageButton)findViewById(R.id.iBchange);
        final Button button4 = (Button)findViewById(R.id.captureBtn2);
        final ImageButton button6 = (ImageButton)findViewById(R.id.captureBtn3);
        final ImageButton button5 = (ImageButton)findViewById(R.id.flashBtn);
        /* setup enter and exit animation */
        final Animation enterAnimation = new AlphaAnimation(0f, 1f);
        enterAnimation.setDuration(400);
        enterAnimation.setFillAfter(true);

        final Animation exitAnimation = new AlphaAnimation(1f, 0f);
        exitAnimation.setDuration(400);
        exitAnimation.setFillAfter(true);

        /* initialize TourGuide without playOn() */
        mTutorialHandler = TourGuide.init(this).with(TourGuide.Technique.Click)
                //.setPointer(new Pointer())
                /*.setToolTip(new ToolTip()
                        //.setTitle("")
                       // .setDescription("Click this Button to start your tutorial")
                        .setGravity(Gravity.BOTTOM)
                )*/
                /*.setOverlay(new Overlay()
                        .setEnterAnimation(enterAnimation)
                        .setExitAnimation(exitAnimation)
                )*/;

        /* setup 1st button, when clicked, cleanUp() and re-run TourGuide on button2 */
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mTutorialHandler.cleanUp();
                mTutorialHandler.setToolTip(new ToolTip().setTitle("Capture Button").setDescription("This button when clicked captures images").setGravity(Gravity.TOP));
                mTutorialHandler.setOverlay( new Overlay().setEnterAnimation(enterAnimation).setExitAnimation(exitAnimation));
                mTutorialHandler.setPointer(new Pointer().setColor(Color.RED));
                mTutorialHandler.playOn(button);
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mTutorialHandler.cleanUp();
                mTutorialHandler.setToolTip(new ToolTip().setTitle("Change Button").setDescription("Used to toggle between front/back camera").setGravity(Gravity.TOP));
                mTutorialHandler.setOverlay( new Overlay().setEnterAnimation(enterAnimation).setExitAnimation(exitAnimation));
                mTutorialHandler.setPointer(new Pointer().setColor(Color.WHITE));
                mTutorialHandler.playOn(button2);
            }
        });

        /* setup 2nd button, when clicked, cleanUp() and re-run TourGuide on button3 */
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mTutorialHandler.cleanUp();
                mTutorialHandler.setToolTip(new ToolTip().setTitle("Settings Button").setDescription("Used to change the Settings of the image").setGravity(Gravity.TOP));
                mTutorialHandler.setOverlay( new Overlay().setEnterAnimation(enterAnimation).setExitAnimation(exitAnimation));
                mTutorialHandler.setPointer(new Pointer().setColor(Color.WHITE));
                mTutorialHandler.playOn(button3);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mTutorialHandler.cleanUp();
                mTutorialHandler.setToolTip(new ToolTip().setTitle("Flash Button").setDescription("Use to toggle between flash light(On/Off/Automatic)").setGravity(Gravity.BOTTOM));
                mTutorialHandler.setOverlay( new Overlay().setEnterAnimation(enterAnimation).setExitAnimation(exitAnimation));
                mTutorialHandler.setPointer(new Pointer().setColor(Color.WHITE));
                mTutorialHandler.playOn(button5);

            }
        });

        /*button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mTutorialHandler.cleanUp();
                mTutorialHandler.setToolTip(new ToolTip().setDescription("CLICK on CAMERA to open camera CLICK on START to Go through the tutorial once more").setGravity(Gravity.BOTTOM));
                mTutorialHandler.setOverlay( new Overlay().setEnterAnimation(enterAnimation).setExitAnimation(exitAnimation));
                //mTutorialHandler.setPointer(new Pointer().setColor(Color.BLACK));
                mTutorialHandler.playOn(button6);
            }
        });

        /* setup 3rd button, when clicked, run cleanUp() */
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mTutorialHandler.cleanUp();
                TextView tv1 = (TextView)findViewById(R.id.tv1);
                tv1.setText("Click on CAMERA to start taking picture");
                TextView tv = (TextView)findViewById(R.id.tv2);
                tv.setText("Click on START to Use the tutorial again");
            }
        });

        mTutorialHandler.playOn(button4);

        imgCamera = (ImageButton) findViewById(R.id.captureBtn3);

        // capImage= (ImageView) findViewById(R.id.capturePic);

        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
    }

    private void openCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }



   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            capImage.setImageBitmap(bp);
        }
    } */

    //@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

