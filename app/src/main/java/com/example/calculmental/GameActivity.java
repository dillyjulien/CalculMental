package com.example.calculmental;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private TextView textViewCalcul;
    private TextView textViewResultat;

    private MenuItem score;
    private Integer nbScore=0;
    private MenuItem vies;
    private Integer nbVies=3;

    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private Button bouton0;
    private Button boutonCheck;

    private Button boutonSupp;

    private Integer premierTerme;
    private Integer secondTerme;
    private Integer resultat;

    private TypeOperationEnum typeOperation;

    private Integer calculResultat = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewCalcul=findViewById(R.id.textView_calcul);
        textViewResultat=findViewById(R.id.textView_resultat);

        bouton1=findViewById(R.id.button_1);
        bouton1.setOnClickListener(view ->{
            ajouterChiffre(1);
        });

        bouton2=findViewById(R.id.button_2);
        bouton2.setOnClickListener(view ->{
            ajouterChiffre(2);
        });

        bouton3=findViewById(R.id.button_3);
        bouton3.setOnClickListener(view ->{
            ajouterChiffre(3);
        });

        bouton4=findViewById(R.id.button_4);
        bouton4.setOnClickListener(view ->{
            ajouterChiffre(4);
        });

        bouton5=findViewById(R.id.button_5);
        bouton5.setOnClickListener(view ->{
            ajouterChiffre(5);
        });

        bouton6=findViewById(R.id.button_6);
        bouton6.setOnClickListener(view ->{
            ajouterChiffre(6);
        });

        bouton7=findViewById(R.id.button_7);
        bouton7.setOnClickListener(view ->{
            ajouterChiffre(7);
        });

        bouton8=findViewById(R.id.button_8);
        bouton8.setOnClickListener(view ->{
            ajouterChiffre(8);
        });

        bouton9=findViewById(R.id.button_9);
        bouton9.setOnClickListener(view ->{
            ajouterChiffre(9);
        });

        bouton0=findViewById(R.id.button_0);
        bouton0.setOnClickListener(view ->{
            ajouterChiffre(0);
        });

        boutonCheck=findViewById(R.id.button_confirm);
        boutonCheck.setOnClickListener(view ->{
            verification();
        });

        boutonSupp=findViewById(R.id.button_delete);
        boutonSupp.setOnClickListener(view ->{
            calculResultat= calculResultat/10;
            majTextCalcul();
        });

        generateCalcul();
        majTextGame();
        calculResultat=0;
        majTextCalcul();
    }

    // Génère un nouveau calcul avec des nombres aléatoires et un type d'opération aléatoire
    private void generateCalcul(){
        Random hasard = new Random();
        Integer typeOpe;
        secondTerme = hasard.nextInt(10)+1;
        premierTerme = hasard.nextInt(10)+secondTerme;
        typeOpe = hasard.nextInt(4);
        switch(typeOpe){
            case 0:
                typeOperation = TypeOperationEnum.ADD;
                resultat=premierTerme+secondTerme;
                break;
            case 1:
                typeOperation = TypeOperationEnum.SUBSTRACT;
                resultat=premierTerme-secondTerme;
                break;
            case 2:
                typeOperation = TypeOperationEnum.MULTIPLY;
                resultat=premierTerme*secondTerme;
                break;
            case 3:
                typeOperation = TypeOperationEnum.DIVIDE;
                resultat=premierTerme;
                premierTerme=resultat*secondTerme;
                break;
        }
    }

    // Met à jour le texte affichant le calcul à résoudre
    private void majTextGame(){
        textViewCalcul.setText(premierTerme + typeOperation.getSymbole() + secondTerme);
    }

    // Ajoute un chiffre à la saisie du résultat du calcul
    private void ajouterChiffre(Integer chiffre){
        if(calculResultat<=999){
            calculResultat=10*calculResultat+chiffre;
            majTextCalcul();
        }else{
            Toast.makeText(this,getString(R.string.ERROR_NUMBER_TOO_HIGH), Toast.LENGTH_LONG).show();
        }
    }

    // Met à jour le texte affichant la saisie du résultat du calcul
    private void majTextCalcul(){
        textViewResultat.setText(""+calculResultat);
    }


    // Crée le menu dans la barre d'outils
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar,menu);
        score = menu.findItem(R.id.toolbar_score);
        this.score.setTitle("Score : "+nbScore);
        vies = menu.findItem(R.id.toolbar_vies);
        this.vies.setTitle("Vies : "+nbVies);
        return super.onCreateOptionsMenu(menu);
    }

    // Vérifie le résultat saisi par le joueur et met à jour le score et le nombre de vies en conséquence
    private void verification(){
        if(calculResultat==resultat){
            nbScore++;
            this.score.setTitle("Score : "+nbScore);
        }else{
            nbVies--;
            this.vies.setTitle("Vies : "+nbVies);
        }

        if(nbVies<0){
            Intent intent = new Intent(GameActivity.this, InputActivity.class);
            intent.putExtra("SCORE", nbScore.toString());
            startActivity(intent);
            finish();
        }

        generateCalcul();
        majTextGame();
        calculResultat=0;
        majTextCalcul();
    }


}
