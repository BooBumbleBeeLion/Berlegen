package ru.uksivt.berlegen.Games;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.R;

public class GameImagesPribori extends AppCompatActivity implements View.OnClickListener{

    private boolean isImageScaled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gipribori);

        findViewById(R.id.backBtn).setOnClickListener(this);
        findViewById(R.id.fork).setOnClickListener(this);
        findViewById(R.id.spoon).setOnClickListener(this);
        findViewById(R.id.plate).setOnClickListener(this);
        findViewById(R.id.cup).setOnClickListener(this);
        findViewById(R.id.knife).setOnClickListener(this);
        findViewById(R.id.pot).setOnClickListener(this);
        findViewById(R.id.skillet).setOnClickListener(this);
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
            case R.id.fork:
                break;
            case R.id.spoon:
                break;
            case R.id.plate:
                break;
            case R.id.cup:
                break;
            case R.id.knife:
                break;
            case R.id.pot:
                break;
            case R.id.skillet:
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
    }
}