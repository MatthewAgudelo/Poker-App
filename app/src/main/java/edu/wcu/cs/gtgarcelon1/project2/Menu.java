package edu.wcu.cs.gtgarcelon1.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author Grant Garcelon
 * This file sets the splash screen and sets the listeners for the main menu buttons
 */
public class Menu extends AppCompatActivity implements View.OnClickListener{

    private boolean keep = true;
    private final int DELAY = 5000;//milliseconds

    private Button nameBtn;
    private Button playBtn;
    private Button viewHandsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Handle the splash screen transition.
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        //Keep returning false to Should Keep On Screen until ready to begin.
        splashScreen.setKeepOnScreenCondition(() -> keep);
        Handler handler = new Handler();
        handler.postDelayed(() -> keep = false, DELAY);

        setContentView(R.layout.activity_main);

        nameBtn = findViewById(R.id.name_btn);
        playBtn = findViewById(R.id.play_btn);
        viewHandsBtn = findViewById(R.id.view_hands_btn);

        nameBtn.setOnClickListener(this);
        playBtn.setOnClickListener(this);
        viewHandsBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        if (view == nameBtn) {
            intent = new Intent(this, PlayerName.class);
        } else if (view == playBtn) {
            intent = new Intent(this, Game.class);
        } else if (view == viewHandsBtn) {
            intent = new Intent(this, WinList.class);
        } else {
            Toast.makeText(
                getApplicationContext(),
                "Unknown Action",
                Toast.LENGTH_SHORT
            ).show();
        }
        startActivity(intent);
    }
}