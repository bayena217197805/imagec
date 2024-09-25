package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private float x,y;
    Thread thread;
    TextView textView;
    int level=1000,counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.emojy);
        textView=findViewById(R.id.text1);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
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

    private void startMoveImage() {
        x=(float) Math.random()*800;
        y=(float) Math.random()*1600;
        image.setX(x);
        image.setY(y);

    }
}