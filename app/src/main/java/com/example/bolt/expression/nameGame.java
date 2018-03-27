package com.example.bolt.expression;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class nameGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_game);
    }





    public void startGame(View v ){
        Intent f = new Intent(nameGame.this , game1.class);
        startActivity(f);
    }
}
