package com.example.cwnew;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private long Seconds= TimeUnit.MILLISECONDS.toSeconds(20000);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toCarMake();
        tocarImage();
        toHint();
        ToAdvancedLevel();
        Timer();




    }

    //----------------------------------------------------------------------------------------------
    private void toCarMake(){ //method to car maker scene

        Button ToqQuizScene = (Button) findViewById(R.id.toscene2);
        ToqQuizScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
        });
    }
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    private void toHint(){ //to hint scene

        Button ToHintScene = (Button) findViewById(R.id.toscene3);
        ToHintScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    private void  tocarImage(){ //to car image guss scene

        Button CarImageScene = (Button) findViewById(R.id.toscene4);
        CarImageScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,MainActivity4.class);
                startActivity(intent);
            }
        });
    }
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    public void ToAdvancedLevel(){ //to advanced level scene
        Button AdvancedLevelScene = (Button) findViewById(R.id.toscene5);
        AdvancedLevelScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,MainActivity5.class);
                startActivity(intent);
            }
        });
    }
    //----------------------------------------------------------------------------------------------

    private void Timer(){
        Switch timer = (Switch) findViewById(R.id.CountdownSwitch);
        TextView display = (TextView) findViewById(R.id.timer);

        timer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    new CountDownTimer(20000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            display.setText("sec: " + millisUntilFinished / 1000);
                        }

                        public void onFinish() {

                        }
                    }.start();
                }
            }
        });
    }



}