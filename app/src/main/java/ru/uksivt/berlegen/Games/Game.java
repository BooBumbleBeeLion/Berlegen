package ru.uksivt.berlegen.Games;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.MainActivity;
import ru.uksivt.berlegen.R;
import ru.uksivt.berlegen.RndBackground;

public class Game extends AppCompatActivity implements View.OnClickListener {

    //Random rand = new Random();

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageView main = findViewById(R.id.background);
        main.setImageDrawable(getResources().getDrawable(
                getResources().getIdentifier(RndBackground.random(),"drawable",this.getPackageName())
        ));

        findViewById(R.id.backBtn).setOnClickListener(this);
        findViewById(R.id.GameImages).setOnClickListener(this);
        findViewById(R.id.GameWord).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.GameImages:
                startActivity(new Intent(Game.this, GameImages.class));
                break;
            case R.id.GameWord:
                startActivity(new Intent(Game.this, GameWords.class));
                break;
            case R.id.backBtn:
                startActivity(new Intent(Game.this, MainActivity.class));
                finish();
                break;
            default:
                break;
        }
    }
    //Системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        startActivity(new Intent(Game.this, MainActivity.class));
    }
}