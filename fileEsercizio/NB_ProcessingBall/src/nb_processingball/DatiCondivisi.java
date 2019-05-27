/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb_processingball;

import java.awt.Color;

/**
 * @version 0.8
 * @author Mauri Simone
 */
public class DatiCondivisi {

    //	An array of palline
    private Ball[] palline;
    private int running;
    private float red;
    private float green;
    private float blue;
    private float inclinazioneX;
    private float inclinazioneY;

    
    /**
     * @brief colore della sabbia
     */
    private Color coloreSabbia;
    
    /**
     * @brief righe delle matrice delle scatole
     */
    private int righeScatole;
    
    /**
     * @brief colonne delle matrice delle scatole
     */
    private int colonneScatole;
    /**
     * @brief sabbia
     */
    private Sabbia sabbia;
    /**
     * @brief costruttore con parametri
     * @param numBalls
     * @param width
     * @param height 
     */
    public DatiCondivisi(int numBalls, int width, int height) {

        
        //inizializzare variabili
        
        palline = new Ball[numBalls];
        // Set the starting position of the palline
        for (int i = 0; i < palline.length; i++) {
            palline[i] = new Ball(this);
        }
        running = numBalls;
        red = 64;
        green = 64;
        blue = 64;
        inclinazioneX = 0;
        inclinazioneY = 0;
        sabbia = new Sabbia(this);
        coloreSabbia = sabbia.getColore();
        
        righeScatole = 2;
        colonneScatole = 2;
    }

    /**
     * @brief costruttore con parametri
     * @param numBalls 
     */
    DatiCondivisi(int numBalls) {
        palline = new Ball[numBalls];
        // Set the starting position of the palline
        for (int i = 0; i < palline.length; i++) {
            palline[i] = new Ball(this);
        }
        running = numBalls;
        red = 64;
        green = 0;
        blue = 64;
        inclinazioneX = 0;
        inclinazioneY = 0;
        
        //set parametri di default dei rettangoli
        sabbia = new Sabbia(this);
        
        righeScatole = 2;
        colonneScatole = 2;
    }

    /**
     * @param i
     * @return {@palline} di un undice
     */
    public Ball getBalls(int i) {
        return palline[i];
    }

    /**
     * @return sabbia
     */
    public Sabbia getSabbia() {
        return sabbia;
    }

    /**
     * @brief decrementa {@running}
     */
    public void decRunning() {
        running--;
    }

    
    /**
     * @return se sta runnando
     */
    public boolean isRunning() {
        return running > 0;
    }

    
    /**
     * @return numero delle palline
     */
    public int numBalls() {
        return palline.length;
    }

    /**
     * @param red, green, blue
     * @brief imposta il colore di default delle palline
     */
    public void setColor(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    
    /**
     * @brief incrementa la velocità di tutte le palline
     */
    public void incVel() {
        for (int i = 0; i < palline.length; i++) {
            palline[i].incVel();
        }
    }

    
    /**
     * @brief decrementa la velocità di tutte le palline
     */
    public void decVel() {
        for (int i = 0; i < palline.length; i++) {
            palline[i].decVel();
        }
    }

    
    /**
     * @param width, height
     * @param height
     * @brief imposta i parametri dello schermo (lunghezza e altezza)
     */
    public void setScreen(int width, int height) {
        sabbia.setScreen(width, height);
        for (int i = 0; i < palline.length; i++) {
            palline[i].setScreen(width, height);
        }
    }

    
    /**
     * @return valore del colore rosso
     */
    public float getRed() {
        return red;
    }

    /**
     * @return valore del colore verde
     */
    public float getGreen() {
        return green;
    }

    /**
     * @return valore del colore blu
     */
    public float getBlue() {
        return blue;
    }

    /**
     * @brief incrementa l'inclinazione x
     */
    public void incInclinazioneX(){
        if(inclinazioneX < 2.7)//se non ha inclinato più di 180 gradi
        inclinazioneX += 0.4;
    }
    
    /**
     * @brief decrementa l'inclinazione x
     */
    public void decInclinazioneX(){
        if(inclinazioneX > -3.3)//se non ha inclinato più di 180 gradi
        inclinazioneX -= 0.4;
    }
    
    /**
     * @return {@inclinazioneX}
     */
    public float getInclinazioneX(){
        return inclinazioneX;
    }
    /**
     * @brief incrementa l'inclinazione x
     */
    public void incInclinazioneY(){
        if(inclinazioneY < 2.7)//se non ha inclinato più di 180 gradi
        inclinazioneY += 0.4;
    }
    
    /**
     * @brief decrementa l'inclinazione
     */
    public void decInclinazioneY(){
        if(inclinazioneY > -3.3)//se non ha inclinato più di 180 gradi
        inclinazioneY -= 0.4;
    }
    
    /**
     * @return {@inclinazione}
     */
    public float getInclinazioneY(){
        return inclinazioneY;
    }

    public int getRigheScatole() {
        return righeScatole;
    }

    public int getColonneScatole() {
        return colonneScatole;
    }
}
