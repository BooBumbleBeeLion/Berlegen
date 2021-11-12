package ru.uksivt.berlegen;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import ru.uksivt.berlegen.Alphabet.Alphabet;
import ru.uksivt.berlegen.Courses.Course;
import ru.uksivt.berlegen.Games.Game;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.alphabet).setOnClickListener(this);
        findViewById(R.id.course).setOnClickListener(this);
        findViewById(R.id.game).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.alphabet:
                startActivity(new Intent(this, Alphabet.class));
                break;
            case R.id.course:
                startActivity(new Intent(this, Course.class));
                break;
            case R.id.game:
                startActivity(new Intent(this, Game.class));
                break;
        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Вы куда?")
                .setMessage("Уверены, что хотите выйти?")
                .setPositiveButton("Выйти", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moveTaskToBack(true);
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Остаться", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.create().show();
    }
}