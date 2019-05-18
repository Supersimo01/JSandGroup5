
import java.awt.Color;

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

    /**
     * indica l'altezza della sabbia a sinistra nella scatola
     */
    private float altezzaOvest;

    /**
     * indica l'altezza della sabbia a destra nella scatola
     */
    private float altezzaEst;

    /**
     * indica l'altezza della sabbia sul lato verso nord della scatola
     */
    private float altezzaNord;

    /**
     * indica l'altezza della sabbia sul lato verso sud della scatola
     */
    private float altezzaSud;

    /**
     * indica lo spostamento lungo l'asse X della sabbia (OVEST o EST)
     */
    private float uscitaX;

    /**
     * indica lo spostamento lungo l'asse Y della sabbia (NORD o SUD)
     */
    private float uscitaY;

    /**
     * indica la velocità della sabbia quandi durante lo spostamento
     */
    private float velocita;

    /**
     * indica il colore della sabbia
     */
    private Color colore;

    /**
     * @brief Costruttore vuoto che inizializza gli attributi con valori
     * predefiniti.
     *
     */
    public Sabbia() {
        altezzaOvest = 17f;
        altezzaEst = 17f;
        altezzaNord = 17f;
        altezzaSud = 17f;

        uscitaX = 0f;
        uscitaY = 0f;

        velocita = 0f;

        colore = new Color(224, 161, 117);
    }

    /**
     * @brief Costruttore con parametri.
     * @param altezzaNord
     * @param altezzaSud
     * @param altezzaOvest
     * @param altezzaEst
     * @param velocita
     */
    public Sabbia(float altezzaNord, float altezzaSud, float altezzaOvest, float altezzaEst, float velocita) {
        this.altezzaNord = altezzaNord;
        this.altezzaSud = altezzaSud;
        this.altezzaOvest = altezzaOvest;
        this.altezzaEst = altezzaEst;
        this.velocita = velocita;

        uscitaX = 0f;
        uscitaY = 0f;

        colore = new Color(224, 161, 117);
    }

    /**
     *
     * @return altezzaNord
     */
    public float getAltezzaNord() {
        return altezzaNord;
    }

    /**
     *
     * @return altezzaSud
     */
    public float getAltezzaSud() {
        return altezzaSud;
    }

    /**
     *
     * @return altezzaOvest
     */
    public float getAltezzaOvest() {
        return altezzaOvest;
    }

    /**
     *
     * @return altezzaEst
     */
    public float getAltezzaEst() {
        return altezzaEst;
    }

    /**
     *
     * @return uscitaX
     */
    public float getUscitaX() {
        return uscitaX;
    }

    /**
     *
     * @return uscitaY
     */
    public float getUscitaY() {
        return uscitaY;
    }

    /**
     *
     * @return velocita
     */
    public float getVelocita() {
        return velocita;
    }

    /**
     * @brief Metodo che aggiorna il valore dell'altezza della sabbia su tutti i
     * lati della scatola (se tutte le altezza valgono 0 significa che la
     * scatola è priva di sabbia).
     * @param altezzaNord
     * @param altezzaSud
     * @param altezzaOvest
     * @param altezzaEst
     */
    public void aggiornaAltezze(float altezzaNord, float altezzaSud, float altezzaOvest, float altezzaEst) {
        this.altezzaNord = altezzaNord;
        this.altezzaSud = altezzaSud;
        this.altezzaOvest = altezzaOvest;
        this.altezzaEst = altezzaEst;
    }

    /**
     * @brief Metodo che controlla se l'altezza della sabbia è maggiore o meno
     * dell'altezza della scatola
     * @param altezzaScatola
     * @return true se l'altezza della sabbia in qualche lato è maggiore
     * dell'altezza della scatola, altrimenti false
     */
    private boolean uscitaSabbia(int altezzaScatola) {
        if (altezzaOvest > altezzaScatola || altezzaEst > altezzaScatola
                || altezzaNord > altezzaScatola || altezzaSud > altezzaScatola) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * @brief Metodo che definisce le direzioni da cui la sabbia può uscire
     * dalla scatola.
     */
    public enum Direzione {
        NESSUNA, NORD, SUD, EST, OVEST;
    }

    /**
     * @brief Metodo che controlla in che direzione esce la sabbia, se esce.
     * @param altezzaScatola
     * @return direzione da cui la sabbia esce
     */
    public Direzione direzioneDiUscitaSabbia(int altezzaScatola) {
        Direzione dir = Direzione.NESSUNA;

        if (uscitaSabbia(altezzaScatola)) {
            if (uscitaX != 0f) {
                if (uscitaX >= 1) {
                    dir = Direzione.OVEST;
                } else {
                    dir = Direzione.EST;
                }
            } else if (uscitaY != 0) {
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

    /**
     * @brief Metodo che visualizza tutte le informazioni relative alla sabbia.
     */
    public void visualizzaSabbia() {
        System.out.println("Altezza sinistra: " + altezzaOvest
                + "\nAltezza destra: " + altezzaEst
                + "\nAltezza davanti: " + altezzaNord
                + "\nAltezza dietro: " + altezzaSud
                + "\nVelocita: " + velocita);
    }
}
