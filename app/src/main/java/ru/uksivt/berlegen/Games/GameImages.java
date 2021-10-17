package ru.uksivt.berlegen.Games;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.R;

public class GameImages extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameimages);

        findViewById(R.id.backBtn).setOnClickListener(this);
        findViewById(R.id.pribori).setOnClickListener(this);
        findViewById(R.id.semya).setOnClickListener(this);
        findViewById(R.id.domzveri).setOnClickListener(this);
        findViewById(R.id.ferma).setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pribori:
                startActivity(new Intent(this, GameImagesPribori.class));
                break;
            case R.id.semya:
                startActivity(new Intent(this, GameImagesSemya.class));
                break;
            case R.id.domzveri:
                startActivity(new Intent(this, GameImagesZveri.class));
                break;
            case R.id.ferma:
                startActivity(new Intent(this, GameImagesFerma.class));
                break;
            case R.id.backBtn:
                Intent intent = new Intent(this, GameImages.class);
                startActivity(intent);
                break;
        }
    }
    //Системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        Intent intent1 = new Intent(GameImages.this, Game.class);
        startActivity(intent1);
    }
}