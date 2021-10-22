package ru.uksivt.berlegen.Games;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.MainActivity;
import ru.uksivt.berlegen.R;

public class Game extends AppCompatActivity implements View.OnClickListener {

    //Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        findViewById(R.id.backBtn).setOnClickListener(this);
        findViewById(R.id.images).setOnClickListener(this);
        findViewById(R.id.words).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.images:
                startActivity(new Intent(Game.this, GameImages.class));
                break;
            case R.id.words:
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