package com.plsr.sunil.launchscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    //https://antonioleiva.com/branded-launch-screen/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Below line of code will remove the launch screen and displays the main activity with its original theme
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
