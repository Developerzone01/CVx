package com.ibrahimyousre.resumebuilder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread td = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(SplashActivity.this, "Unknown error occured", Toast.LENGTH_LONG).show();
                }
                finally {
                    Intent i = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(i);
                }
            }
        };
        td.start();
    }
}
