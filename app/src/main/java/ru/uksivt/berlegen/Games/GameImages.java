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
        Intent gameTheme = new Intent(this, GameImagesTheme.class);
        switch (v.getId()){
            case R.id.pribori:
                gameTheme.putExtra("title","pribori");
                startActivity(gameTheme);
                break;
            case R.id.semya:
                gameTheme.putExtra("title","semya");
                startActivity(gameTheme);
                break;
            case R.id.domzveri:
                gameTheme.putExtra("title","domzveri");
                startActivity(gameTheme);
                break;
            case R.id.ferma:
                gameTheme.putExtra("title","ferma");
                startActivity(gameTheme);
                break;
            case R.id.backBtn:
                startActivity(new Intent(this, Game.class));
                finish();
                break;
        }
    }
    //Системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        startActivity(new Intent(GameImages.this, Game.class));
    }
}