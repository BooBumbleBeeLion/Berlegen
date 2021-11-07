package ru.uksivt.berlegen.Games;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.R;

public class GameImagesTheme extends AppCompatActivity implements View.OnClickListener {

    private boolean isImageScaled = false;
    boolean playing = true, nowPlay = false;
    int rawBash = 0, rawRus = 0, countBash = 0, countRus = 0;
    int[] sounds;
    int index;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (getIntent().getStringExtra("title")) {
            case "pribori":
                setContentView(R.layout.activity_gipribori);
                findViewById(R.id.fork).setOnClickListener(this);
                findViewById(R.id.spoon).setOnClickListener(this);
                findViewById(R.id.plate).setOnClickListener(this);
                findViewById(R.id.cup).setOnClickListener(this);
                findViewById(R.id.knife).setOnClickListener(this);
                findViewById(R.id.pot).setOnClickListener(this);
                findViewById(R.id.skillet).setOnClickListener(this);
                break;
            case "semya":
                setContentView(R.layout.activity_gisemya);
                findViewById(R.id.father).setOnClickListener(this);
                findViewById(R.id.mother).setOnClickListener(this);
                findViewById(R.id.grandMother).setOnClickListener(this);
                findViewById(R.id.grandFather).setOnClickListener(this);
                findViewById(R.id.smallSister).setOnClickListener(this);
                findViewById(R.id.smallBro).setOnClickListener(this);
                break;
            case "domzveri":
                setContentView(R.layout.activity_gizvery);
                findViewById(R.id.dog).setOnClickListener(this);
                findViewById(R.id.cat).setOnClickListener(this);
                findViewById(R.id.parrot).setOnClickListener(this);
                findViewById(R.id.hamster).setOnClickListener(this);
                break;
            case "ferma":
                setContentView(R.layout.activity_giferma);
                findViewById(R.id.cow).setOnClickListener(this);
                findViewById(R.id.pig).setOnClickListener(this);
                findViewById(R.id.goat).setOnClickListener(this);
                findViewById(R.id.chicken).setOnClickListener(this);
                findViewById(R.id.goose).setOnClickListener(this);
                break;
        }
        findViewById(R.id.backBtn).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (!isImageScaled && !nowPlay) {
            isImageScaled = true;
            v.animate().scaleX(1.4f).scaleY(1.4f).setDuration(500);

            //задержка для анимации
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    v.animate().scaleX(1f).scaleY(1f).setDuration(500);
                    isImageScaled = false;
                }
            }, 2000);

            switch (v.getId()) {
                // Картинки Приборов
                case R.id.fork:
                    countBash = 1;
                    countRus = 1;
                    break;
                case R.id.spoon:
                    countBash = 2;
                    countRus = 2;
                    break;
                case R.id.plate:
                    countBash = 3;
                    countRus = 3;
                    break;
                case R.id.cup:
                    countBash = 4;
                    countRus = 4;
                    break;
                case R.id.knife:
                    countBash = 5;
                    countRus = 5;
                    break;
                case R.id.pot:
                    countBash = 6;
                    countRus = 6;
                    break;
                case R.id.skillet:
                    countBash = 7;
                    countRus = 7;
                    break;
                // Картинки Семьи
                case R.id.father:
                    countBash = 8;
                    countRus = 8;
                    break;
                case R.id.mother:
                    countBash = 9;
                    countRus = 9;
                    break;
                case R.id.grandMother:
                    countBash = 10;
                    countRus = 10;
                    break;
                case R.id.grandFather:
                    countBash = 11;
                    countRus = 11;
                    break;
                case R.id.smallSister:
                    countBash = 12;
                    countRus = 12;
                    break;
                case R.id.smallBro:
                    countBash = 13;
                    countRus = 13;
                    break;
                // Картинки Зверей
                case R.id.dog:
                    countBash = 14;
                    countRus = 14;
                    break;
                case R.id.cat:
                    countBash = 15;
                    countRus = 15;
                    break;
                case R.id.parrot:
                    countBash = 16;
                    countRus = 16;
                    break;
                case R.id.hamster:
                    countBash = 17;
                    countRus = 17;
                    break;
                // Картинки Фермы
                case R.id.cow:
                    countBash = 18;
                    countRus = 18;
                    break;
                case R.id.pig:
                    countBash = 19;
                    countRus = 19;
                    break;
                case R.id.goat:
                    countBash = 20;
                    countRus = 20;
                    break;
                case R.id.chicken:
                    countBash = 21;
                    countRus = 21;
                    break;
                case R.id.goose:
                    countBash = 22;
                    countRus = 22;
                    break;

                case R.id.backBtn:
                    startActivity(new Intent(this, GameImages.class));
                    return;
            }
            rawBash = getResources().getIdentifier("gameimgbash" + countBash, "raw", this.getPackageName());
            rawRus = getResources().getIdentifier("gameimgrus" + countRus, "raw", this.getPackageName());
            sounds = new int[]{rawBash, rawRus};
            playMp3();
        }
    }

    void playMp3() {
        if(!nowPlay && isImageScaled) {
            nowPlay = true;
            index = 0;
            mediaPlayer = MediaPlayer.create(getApplicationContext(), sounds[index]);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    if ((index < sounds.length - 1) & (playing)) {
                        mp = MediaPlayer.create(getApplicationContext(), sounds[++index]);
                        mp.start();
                        mp.setOnCompletionListener(this);
                    }
                    else {
                        mp.release();
                        nowPlay =false;
                    }
                }
            });
        }
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, GameImages.class));
    }
}
