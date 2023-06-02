package com.example.calculmental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boutonJouer;
    private Button boutonScores;
    private Button boutonAPropos;
    private Button boutonGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boutonJouer = findViewById(R.id.button_play);
        boutonJouer.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        });
        boutonScores = findViewById(R.id.button_score);
        boutonScores.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, ScoresActivity.class);
            startActivity(intent);
        });
        boutonAPropos = findViewById(R.id.button_apropos);
        boutonAPropos.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });
        boutonGuide = findViewById(R.id.button_guide);
        boutonGuide.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, GuideActivity.class);
            startActivity(intent);
        });
    }

}