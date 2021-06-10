package com.example.cwnew;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity4 extends AppCompatActivity {


    static String Question;


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
            "audi1",  //1
            "audi2",  //2
            "audi3",  //3
            "audi4", //4
            "audi5",//5
            "audi6",//6

            "mercedes1",//7
            "mercedes2",//8
            "mercedes3",//9
            "mercedes4",//10

            "bmw1",//11
            "bmw2",//12
            "bmw3",//13
            "bmw4",//14
            "bmw5",//15
            "bmw6",//16

            "ferrari1",//17
            "ferrari2",//18
            "ferrari3",//19

            "lamborghini1",//20
            "lamborghini2",//21
            "lamborghini3",//22
            "lamborghini4",//23

            "nissan1",//24
            "nissan2",//25
            "nissan3",//26
            "nissan4"//27
    };



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tomain();
        MainTask();
    }



    private void tomain(){
        Button tomain = (Button) findViewById(R.id.exit4);
        tomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void MainTask() {

        //calling the image buttons from the xml
        ImageButton ImageButton1 = (ImageButton) findViewById(R.id.buttonImage1);
        ImageButton ImageButton2 = (ImageButton) findViewById(R.id.buttonImage2);
        ImageButton ImageButton3 = (ImageButton) findViewById(R.id.buttonImage3);

        TextView Questionview = (TextView) findViewById(R.id.QuestionView);
        TextView Feedback = (TextView) findViewById(R.id.FeedBackView);

        Button submit= (Button) findViewById(R.id.Submit);

        Random rand = new Random();


        int rand1;//to store the random numbers
        int rand2;
        int rand3;


        rand1 = rand.nextInt(11);  //generating random numbers
        rand2 = rand.nextInt(20-11)+11;
        rand3 = rand.nextInt(28-20)+20;



        ImageButton1.setImageResource(imagecarlist[rand1-1]);  //adding the random images to the buttons
        ImageButton2.setImageResource(imagecarlist[rand2-1]);
        ImageButton3.setImageResource(imagecarlist[rand3-1]);


        int[] QuestionCarMakeAray={rand1,rand2,rand3};
        int question= QuestionCarMakeAray[rand.nextInt(3)]; //selecting a random car company for the array for a question
        question=question-1;
        Question=textcarlist[question]; //getting a random car company name


        Question = Question.replaceAll("[0123456789]",""); //removing the numbers from the car names

        Questionview.setText("What is the car of the company : "+Question+" ?"); //adding the Question to the question view




        //------------------------------------------------------------------------------------------
        int finalRand = rand1;
        ImageButton1.setOnClickListener(new View.OnClickListener(){  //first image button
            @Override
            public void onClick(View v) {
             String textanswer = textcarlist[finalRand-1].replaceAll("[0123456789]","");
             if(textanswer.equals(Question)){
                 Feedback.setText("CORRECT");
                 Feedback.setBackgroundColor(Color.parseColor("#00FF00"));
             }
             else {
                 Feedback.setText("WRONG!");
                 Feedback.setBackgroundColor(Color.parseColor("#FF0000"));
             }
             submit.setText("NEXT");


            }

        });


        //------------------------------------------------------------------------------------------
        int finalRand1 = rand2;
        ImageButton2.setOnClickListener(new View.OnClickListener(){ //second image button
            @Override
            public void onClick(View v) {
                String textanswer = textcarlist[finalRand1-1].replaceAll("[0123456789]","");
                if(textanswer.equals(Question)){
                    Feedback.setText("CORRECT");
                    Feedback.setBackgroundColor(Color.parseColor("#00FF00"));
                }
                else {
                    Feedback.setText("WRONG!");
                    Feedback.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                submit.setText("NEXT");

            }
        });


        //------------------------------------------------------------------------------------------
        int finalRand2 = rand3;
        ImageButton3.setOnClickListener(new View.OnClickListener(){ //third image button
            @Override
            public void onClick(View v) {
                String textanswer = textcarlist[finalRand2-1].replaceAll("[0123456789]","");
                if(textanswer.equals(Question)){
                    Feedback.setText("CORRECT");
                    Feedback.setBackgroundColor(Color.parseColor("#00FF00"));

                }
                else {
                    Feedback.setText("WRONG!");
                    Feedback.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                submit.setText("NEXT");

            }
        });

        //------------------------------------------------------------------------------------------
        submit.setOnClickListener(new View.OnClickListener() {  //quit button to close the activity
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(MainActivity4.this, MainActivity4.class));
            }
        });



    }
}