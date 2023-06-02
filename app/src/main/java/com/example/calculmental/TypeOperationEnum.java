package com.example.calculmental;

public enum TypeOperationEnum {

    ADD(" + "),
    SUBSTRACT(" - "),
    MULTIPLY(" * "),
    DIVIDE(" / ");

    TypeOperationEnum(String symbole){
        this.symbole = symbole;
    }
    public String getSymbole(){
        return symbole;
    }
    private String symbole;


}
