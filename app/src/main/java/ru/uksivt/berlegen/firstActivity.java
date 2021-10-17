package ru.uksivt.berlegen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class firstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }


    public void start(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }



}
