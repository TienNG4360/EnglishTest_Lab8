package com.example.lap8;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Text;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by BillGates on 05/05/2017.
 */
public class highscore extends Activity {
    TextView Txt1;
    int HighScore;
    Button Back;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.highscore);
        Txt1 = (TextView)findViewById(R.id.TxtHighscore);
        LoadHighScore();
        Txt1.setText(""+ HighScore);

        Back = (Button) findViewById(R.id.BtnBack);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(highscore.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    void LoadHighScore(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        if (sharedPreferences !=null){
            HighScore = sharedPreferences.getInt("H",0);
        }
    }

}
