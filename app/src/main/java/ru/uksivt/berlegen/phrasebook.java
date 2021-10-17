package ru.uksivt.berlegen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class phrasebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrasebook);
    }

    public void onClick(View view)
    {
        int q=1;
        Intent i = new Intent(this, phrase.class);
        switch(view.getId())
        {
            case R.id.button1:
                q=1;
                break;
            case R.id.button2:
                q=2;
                break;
            case R.id.button3:
                q=3;
                break;
            case R.id.button4:
                q=4;
                break;
            case R.id.button5:
                q=5;
                break;
            case R.id.button6:
                q=6;
                break;
            case R.id.button7:
                q=7;
                break;
            case R.id.button8:
                q=8;
                break;
            case R.id.button9:
                q=9;
                break;
            case R.id.button10:
                q=10;
                break;
        }
        i.putExtra("num",q);
        startActivity(i);
    }

    public void goback(View view)
    {
        Intent goback = new Intent(this,MainActivity.class);
        startActivity(goback);
    }

}
