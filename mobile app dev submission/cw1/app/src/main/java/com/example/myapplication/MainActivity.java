package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;


class mainbuttonwindow extends AppCompatActivity {

    private Scene scene1;
    private Scene scene2;
    private Scene scene3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainbuttonwindow);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            scene1 = Scene.getSceneForLayout((ViewGroup)findViewById(R.id.rootcointainer), R.layout.mainbuttonwindow, this);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            scene2 = Scene.getSceneForLayout((ViewGroup)findViewById(R.id.rootcointainer), R.layout.activity_main, this);
        }

    }




    public void onclick1(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.go(scene2);
        }

    }

    public void onclick2(View view) {


    }
}