package ru.uksivt.berlegen.Alphabet;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import ru.uksivt.berlegen.R;

public class letter extends AppCompatActivity {
    boolean playing = true, nowPlay =false;
    int[] sounds;
    int index;
    Random r = new Random();
    Button btn;
    TextView word, bashWord;
    ImageView IV, Background;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter);

        word = findViewById(R.id.word) ;
        bashWord = findViewById(R.id.bashWord) ;
        btn = findViewById(R.id.letterImage) ;
        IV = findViewById(R.id.imageWord);
        Background = findViewById(R.id.background);

        // Достаются данные, переданные из Alphabet.java
        word.setText(getIntent().getStringExtra("letter"));
        bashWord.setText(getIntent().getStringExtra("letter"));
        String w = getIntent().getStringExtra("letter").substring(1);
        btn.setText(getIntent().getStringExtra("let"));

        // Ресурсы mp3 записываются
        int letterMp = getResources().getIdentifier("l"+w,"raw",this.getPackageName());
        int bashMp = getResources().getIdentifier("sb"+w,"raw",this.getPackageName());
        int rusMp = getResources().getIdentifier("sr"+w,"raw",this.getPackageName());
        sounds = new int[]{letterMp, bashMp, rusMp};

        // Русское название на основании буквы
        String rusWord = "letterword"+w;
        int rusHolder = getResources().getIdentifier(rusWord,"string",this.getPackageName());
        word.setText(getResources().getString(rusHolder));

        // Башкирское название на основании буквы
        String bashLetter = "letterwordbash"+w;
        int bashHolder = getResources().getIdentifier(bashLetter,"string",this.getPackageName());
        bashWord.setText(getResources().getString(bashHolder));

        // Картинка на основании буквы
        int wordImage = getResources().getIdentifier("a"+w,"drawable",this.getPackageName());
        IV.setImageDrawable(getResources().getDrawable(wordImage));

        // Рандомный Background
        int backgroundImage = getResources().getIdentifier("f"+r.nextInt(32),"drawable",this.getPackageName());
        Background.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Background.setImageDrawable(getResources().getDrawable(backgroundImage));
    }

    public void playMp3(View view)
    {
        if(!nowPlay) {
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
    public void goBack(View view)
    {
        playing = false;
        startActivity(new Intent(this, Alphabet.class));
        mediaPlayer.stop();
    }

    @Override
    public void onBackPressed(){
        playing = false;
        startActivity(new Intent(this, Alphabet.class));
        mediaPlayer.stop();
    }
}
