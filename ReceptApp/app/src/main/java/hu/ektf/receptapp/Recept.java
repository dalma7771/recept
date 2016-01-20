package hu.ektf.receptapp;

/**
 * Created by Dalma on 2016.01.20..
 */
public class Recept {
    int kepID;
    String nev;

    public Recept(String n, int id){
        nev = n;
        kepID = id;
    }

    public int getKepID(){
        return kepID;
    }

    public String getNev(){
        return nev;
    }
}
