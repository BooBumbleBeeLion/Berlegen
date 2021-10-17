package ru.uksivt.berlegen.Games;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.R;

public class GameImagesZveri extends AppCompatActivity implements View.OnClickListener {

    private boolean isImageScaled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gizvery);

        findViewById(R.id.backBtn).setOnClickListener(this);
        findViewById(R.id.dog).setOnClickListener(this);
        findViewById(R.id.cat).setOnClickListener(this);
        findViewById(R.id.parrot).setOnClickListener(this);
        findViewById(R.id.hamster).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!isImageScaled){
            isImageScaled = true;
            v.animate().scaleX(1.4f).scaleY(1.4f).setDuration(500);

            //задержка для анимации
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    v.animate().scaleX(1f).scaleY(1f).setDuration(500);
                    isImageScaled = false;
                }
            }, 1000);
        }
        switch (v.getId()){
            case R.id.dog:
                break;
            case R.id.cat:
                break;
            case R.id.parrot:
                break;
            case R.id.hamster:
                break;
            case R.id.backBtn:
                Intent intent = new Intent(this, GameImages.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, GameImages.class);
        startActivity(intent);
    }}