package com.example.cwnew;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    static String textanswer;
    static int ErrorCount;

    int[] imagecarlist= {
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

    String[] textcarlist= {
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

    String[] maketypes ={
            "bmw",
            "ferrari",
            "nissan",
            "mercedes",
            "audi",
            "lamborghini"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tomain();
        MainTask();


    }

    //----------------------------------------------------------------------------------------------
    private void tomain(){
        Button tomain = (Button) findViewById(R.id.exit3);
        tomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    //----------------------------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------------------
    private void MainTask(){

        EditText userinput = (EditText) findViewById(R.id.userin);
        TextView resultsView = (TextView) findViewById(R.id.resultsView);

        TextView textblock1 = (TextView) findViewById(R.id.hintText1);
        TextView textblock2 = (TextView) findViewById(R.id.hintText2);
        TextView textblock3 = (TextView) findViewById(R.id.hintText3);
        TextView textblock4 = (TextView) findViewById(R.id.hintText4);
        TextView textblock5 = (TextView) findViewById(R.id.hintText5);
        TextView textblock6 = (TextView) findViewById(R.id.hintText6);
        TextView textblock7 = (TextView) findViewById(R.id.hintText7);
        TextView textblock8 = (TextView) findViewById(R.id.hintText8);
        TextView textblock9 = (TextView) findViewById(R.id.hintText9);
        TextView textblock10 = (TextView) findViewById(R.id.hintText10);
        TextView textblock11 = (TextView) findViewById(R.id.hintText11);

        Button SubmitHint = (Button) findViewById(R.id.HintSubmit);


        TextView[] textblocklist = {textblock1,textblock2,textblock3,textblock4,textblock5,textblock6,textblock7,textblock8,textblock9,textblock10,textblock11};
        Random rand=new Random();


        int randnum = rand.nextInt(imagecarlist.length);

        ImageView imgview= (ImageView) findViewById(R.id.carsview2);
        imgview.setImageResource(imagecarlist[randnum]);

        textanswer =textcarlist[randnum];

        textanswer = textanswer.replaceAll("[0123456789]",""); // remove numbers from the car maker string


        for(int i=0 ; i <textanswer.length(); i++){  //to hide the unwanted text view blocks
            textblocklist[i].setVisibility(View.VISIBLE);
        }




        char Randtextin3 =  textanswer.charAt(2);


        SubmitHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userinputhint = userinput.getText().toString();
                String completeword="";





                if(textanswer.contains(userinputhint)) {
                    completeword = "" + userinputhint;

                }


                    if (ErrorCount == 3) {
                        resultsView.setText("WRONG!");
                        resultsView.setBackgroundColor((Color.parseColor("#FF0000")));
                    }
                    if (textanswer.contains(userinputhint)) {
                        int location = textanswer.indexOf(userinputhint);
                        textblocklist[location].setText(userinputhint);
                        completeword = "" + userinputhint;
                    }
                    if (textanswer.contains(userinputhint) == false) {
                        ErrorCount = ErrorCount+1;
                    }






            }
        });



    }




}