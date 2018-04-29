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



    }







    public void level4Click(View v ){
        Intent d = new Intent(MainActivity.this , Game4.class);
        startActivity(d);
    }

    public void level1Click(View v ){
        Intent q = new Intent(MainActivity.this , Game1.class);
        startActivity(q);
    }

    public void setExit(View view){

        this.finishAffinity();
    }



    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }

}
