package ru.uksivt.berlegen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class kurs extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurs);
        ImageButton button_back = (ImageButton) findViewById(R.id.Button_back); // команда для кнопки назад
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(kurs.this, MainActivity.class);
                startActivity(intent1);

            }
        });


    }
    //Системная кнопка "назад" - начало
    @Override
    public void onBackPressed(){
        Intent intent1 = new Intent(kurs.this, MainActivity.class);
        startActivity(intent1);
    }

    //Системная кнопка "назад" - конец


    public void openkursfood(View view)
    {
        Intent intent = new Intent(this, kurs2.class);
        intent.putExtra("srcru","ruFood");
        intent.putExtra("srcbash","bachFood");
        intent.putExtra("title","Еда");
        startActivity(intent);
    }

    public void openkursprof(View view)
    {
        Intent intent = new Intent(this, kurs2.class);
        intent.putExtra("srcru","ruProfession");
        intent.putExtra("srcbash","bachProfession");
        intent.putExtra("title","Профессии");
        startActivity(intent);
    }

    public void openkursanim(View view)
    {
        Intent intent = new Intent(this, kurs2.class);
        intent.putExtra("srcru","ruAnimals");
        intent.putExtra("srcbash","bachAnimals");
        intent.putExtra("title","Животные");
        startActivity(intent);
    }

    public void openkursnum(View view)
    {
        Intent intent = new Intent(this, kurs2.class);
        intent.putExtra("srcru","ruNumber");
        intent.putExtra("srcbash","bachNumber");
        intent.putExtra("title","Числа");
        startActivity(intent);
    }
}