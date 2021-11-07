package ru.uksivt.berlegen.Alphabet;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import ru.uksivt.berlegen.MainActivity;
import ru.uksivt.berlegen.R;
import ru.uksivt.berlegen.RndBackground;

public class Alphabet extends AppCompatActivity {

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        ImageView main = findViewById(R.id.background);
        main.setImageDrawable(getResources().getDrawable(
                getResources().getIdentifier(RndBackground.random(),"drawable",this.getPackageName())
        ));
    }

    public void openLetter(View view) {
        String str = getResources().getResourceEntryName(view.getId());
        TextView b = (TextView) view;

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
