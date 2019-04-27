/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luca Mariani
 */
public class Sabbia {

    private float altezzaOvest; //indica l'altezza della sabbia a sinistra nella scatola
    private float altezzaEst; //indica l'altezza della sabbia a destra nella scatola
    private float altezzaNord; //indica l'altezza della sabbia sul lato verso nord della scatola
    private float altezzaSud; //indica l'altezza della sabbia sul lato verso sud della scatola

    private float uscitaX; //indica lo spostamento lungo l'asse X della sabbia (OVEST o EST)
    private float uscitaY; //indica lo spostamento lungo l'asse Y della sabbia (NORD o SUD)

    private float velocita; //indica la velocità della sabbia quandi durante lo spostamento

    public Sabbia() {
        altezzaOvest = 17f; //17 è un valore a caso che ho messo perchè penso che dovremmo far iniziare la sabbia da un livello uniforme
        altezzaEst = 17f;
        altezzaNord = 17f;
        altezzaSud = 17f;

        uscitaX = 0f;
        uscitaY = 0f;

        velocita = 0f;
    }

    public Sabbia(float altezzaNord, float altezzaSud, float altezzaOvest, float altezzaEst, float velocita) {
        this.altezzaNord = altezzaNord;
        this.altezzaSud = altezzaSud;
        this.altezzaOvest = altezzaOvest;
        this.altezzaEst = altezzaEst;
        this.velocita = velocita;
    }

    public float getAltezzaNord() {
        return altezzaNord;
    }

    public float getAltezzaSud() {
        return altezzaSud;
    }

    public float getAltezzaOvest() {
        return altezzaOvest;
    }

    public float getAltezzaEst() {
        return altezzaEst;
    }

    public float getUscitaX() {
        return uscitaX;
    }

    public float getUscitaY() {
        return uscitaY;
    }

    public float getVelocita() {
        return velocita;
    }

    /*aggiornaAltezze serve anche per modificare la quantità di sabbia nella scatola 
    (se entrambe valgono 0 vuol dire che in quella scatola non c'è sabbia)*/
    public void aggiornaAltezze(float altezzaNord, float altezzaSud, float altezzaOvest, float altezzaEst) {
        this.altezzaNord = altezzaNord;
        this.altezzaSud = altezzaSud;
        this.altezzaOvest = altezzaOvest;
        this.altezzaEst = altezzaEst;
    }

    //se l'altezza sinistra o destra è > dell'altezza della scatola allora la sabbia esce, altrimenti no
    private boolean uscitaSabbia(int altezzaScatola) {
        if (altezzaOvest > altezzaScatola || altezzaEst > altezzaScatola
                || altezzaNord > altezzaScatola || altezzaSud > altezzaScatola) {
            return true;
        } else {
            return false;
        }

    }

    //direzioni da cui può uscire la sabbia dalla scatola
    public enum Direzione {
        NESSUNA, NORD, SUD, EST, OVEST;
    }

    //se la sabbia sta uscendo, vedo dove
    public Direzione direzioneDiUscitaSabbia(int altezzaScatola) {
        Direzione dir = Direzione.NESSUNA;

        if (uscitaSabbia(altezzaScatola)) {
            if (uscitaX != 0f) {
                if (uscitaX >= 1) {
                    dir = Direzione.OVEST;
                } else {
                    dir = Direzione.EST;
                }
            }
            else if (uscitaY != 0) {
                if (uscitaY >= 1) {
                    dir = Direzione.NORD;
                } else {
                    dir = Direzione.SUD;
                }
            }

        } else {
            dir = Direzione.NESSUNA;
        }

        return dir;
    }

    public void visualizzaSabbia() {
        System.out.println("Altezza sinistra: " + altezzaOvest
                + "\nAltezza destra: " + altezzaEst
                + "\nAltezza davanti: " + altezzaNord
                + "\nAltezza dietro: " + altezzaSud
                + "\nVelocita: " + velocita);
    }
}
