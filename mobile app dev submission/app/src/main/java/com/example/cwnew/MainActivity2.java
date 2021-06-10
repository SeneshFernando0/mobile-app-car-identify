package com.example.cwnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;


public class MainActivity2 extends AppCompatActivity {

    public ImageView imgcar;

    //the drawable array car pictures
    int[] imagecarlist = {
            R.drawable.audi1,
            R.drawable.audi2,
            R.drawable.audi3,
            R.drawable.audi4,
            R.drawable.audi5,
            R.drawable.audi6,

            R.drawable.mercedes1,
            R.drawable.mercedes2,
            R.drawable.mercedes3,
            R.drawable.mercedes4,

            R.drawable.bmw1,
            R.drawable.bmw2,
            R.drawable.bmw3,
            R.drawable.bmw4,
            R.drawable.bmw5,
            R.drawable.bmw6,

            R.drawable.ferrari1,
            R.drawable.ferrari2,
            R.drawable.ferrari3,

            R.drawable.lamborghini1,
            R.drawable.lamborghini2,
            R.drawable.lamborghini3,
            R.drawable.lamborghini4,

            R.drawable.nissan1,
            R.drawable.nissan2,
            R.drawable.nissan3,
            R.drawable.nissan4
    };

    String[] textcarlist = {
            "audi1",
            "audi2",
            "audi3",
            "audi4",
            "audi5",
            "audi6",

            "mercedes1",
            "mercedes2",
            "mercedes3",
            "mercedes4",

            "bmw1",
            "bmw2",
            "bmw3",
            "bmw4",
            "bmw5",
            "bmw6",

            "ferrari1",
            "ferrari2",
            "ferrari3",

            "lamborghini1",
            "lamborghini2",
            "lamborghini3",
            "lamborghini4",

            "nissan1",
            "nissan2",
            "nissan3",
            "nissan4"
    };

    static String textanswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tomain(); //launching exit to main menue method
        randomimage(); //random image generate method
        identify(); //identify image method
    }
    //----------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------
    private void tomain() {
        Button tomain = (Button) findViewById(R.id.buttonback);
        tomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    private void randomimage() {


        Random rand = new Random();

        int randnum = rand.nextInt(imagecarlist.length);

        ImageView imgview = (ImageView) findViewById(R.id.carsview);
        imgview.setImageResource(imagecarlist[randnum]);

        textanswer = textcarlist[randnum];
    }
    //----------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------
    private void identify() {

        Button identify = (Button) findViewById(R.id.identify);
        identify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinnerDropdown = (Spinner) findViewById(R.id.CarSelect);
                String spinnerAnswer = spinnerDropdown.getSelectedItem().toString();
                spinnerAnswer = spinnerAnswer.toLowerCase();

                char SpinnerLetterAnswer = spinnerAnswer.charAt(1);
                char textLetterAnswer = textanswer.charAt(1);


                if (SpinnerLetterAnswer == (textLetterAnswer)) {
                    TextView resultwindow = (TextView) findViewById(R.id.textViewResult);
                    resultwindow.setText("CORRECT");
                    resultwindow.setBackgroundColor(Color.parseColor("#00FF00"));
                } else {
                    TextView resultwindow = (TextView) findViewById(R.id.textViewResult);
                    resultwindow.setText("WRONG!");
                    resultwindow.setBackgroundColor(Color.parseColor("#FF0000"));

                    TextView resultwindow2 = (TextView) findViewById(R.id.textViewResult2);
                    resultwindow2.setText("The correct answer is : " + textanswer);
                }

                identify.setText("next");
                identify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                        Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                        startActivity(intent);
                    }
                });


            }
        });

    }
    //----------------------------------------------------------------------------------------------
}


