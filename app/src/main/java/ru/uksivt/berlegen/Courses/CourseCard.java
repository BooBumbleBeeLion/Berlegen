package ru.uksivt.berlegen.Courses;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.R;
import ru.uksivt.berlegen.RndBackground;

public class CourseCard extends AppCompatActivity {

    String[] ru, bash;
    int[] sounds;
    int index;
    int arrayLength = 0, counter = 0, holderInt = 0, holderInt2 = 0;
    boolean playing = true, nowPlay =false;
    MediaPlayer mediaPlayer = new MediaPlayer();
    Button next;
    ImageView iv;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurs2);

        ImageView main = findViewById(R.id.background);
        main.setImageDrawable(getResources().getDrawable(
                getResources().getIdentifier(RndBackground.random(),"drawable",this.getPackageName())
        ));

        TextView mi = findViewById(R.id.message_input);
        TextView textRu = findViewById(R.id.textru);
        TextView textBash = findViewById(R.id.textbash);
        next = findViewById(R.id.Button_next);
        iv = findViewById(R.id.image);

        mi.setText(getIntent().getStringExtra("title"));
        ru  = getResources().getStringArray(getResources().getIdentifier(getIntent().getStringExtra("srcru"), "array",getPackageName()));
        arrayLength = ru.length;

        textRu.setText(ru[counter]);

        bash  = getResources().getStringArray(getResources().getIdentifier(getIntent().getStringExtra("srcbash"), "array",getPackageName()));

        textBash.setText(bash[counter]);


        switch(getIntent().getStringExtra("title"))
        {
            case "Еда":
                holderInt = getResources().getIdentifier("foodbash"+(counter+1),"raw",this.getPackageName());
                holderInt2 = getResources().getIdentifier("foodrus"+(counter+1),"raw",this.getPackageName());
                iv.setImageResource(getResources().getIdentifier("food"+(counter+1),"drawable",this.getPackageName()));
                break;
            case "Профессии":
                holderInt = getResources().getIdentifier("profbash"+(counter+1),"raw",this.getPackageName());
                holderInt2 = getResources().getIdentifier("profrus"+(counter+1),"raw",this.getPackageName());
                iv.setImageResource(getResources().getIdentifier("p"+(counter+1),"drawable",this.getPackageName()));
                break;
            case "Животные" :
                holderInt = getResources().getIdentifier("animalbash"+(counter+1),"raw",this.getPackageName());
                holderInt2 = getResources().getIdentifier("animalrus"+(counter+1),"raw",this.getPackageName());
                iv.setImageResource(getResources().getIdentifier("anim"+(counter+1),"drawable",this.getPackageName()));
                break;
            case "Числа" :
                holderInt = getResources().getIdentifier("numbash"+(counter+1),"raw",this.getPackageName());
                holderInt2 = getResources().getIdentifier("numrus"+(counter+1),"raw",this.getPackageName());
                iv.setImageResource(getResources().getIdentifier("num"+(counter+1),"drawable",this.getPackageName()));
                break;
        }
        sounds = new int[]{holderInt, holderInt2};
    }

    @Override
    public void onBackPressed(){
        playing = false;

        startActivity(new Intent(CourseCard.this, Course.class));
        mediaPlayer.stop();
    }

    public void goBack(View view)
    {
        playing = false;
        startActivity(new Intent(CourseCard.this, Course.class));
        mediaPlayer.stop();
    }
    boolean IsEnd = false;
    //Системная кнопка "назад" - конец
    public void next(View view) {
        if (!IsEnd) {
            if (!nowPlay) {
                TextView textru = findViewById(R.id.textru);
                TextView textbash = findViewById(R.id.textbash);
                if (counter < arrayLength - 1) {
                    counter++;
                    textru.setText(ru[counter]);
                    textbash.setText(bash[counter]);
                }
                if (counter == arrayLength - 1) {
                    next.setText("Понятно");
                    IsEnd = true;
                }
                switch (getIntent().getStringExtra("title")) {
                    case "Еда":
                        holderInt = getResources().getIdentifier("foodbash" + (counter + 1), "raw", this.getPackageName());
                        holderInt2 = getResources().getIdentifier("foodrus" + (counter + 1), "raw", this.getPackageName());
                        iv.setImageResource(getResources().getIdentifier("food" + (counter + 1), "drawable", this.getPackageName()));
                        break;
                    case "Профессии":
                        holderInt = getResources().getIdentifier("profbash" + (counter + 1), "raw", this.getPackageName());
                        holderInt2 = getResources().getIdentifier("profrus" + (counter + 1), "raw", this.getPackageName());
                        iv.setImageResource(getResources().getIdentifier("p" + (counter + 1), "drawable", this.getPackageName()));
                        break;
                    case "Животные":
                        holderInt = getResources().getIdentifier("animalbash" + (counter + 1), "raw", this.getPackageName());
                        holderInt2 = getResources().getIdentifier("animalrus" + (counter + 1), "raw", this.getPackageName());
                        iv.setImageResource(getResources().getIdentifier("anim" + (counter + 1), "drawable", this.getPackageName()));
                        break;
                    case "Числа":
                        holderInt = getResources().getIdentifier("numbash" + (counter + 1), "raw", this.getPackageName());
                        holderInt2 = getResources().getIdentifier("numrus" + (counter + 1), "raw", this.getPackageName());
                        iv.setImageResource(getResources().getIdentifier("num" + (counter + 1), "drawable", this.getPackageName()));
                        break;
                }
                sounds = new int[]{holderInt, holderInt2};
            }

        }
        else {
            playing = false;
            startActivity(new Intent(CourseCard.this, Course.class));
            mediaPlayer.stop();
        }
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
                        index++;
                        mp = MediaPlayer.create(getApplicationContext(), sounds[index]);
                        mp.start();
                        mp.setOnCompletionListener(this);
                    }
                    else {
                        mp.release();
                        nowPlay =false;}
                }
            });
        }
    }
}