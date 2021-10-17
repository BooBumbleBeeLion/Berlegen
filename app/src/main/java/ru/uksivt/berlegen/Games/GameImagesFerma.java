package ru.uksivt.berlegen.Games;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.R;

public class GameImagesFerma extends AppCompatActivity implements View.OnClickListener {

    private boolean isImageScaled = false;
    boolean playing = true, nowPlay =false;
    int[] sounds;
    int index;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giferma);

        findViewById(R.id.backBtn).setOnClickListener(this);
        findViewById(R.id.cow).setOnClickListener(this);
        findViewById(R.id.pig).setOnClickListener(this);
        findViewById(R.id.goat).setOnClickListener(this);
        findViewById(R.id.chicken).setOnClickListener(this);
        findViewById(R.id.goose).setOnClickListener(this);
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
            case R.id.cow:
                break;
            case R.id.pig:
                break;
            case R.id.goat:
                break;
            case R.id.chicken:
                break;
            case R.id.goose:
                break;
            case R.id.backBtn:
                Intent intent = new Intent(this, GameImages.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void playMp3(View view)
    {
        if(nowPlay == false) {
            nowPlay =true;
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
        Intent intent1 = new Intent(this, GameImages.class);
        startActivity(intent1);
    }
}