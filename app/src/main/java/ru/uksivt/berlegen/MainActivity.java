package ru.uksivt.berlegen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.Alphabet.Alphabet;
import ru.uksivt.berlegen.Games.Game;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void OpenActivity1(View view) {
        Intent i1 = new Intent(this, Alphabet.class);
        startActivity(i1);
    }


    public void OpenActivity2(View view) {
        Intent i2 = new Intent(this, kurs.class);
        startActivity(i2);
    }


    public void OpenActivity3(View view) {
        Intent i3 = new Intent(this, phrasebook.class);
        startActivity(i3);
    }

    public void OpenActivity4(View view) {
        Intent i4 = new Intent(this, Game.class);
        startActivity(i4);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}