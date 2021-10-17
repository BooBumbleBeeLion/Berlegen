package ru.uksivt.berlegen.Games;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.R;

public class GameImagesSemya extends AppCompatActivity implements View.OnClickListener {

    private boolean isImageScaled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gisemya);

        findViewById(R.id.backBtn).setOnClickListener(this);
        findViewById(R.id.bigBro).setOnClickListener(this);
        findViewById(R.id.mother).setOnClickListener(this);
        findViewById(R.id.grandMother).setOnClickListener(this);
        findViewById(R.id.father).setOnClickListener(this);
        findViewById(R.id.smallSister).setOnClickListener(this);
        findViewById(R.id.smallBro).setOnClickListener(this);
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
            case R.id.bigBro:
                break;
            case R.id.mother:
                break;
            case R.id.grandMother:
                break;
            case R.id.father:
                break;
            case R.id.smallSister:
                break;
            case R.id.smallBro:
                break;
            case R.id.backBtn:
                Intent intent = new Intent(this, GameImages.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    //Системная кнопка "назад" - начало
    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent(this, GameImages.class);
        startActivity(intent1);
    }}