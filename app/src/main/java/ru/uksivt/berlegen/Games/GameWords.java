package ru.uksivt.berlegen.Games;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import ru.uksivt.berlegen.R;
import ru.uksivt.berlegen.RndBackground;

public class GameWords extends AppCompatActivity implements View.OnClickListener {

    String word = "";
    String strForCheck = "";
    Boolean isFull = false;
    Button[] from;
    Button[] arrOfBtns;
    int CurrentLetter = 0;
    char[] alph = new char[]{ 'А','а','Б','б','В','в','Г','г','Ғ','ғ','Д','д','Ҙ','ҙ','Е','е','Ё','ё','Ж','ж','З','з','И','и','Й','й','К','к','Ҡ','ҡ','Л','л','М','м',
            'Н','н','Ң','ң','О','о','Ө','ө','П','п','Р','р','С','с','Ҫ','ҫ','Т','т','У','у','Ү','ү','Ф','ф','Х','х','Һ','һ','Ц','ц','Ч','ч','Ш','ш','Щ','щ','Ъ','ъ','Ы','ы','Ь','ь','Э','э','Ә','ә','Ю','ю','Я','я' };
    Random rand = new Random();
    Dialog dialog;
    ImageView IV;

    boolean playing = true, nowPlay = false;
    int rawBash = 0, rawRus = 0, w = 0;
    int[] sounds;
    int index;
    MediaPlayer mediaPlayer = new MediaPlayer();

