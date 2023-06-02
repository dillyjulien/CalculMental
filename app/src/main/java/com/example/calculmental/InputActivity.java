package com.example.calculmental;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculmental.DAO.ScoreBaseHelper;
import com.example.calculmental.DAO.ScoreDao;
import com.example.calculmental.model.entities.Score;

public class InputActivity extends AppCompatActivity {

    private String nomJoueur;
    private Integer score;

    private Button boutonSave;

    private TextView textviewScore;

    private ScoreDao scoreDao;

    private EditText name;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        scoreDao =new ScoreDao(new ScoreBaseHelper(this,"BDD",1));
        boutonSave = findViewById(R.id.button_input);
        textviewScore = findViewById(R.id.textViewScore);
        name = findViewById(R.id.textinputName);
        Intent intent =getIntent();
        String afficheScore = intent.getStringExtra("SCORE");
        textviewScore.setText("Score : "+afficheScore);
        score = Integer.parseInt(afficheScore);

        boutonSave.setOnClickListener(view ->{
            nomJoueur = name.getText().toString();
            ajouterBDD();
            Intent intention = new Intent(InputActivity.this, ScoresActivity.class);
            startActivity(intention);
            finish();
        });
    }

    // Ajoute le score et le nom du joueur dans la base de données
    private boolean ajouterBDD(){
        Score monScore =new Score();
        monScore.setScore(score);
        monScore.setNom(nomJoueur);
        scoreDao.create(monScore);

        return true;
    }

}