package com.example.bolt.expressionFuse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bolt.expression.R;

public class nameGame extends AppCompatActivity {
    public static TextView right,wrong,levelText,accuracy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_game);

        right = (TextView) findViewById(R.id.rightNo_id);
        wrong = (TextView) findViewById(R.id.wrongNo_id);
        levelText = (TextView) findViewById(R.id.levelNo_id) ;
        accuracy = (TextView)findViewById(R.id.accuracyNo_id) ;

        wrong.setText(String.valueOf(SceneTracker.getWrongItem()));
        right.setText(String.valueOf(SceneTracker.getCorrectedItem()));
        int a = SceneTracker.getWrongItem();
        int b = SceneTracker.getCorrectedItem();
        int c = a+b;
        int x = (int) (((double) b / (double) c) * 100);
        accuracy.setText(String.valueOf(x));

    }
    public void startGame(View v ){

        switch (SceneTracker.getLevel()){

            case 2:
                SceneTracker.setCorrectedItem(0);
                SceneTracker.setWrongItem(0);
                SceneTracker.setLevel(SceneTracker.getLevel()-1);

                Intent f = new Intent(nameGame.this , Game1.class);
                startActivity(f);
                break;
            case 3 :
                SceneTracker.setCorrectedItem(0);
                SceneTracker.setWrongItem(0);
                SceneTracker.setLevel(SceneTracker.getLevel()-1);
                Intent i = new Intent(nameGame.this , Game2.class);
                startActivity(i);
                break;
            case 4 :
                SceneTracker.setCorrectedItem(0);
                SceneTracker.setWrongItem(0);
                SceneTracker.setLevel(SceneTracker.getLevel()-1);
                Intent e = new Intent(nameGame.this , Game3.class);
                startActivity(e);
                break;


        }

    }


    public void nextGame(View v ){

        switch (SceneTracker.getLevel()){

            case 2:
                     SceneTracker.setCorrectedItem(0);
                     SceneTracker.setWrongItem(0);

                     Intent f = new Intent(nameGame.this , Game2.class);
                     startActivity(f);
                     break;
            case 3 :
                    SceneTracker.setCorrectedItem(0);
                    SceneTracker.setWrongItem(0);
                    Intent i = new Intent(nameGame.this , Game3.class);
                    startActivity(i);
                    break;
            case 4 :
                   SceneTracker.setCorrectedItem(0);
                   SceneTracker.setWrongItem(0);
                   Intent e = new Intent(nameGame.this , Game4.class);
                   startActivity(e);
                   break;


        }

    }
    public void setExit(View view){

        SceneTracker.setCorrectedItem(0);
        SceneTracker.setWrongItem(0);
        SceneTracker.setLevel(1);

        Intent f = new Intent(nameGame.this , MainActivity.class);
        startActivity(f);
    }
    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}
