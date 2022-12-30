package com.example.lab5;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
       ProgressBar bar=findViewById(R.id.progressBar);
        AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
        bar.setVisibility(View.GONE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            builder.setMessage("Do you want to run a progress bar ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    bar.setIndeterminate(true);
                    bar.setVisibility(View.VISIBLE);

                    Handler handler = new Handler(getMainLooper());

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            bar.setVisibility(View.GONE);
                        }
                    },1000);



                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    bar.setVisibility(View.GONE);
                }
            });


                AlertDialog alert= builder.create();
                alert.setTitle("HEllo");




            }
        });






    }
}