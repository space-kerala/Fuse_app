package com.example.bolt.expression;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FuseGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuse_game);
    }

    public void fuseClick(View v){

        Intent g = new Intent(FuseGame.this , game2.class);
        startActivity(g);
    }
    public void setExit(View view){

        this.finishAffinity();
    }
    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}
