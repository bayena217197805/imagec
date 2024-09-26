package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private float x,y;
    Thread thread;
    TextView textView;
    int level=3000,counter=0,wichlevel=0;
    RadioButton radioe,radioa,radiod;
    Button button;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.emojy);
        textView=findViewById(R.id.text1);
        radioe=findViewById(R.id.radioe);
        radioa=findViewById(R.id.radioa);
        radiod=findViewById(R.id.radiod);
        button=findViewById(R.id.stop);


        radioe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wichlevel=1;
                level=2000;
            }
        });
        radioa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wichlevel=2;
                level=1000;
            }
        });
        radiod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wichlevel=3;
                level=600;
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter=counter+wichlevel;
                textView.setText(counter+"");

            }
        });

    }
    public void startp(View view){
        thread=new Thread(()->{
            try {
                while (true){
                    startMoveImage();
                    Thread.sleep(level);
                }
            }
            catch (Exception e){

            }
        });
        thread.start();
    }
    public void stopp(View view){
        thread.interrupt();
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Total Points")
                .setMessage(String.valueOf(counter))
                .setPositiveButton("OK", null)
                .create();
        dialog.show();
        counter=0;
        textView.setText(0+"");


    }

    private void startMoveImage() {
        x=(float) Math.random()*800;
        y=(float) Math.random()*1600;
        image.setX(x);
        image.setY(y);

    }
}