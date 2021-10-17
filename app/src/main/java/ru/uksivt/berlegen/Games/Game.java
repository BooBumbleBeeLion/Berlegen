package ru.uksivt.berlegen.Games;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.MainActivity;
import ru.uksivt.berlegen.R;

public class Game extends AppCompatActivity {

    //Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ImageButton button_back = (ImageButton) findViewById(R.id.Button_back); // команда для кнопки назад
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Game.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }

    public void OpenActivity1(View view)
    {
        Intent i1 = new Intent(this, GameImages.class);
        startActivity(i1);
    }
    public void OpenActivity2(View view)
    {
        Intent i2 = new Intent(this, GameWords.class);
        startActivity(i2);
    }

    //Системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        Intent intent1 = new Intent(Game.this, MainActivity.class);
        startActivity(intent1);
    }
}