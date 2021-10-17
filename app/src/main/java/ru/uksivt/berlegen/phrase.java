package ru.uksivt.berlegen;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class phrase extends AppCompatActivity {
    Intent goback;
    MediaPlayer mediaPlayer = new MediaPlayer();
    int[] sounds;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_phrase);
        Button nobutton = (Button) findViewById(R.id.nobutton) ;
        Button nobutton2 = (Button) findViewById(R.id.nobutton2) ;
        int w =getIntent().getIntExtra("num",0);
        String word = "slovo"+w;
        //nobutton.setText(word);
        int holder = getResources().getIdentifier(word,"string",this.getPackageName());
        nobutton.setText(getResources().getString(holder));

        String word2 = "bach"+w;
        int holder2 = getResources().getIdentifier(word2,"string",this.getPackageName());
        nobutton2.setText(getResources().getString(holder2));

        int holderint2 = getResources().getIdentifier("phraseb"+w,"raw",this.getPackageName());
        int holderint = getResources().getIdentifier("phraser"+w,"raw",this.getPackageName());
        sounds = new int[]{holderint, holderint2};

        goback = new Intent(this, phrasebook.class);

    }
    boolean playing = true, nowplay =false;
    @Override
    public void onBackPressed(){
        playing = false;
        startActivity(goback);
        mediaPlayer.stop();
    }

    public void goBack(View view)
    {
        playing = false;
        startActivity(goback);
        mediaPlayer.stop();
    }

    public void playmp3(View view)
    {
        if(nowplay == false) {
            nowplay = true;
            index = 0;
            mediaPlayer = MediaPlayer.create(getApplicationContext(), sounds[index]);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    if ((index < sounds.length - 1) & (playing)) {
                        index++;
                        mp = MediaPlayer.create(getApplicationContext(), sounds[index]);
                        mp.start();
                        mp.setOnCompletionListener(this);
                    }
                    else {
                        mp.release();
                        nowplay=false;}
                }
            });
        }
    }
}
