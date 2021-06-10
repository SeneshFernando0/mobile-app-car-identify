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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity5 extends AppCompatActivity {

    static String Answer1;
    static String Answer2;
    static String Answer3;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        MainTask();

    }
    //----------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------
    private void MainTask(){
        ImageView Imageview1 = (ImageView) findViewById(R.id.imageView1);
        ImageView Imageview2 = (ImageView) findViewById(R.id.imageView2);
        ImageView Imageview3 = (ImageView) findViewById(R.id.imageView3);

        EditText UserInput1 = (EditText) findViewById(R.id.UserInput1);
        EditText UserInput2 = (EditText) findViewById(R.id.UserInput2);
        EditText UserInput3 = (EditText) findViewById(R.id.UserInput3);

        TextView resultview = (TextView) findViewById(R.id.results5);
        Button SubmitButton = (Button) findViewById(R.id.Submit);




        Random rand = new Random();


        int rand1;//to store the random numbers
        int rand2;
        int rand3;


        rand1 = rand.nextInt(11);  //generating random numbers
        rand2 = rand.nextInt(20-11)+11;
        rand3 = rand.nextInt(28-20)+20;



        Imageview1.setImageResource(imagecarlist[rand1-1]);  //adding the random images to the image views
        Imageview2.setImageResource(imagecarlist[rand2-1]);
        Imageview3.setImageResource(imagecarlist[rand3-1]);

        Answer1 = textcarlist[rand1-1];
        Answer2 = textcarlist[rand2-1];
        Answer3 = textcarlist[rand3-1];



        Answer1= Answer1.replaceAll("[0123456789]",""); //clear the answers of any numbers
        Answer2= Answer2.replaceAll("[0123456789]","");
        Answer3= Answer3.replaceAll("[0123456789]","");




        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Userdata1=UserInput1.getText().toString();
                String Userdata2=UserInput2.getText().toString();
                String Userdata3=UserInput3.getText().toString();


                if(Userdata1.equals(Answer1)){
                    UserInput1.setBackgroundColor(Color.parseColor("#00FF00"));
                    UserInput1.setKeyListener(null);



                }
                else{
                    UserInput1.setBackgroundColor(Color.parseColor("#FF0000"));
                }

                if(Userdata2.equals(Answer2)){
                    UserInput2.setBackgroundColor(Color.parseColor("#00FF00"));
                    UserInput2.setKeyListener(null);


                }
                else{
                    UserInput2.setBackgroundColor(Color.parseColor("#FF0000"));
                }

                if(Userdata3.equals(Answer3)){
                    UserInput3.setBackgroundColor(Color.parseColor("#00FF00"));
                    UserInput3.setKeyListener(null);


                }
                else{
                    UserInput3.setBackgroundColor(Color.parseColor("#FF0000"));
                }


                if((Userdata1.equals(Answer1))&&(Userdata2.equals(Answer2))&&(Userdata3.equals(Answer3))){
                    SubmitButton.setText("NEXT");

                    resultview.setText("CORRECT!");
                    resultview.setBackgroundColor(Color.parseColor("#00FF00"));

                    SubmitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent =new Intent(MainActivity5.this,MainActivity5.class);
                            startActivity(intent);
                        }
                    });
                }


            }
        });

    }

//--------------------------------------------------------------------------------------------------
    public void exit(View view) {  //exit button method
        finish();
        Intent intent =new Intent(MainActivity5.this,MainActivity.class);
        startActivity(intent);
    }

}