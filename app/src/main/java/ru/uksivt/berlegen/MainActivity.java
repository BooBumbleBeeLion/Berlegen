package ru.uksivt.berlegen;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.Alphabet.Alphabet;
import ru.uksivt.berlegen.Courses.Course;
import ru.uksivt.berlegen.Games.Game;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final private static String LOG = MainActivity.class.getSimpleName();

    CheckTime checkTimeAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(LOG, "ActivityMain onCreate called:"+(CheckTime.getInAppPeriod(this)));
        this.checkTimeAds = new CheckTime(this);

        findViewById(R.id.alphabet).setOnClickListener(this);
        findViewById(R.id.course).setOnClickListener(this);
        findViewById(R.id.game).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.alphabet:
                startActivity(new Intent(this, Alphabet.class));
                break;
            case R.id.course:
                startActivity(new Intent(this, Course.class));
                break;
            case R.id.game:
                startActivity(new Intent(this, Game.class));
                break;
            default:
                break;
        }
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void onResume()
    {
        Log.e(LOG, "onResume");
        super.onResume();
        this.checkTimeAds.onResume();
    }

    @Override
    public void onPause()
    {
        Log.e(LOG, "onPause");
        this.checkTimeAds.onPause();
        super.onPause();
    }
}