    public int IndOfLet(char a)
    {
        String b = a+ "";
        String q;
        int index = -1;
        for (int i = 0; i < alph.length; i++) {
            q = alph[i]+"";
            if (b.equals(q)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamewords);

        ImageView main = findViewById(R.id.background);
        main.setImageDrawable(getResources().getDrawable(
                getResources().getIdentifier(RndBackground.random(),"drawable",this.getPackageName())
        ));

        ImageButton button_back = findViewById(R.id.Button_back); // команда для кнопки назад
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(GameWords.this, Game.class);
                startActivity(intent1);
            }
        });

        IV = findViewById(R.id.imageView);

        w = rand.nextInt(42);
        if(w==0)
            w =1;


        String lword2 = "letterwordbash"+w;
        int holder2 = getResources().getIdentifier(lword2,"string",this.getPackageName());
        word = getResources().getString(holder2);
        Log.d("WORDDD", word);
        from = new Button[word.length()];
        arrOfBtns = new Button[word.length()];
        int holder4 = getResources().getIdentifier("a"+w,"drawable",this.getPackageName());
        IV.setImageDrawable(getResources().getDrawable(holder4));
        // Озвучка
        rawBash = getResources().getIdentifier("sb" + w,"raw",this.getPackageName());
        rawRus = getResources().getIdentifier("sr" + w, "raw", this.getPackageName());
        sounds = new int[] {rawBash, rawRus};


        float d = getApplicationContext().getResources().getDisplayMetrics().density;
        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams((int) (d * 1), (int) (d * 1));
        Button btn5 = new Button(getApplicationContext());
        btn5.setLayoutParams(LP);
        btn5.setText("~");
        btn5.setVisibility(View.INVISIBLE);
        RelativeLayout RL = (RelativeLayout) findViewById(R.id.RelativeLayout);
        RL.addView(btn5);

        for(int i = 0; i < arrOfBtns.length;i++)
        {
            arrOfBtns[i] = btn5;
        }

        int[] arr = new int[12];

        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = rand.nextInt(alph.length);
        }

        int[] arrOfPosLet = new int[word.length()];
        for (int i = 0; i < arrOfPosLet.length; i++)
            arrOfPosLet[i] = 99;

        int buf;
        boolean NumIsGood = false;

        for (int i = 0; i < word.length(); i++) {
            NumIsGood = false;
            while(true) {
                buf = rand.nextInt(12);
                for (int j = 0; j < word.length(); j++) {
                    if (arrOfPosLet[j] == buf) {
                        NumIsGood = false;
                        break;
                    }
                    else {

                        NumIsGood = true;
                    }

                }
                if(NumIsGood)
                {
                    arrOfPosLet[i] = buf;
                    arr[buf] = IndOfLet(word.charAt(i));
                    break;
                }
            }

        }



        for(int i =0; i< 6;i++) {
            try {
                float density = getApplicationContext().getResources().getDisplayMetrics().density;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (density * 50), (int) (density * 50));
                Button btn = new Button(getApplicationContext());
                layoutParams.leftMargin = (int)density *10;
                btn.setId(i+10);
                btn.setOnClickListener(this);
                btn.setLayoutParams(layoutParams);
                btn.setText(String.valueOf(alph[arr[i]]));

                btn.setBackground(getResources().getDrawable(R.drawable.custom_button));

                btn.setTextColor(Color.WHITE);

                LinearLayout buttonlayout = findViewById(R.id.buttonlayout);
                buttonlayout.addView(btn);
            } catch (Exception e){
                Log.d("ERROR WORD",word);
            }
        }

        for(int i = 6; i< 12;i++)
        {
            float density = getApplicationContext().getResources().getDisplayMetrics().density;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (density * 50), (int) (density * 50));
            Button btn = new Button(getApplicationContext());
            layoutParams.leftMargin = (int)density *10;
            btn.setId(i+20);
            btn.setOnClickListener(this);
            btn.setLayoutParams(layoutParams);
            btn.setText(String.valueOf(alph[arr[i]]));

            btn.setBackground(getResources().getDrawable(R.drawable.custom_button));
            btn.setTextColor(Color.WHITE);

            LinearLayout button2layout = (LinearLayout) findViewById(R.id.button2layout);
            button2layout.addView(btn);
        }

        for(int i =0; i< word.length();i++)
        {
            float density = getApplicationContext().getResources().getDisplayMetrics().density;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (density * 50), (int) (density * 50));
            if(word.length() > 5)
            {
                layoutParams = new LinearLayout.LayoutParams((int) (density * 40), (int) (density * 40));
            }
            Button btn = new Button(getApplicationContext());
            layoutParams.leftMargin = (int)density *10;
            btn.setId(i);
            btn.setOnClickListener(this);
            btn.setLayoutParams(layoutParams);
            btn.setText("");

            btn.setBackground(getResources().getDrawable(R.drawable.custom_button));
            btn.setTextColor(Color.rgb(233,240,192));

            LinearLayout letterlayout = (LinearLayout) findViewById(R.id.letterlayout);
            letterlayout.addView(btn);
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onClick(View v) {
        Button btn1 = (Button) v;

        if(btn1.getCurrentTextColor() == Color.rgb(233,240,192) | btn1.getCurrentTextColor() == Color.rgb(233,240,193) ) {

            if(btn1.getCurrentTextColor() == Color.rgb(233,240,193))
            {
                for(int i =0; i < word.length();i++) {
                    Button btn12 = findViewById(i);
                    btn12.setBackground(getResources().getDrawable(R.drawable.custom_button));
                }
            }


            for (int i = 0; i < word.length(); i++) {
                Button q = (Button) v;

                if (arrOfBtns[i].getId() == q.getId()) {
                    if (!arrOfBtns[i].getText().toString().equals("")) {
                        if (CurrentLetter > i)
                            CurrentLetter = i;
                        from[i].setText(arrOfBtns[i].getText().toString());
                        from[i].setBackground(getResources().getDrawable(R.drawable.custom_button));
                        arrOfBtns[i].setText("");
                    }
                }

            }
        }
        else{
            Button b = (Button) v;
            if (!b.getText().toString().equals("")) {
                isFull = true;

                for (int i = 0; i < arrOfBtns.length; i++) {
                    if (arrOfBtns[i].getText().toString().equals("") | arrOfBtns[i].getText().toString().equals("~")) {
                        isFull = false;
                        break;
                    }
                }

                if (!isFull) {
                    Button changebtn = findViewById(CurrentLetter);

                    while (!changebtn.getText().toString().equals("")) {
                        CurrentLetter++;
                        changebtn = findViewById(CurrentLetter);
                    }
                    arrOfBtns[CurrentLetter] = changebtn;
                    CurrentLetter++;
                    Button btn = (Button) v;
                    changebtn.setText(btn.getText().toString());
                    from[CurrentLetter - 1] = btn;
                    btn.setBackground(getResources().getDrawable(R.drawable.custom_button_pressed));
                    btn.setText("");

                    strForCheck = "";
                    for (int i = 0; i < word.length(); i++) {
                        strForCheck += arrOfBtns[i].getText().toString();
                    }

                    boolean q = true;

                    for (int i = 0; i < word.length(); i++) {
                        if(arrOfBtns[i].getText().toString().equals("") | arrOfBtns[i].getText().toString().equals("~")) {
                            q = false;
                            break;
                        }

                    }

                    if (strForCheck.equals(word)) {
                        dialog = new Dialog(this,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.windialog);

                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.setCancelable(false);
                        dialog.show();

                        playMp3();
                        q=false;
                    }

                    if(q){
                        for(int i =0; i < word.length();i++) {
                            final Button btn12 = findViewById(i);
                            btn12.setTextColor(Color.rgb(233,240,193));
                            btn12.setBackground(getResources().getDrawable(R.drawable.wrong));
                            btn12.animate().rotation(20).setDuration(300);

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    btn12.animate().rotation(0).setDuration(300);
                                }
                            },500);
                        }}
                }
            }
        }
    }

    public void playMp3() {
        if(!nowPlay) {
            nowPlay = true;
            index = 0;
            mediaPlayer = MediaPlayer.create(getApplicationContext(), sounds[index]);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    if (index < sounds.length - 1) {
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

    public void winNext(View view) {
        if(!nowPlay)
            startActivity(new Intent(this, GameWords.class));
    }
    //Системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        startActivity(new Intent(GameWords.this, Game.class));
    }
}