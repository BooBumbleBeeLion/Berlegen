package ru.uksivt.berlegen.Alphabet;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.MainActivity;
import ru.uksivt.berlegen.R;

public class Alphabet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
    }

    public void openLetter(View view) {
        String str = getResources().getResourceEntryName(view.getId());
        Button b = (Button) view;

        Intent openLetterActivity = new Intent(this,letter.class);
        openLetterActivity.putExtra("letter",str);
        openLetterActivity.putExtra("let",b.getText().toString());
        startActivity(openLetterActivity);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
