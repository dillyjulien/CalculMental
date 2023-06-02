package com.example.calculmental;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.calculmental.DAO.ScoreBaseHelper;
import com.example.calculmental.DAO.ScoreDao;
import com.example.calculmental.model.entities.Score;

import java.util.List;

public class ScoresActivity extends AppCompatActivity {

    private ScoreDao scoreDao;
    TextView textscore1;
    TextView textscore2;
    TextView textscore3;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreDao = new ScoreDao(new ScoreBaseHelper(this,"BDD",1));
        textscore1 = findViewById(R.id.text_score1);
        textscore2 = findViewById(R.id.text_score2);
        textscore3 = findViewById(R.id.text_score3);
       //Score monScore = scoreDao.lastOrNull();
       List<Score> items = scoreDao.TopScores();
       Score score1;
       Score score2;
       Score score3;
       switch ( items.size())
       {
           case 3 :
               score1 = items.get(0);
               score2 = items.get(1);
               score3 = items.get(2);
               textscore1.setText(score1.getNom()+ "  :  "+ score1.getScore());
               textscore2.setText(score2.getNom()+ "  :  "+ score2.getScore());
               textscore3.setText(score3.getNom()+ "  :  "+ score3.getScore());
               break;
           case 2:
               score1 = items.get(0);
               score2 = items.get(1);
               textscore1.setText(score1.getNom()+ "  :  "+ score1.getScore());
               textscore2.setText(score2.getNom()+ "  :  "+ score2.getScore());
               break;
           case 1:
               score1 = items.get(0);
               textscore1.setText(score1.getNom()+ "  :  "+ score1.getScore());
               break;
           default:
               break;
       }


    }
}
