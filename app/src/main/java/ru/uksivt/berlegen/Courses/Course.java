package ru.uksivt.berlegen.Courses;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.MainActivity;
import ru.uksivt.berlegen.R;
import ru.uksivt.berlegen.RndBackground;


public class Course extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurs);

        ImageView main = findViewById(R.id.background);
        main.setImageDrawable(getResources().getDrawable(
                getResources().getIdentifier(RndBackground.random(),"drawable",this.getPackageName())
        ));

        findViewById(R.id.backBtn).setOnClickListener(this);

        findViewById(R.id.imageNumber).setOnClickListener(this);
        findViewById(R.id.imageAnimals).setOnClickListener(this);
        findViewById(R.id.imageFood).setOnClickListener(this);
        findViewById(R.id.imageProf).setOnClickListener(this);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.backBtn) {
            startActivity(new Intent(Course.this, MainActivity.class));
            return;
        }

        Intent intent = new Intent(this, CourseCard.class);
        switch (view.getId()){
            case R.id.imageNumber:
                intent.putExtra("srcru","ruNumber");
                intent.putExtra("srcbash","bachNumber");
                intent.putExtra("title","Числа");
                break;
            case R.id.imageAnimals:
                intent.putExtra("srcru","ruAnimals");
                intent.putExtra("srcbash","bachAnimals");
                intent.putExtra("title","Животные");
                break;
            case R.id.imageFood:
                intent.putExtra("srcru","ruFood");
                intent.putExtra("srcbash","bachFood");
                intent.putExtra("title","Еда");
                break;
            case R.id.imageProf:
                intent.putExtra("srcru","ruProfession");
                intent.putExtra("srcbash","bachProfession");
                intent.putExtra("title","Профессии");
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(Course.this, MainActivity.class));
    }
}