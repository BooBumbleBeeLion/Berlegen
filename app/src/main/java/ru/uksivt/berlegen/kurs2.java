package ru.uksivt.berlegen;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class kurs2 extends AppCompatActivity {

    String[] ru, bash;
    MediaPlayer mediaPlayer = new MediaPlayer();
    int[] sounds;
    int index;
    Button next;
    Intent intent1;
    int maslength=0;
    int counter =0;
    int holderint=0;
    int holderint2=0;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurs2);
        TextView mi = (TextView) findViewById(R.id.message_input);
        TextView textru = (TextView) findViewById(R.id.textru);
        TextView textbash = (TextView) findViewById(R.id.textbash);
        mi.setText(getIntent().getStringExtra("title"));
        next = (Button) findViewById(R.id.Button_next);
        iv = (ImageView) findViewById(R.id.image);
        ru  = getResources().getStringArray(getResources().getIdentifier(getIntent().getStringExtra("srcru"), "array",getPackageName()));
        maslength = ru.length;

        textru.setText(ru[counter]);

        bash  = getResources().getStringArray(getResources().getIdentifier(getIntent().getStringExtra("srcbash"), "array",getPackageName()));

        textbash.setText(bash[counter]);


        switch(getIntent().getStringExtra("title"))
        {
            case "Еда":
                holderint = getResources().getIdentifier("fb"+(counter+1),"raw",this.getPackageName());
                holderint2 = getResources().getIdentifier("fr"+(counter+1),"raw",this.getPackageName());
                iv.setImageResource(getResources().getIdentifier("food"+(counter+1),"drawable",this.getPackageName()));
                break;
            case "Профессии":
                holderint = getResources().getIdentifier("pb"+(counter+1),"raw",this.getPackageName());
                holderint2 = getResources().getIdentifier("pr"+(counter+1),"raw",this.getPackageName());
                iv.setImageResource(getResources().getIdentifier("p"+(counter+1),"drawable",this.getPackageName()));
                break;
            case "Животные" :
                holderint = getResources().getIdentifier("ab"+(counter+1),"raw",this.getPackageName());
                holderint2 = getResources().getIdentifier("ar"+(counter+1),"raw",this.getPackageName());
                iv.setImageResource(getResources().getIdentifier("anim"+(counter+1),"drawable",this.getPackageName()));
                break;
            case "Числа" :
                holderint = getResources().getIdentifier("nb"+(counter+1),"raw",this.getPackageName());
                holderint2 = getResources().getIdentifier("nr"+(counter+1),"raw",this.getPackageName());
                iv.setImageResource(getResources().getIdentifier("num"+(counter+1),"drawable",this.getPackageName()));
                break;
        }
        intent1 = new Intent(kurs2.this, kurs.class);
        sounds = new int[]{holderint, holderint2};
    }
    boolean playing = true,nowplay =false;
    //Системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        playing = false;

        startActivity(intent1);
        mediaPlayer.stop();
    }

    public void goback(View view)
    {
        playing = false;
        startActivity(intent1);
        mediaPlayer.stop();
    }
    boolean IsEnd = false;
    //Системная кнопка "назад" - конец
    public void next(View view) {
        if (IsEnd != true) {
            if (nowplay != true) {
                //mediaPlayer.stop();
                TextView textru = (TextView) findViewById(R.id.textru);
                TextView textbash = (TextView) findViewById(R.id.textbash);
                if (counter < maslength - 1) {
                    counter++;
                    textru.setText(ru[counter]);
                    textbash.setText(bash[counter]);
                }
                if (counter == maslength - 1) {
                    next.setText("Понятно");
                    IsEnd = true;
                }
                switch (getIntent().getStringExtra("title")) {
                    case "Еда":
                        holderint = getResources().getIdentifier("fb" + (counter + 1), "raw", this.getPackageName());
                        holderint2 = getResources().getIdentifier("fr" + (counter + 1), "raw", this.getPackageName());
                        iv.setImageResource(getResources().getIdentifier("food" + (counter + 1), "drawable", this.getPackageName()));
                        break;
                    case "Профессии":
                        holderint = getResources().getIdentifier("pb" + (counter + 1), "raw", this.getPackageName());
                        holderint2 = getResources().getIdentifier("pr" + (counter + 1), "raw", this.getPackageName());
                        iv.setImageResource(getResources().getIdentifier("p" + (counter + 1), "drawable", this.getPackageName()));
                        break;
                    case "Животные":
                        holderint = getResources().getIdentifier("ab" + (counter + 1), "raw", this.getPackageName());
                        holderint2 = getResources().getIdentifier("ar" + (counter + 1), "raw", this.getPackageName());
                        iv.setImageResource(getResources().getIdentifier("anim" + (counter + 1), "drawable", this.getPackageName()));
                        break;
                    case "Числа":
                        holderint = getResources().getIdentifier("nb" + (counter + 1), "raw", this.getPackageName());
                        holderint2 = getResources().getIdentifier("nr" + (counter + 1), "raw", this.getPackageName());
                        iv.setImageResource(getResources().getIdentifier("num" + (counter + 1), "drawable", this.getPackageName()));
                        break;
                }
                sounds = new int[]{holderint, holderint2};
            }

        }
        else
        {
            playing = false;

            startActivity(intent1);
            mediaPlayer.stop();
        }
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