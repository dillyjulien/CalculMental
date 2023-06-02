package com.example.calculmental.model.entities;

public class Score extends BaseEntity{

    private String nom;
    private Integer score;

    public Score(String nom, Integer score){
        this.nom = nom;
        this.score=score;
    }

    public Score(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
