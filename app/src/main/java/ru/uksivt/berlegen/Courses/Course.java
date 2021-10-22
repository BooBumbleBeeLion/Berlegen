package ru.uksivt.berlegen.Courses;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.MainActivity;
import ru.uksivt.berlegen.R;


public class Course extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurs);

        findViewById(R.id.backBtn).setOnClickListener(this);

        findViewById(R.id.number).setOnClickListener(this);
        findViewById(R.id.animals).setOnClickListener(this);
        findViewById(R.id.food).setOnClickListener(this);
        findViewById(R.id.profession).setOnClickListener(this);
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
            case R.id.number:
                intent.putExtra("srcru","ruNumber");
                intent.putExtra("srcbash","bachNumber");
                intent.putExtra("title","Числа");
                break;
            case R.id.animals:
                intent.putExtra("srcru","ruAnimals");
                intent.putExtra("srcbash","bachAnimals");
                intent.putExtra("title","Животные");
                break;
            case R.id.food:
                intent.putExtra("srcru","ruFood");
                intent.putExtra("srcbash","bachFood");
                intent.putExtra("title","Еда");
                break;
            case R.id.profession:
                intent.putExtra("srcru","ruProfession");
                intent.putExtra("srcbash","bachProfession");
                intent.putExtra("title","Профессии");
                break;
            default:
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(Course.this, MainActivity.class));
    }
}