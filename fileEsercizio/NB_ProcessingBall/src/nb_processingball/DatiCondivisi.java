/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb_processingball;

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
    private float inclinazione;

    /**
     * @brief posizione del primo rettangolo sull'asse x
     */
    private float posX1;
    /**
     * @brief posizione del secondo rettangolo sull'asse x
     */
    private float posX2;
    /**
     * @brief posizione del primo rettangolo sull'asse y
     */
    private float posY1;
    /**
     * @brief posizione del secondo rettangolo sull'asse y
     */
    private float posY2;
    /**
     * @brief radiante dei rettangoli
     */
    private float radRect;
    /**
     * @brief smussatura dei rettangoli
     */
    private float smussatura;
            
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
        inclinazione = 0;
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
        inclinazione = 0;
        
        //set parametri di default dei rettangoli
        posX1 = 0;
        posX2 = 115;
        posY1 = 0;
        posY2 = 0;
        radRect = 115;
        smussatura = 6;
    }

    /**
     * @param i
     * @return {@palline} di un undice
     */
    public Ball getBalls(int i) {
        return palline[i];
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
     * @brief imposta i parametri dello schermo (lunghezza e altezza)
     */
    public void setScreen(int width, int height) {
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
     * @brief incrementa l'inclinazione
     */
    public void incInclinazione(){
        inclinazione += 0.4;
    }
    
    /**
     * @brief decrementa l'inclinazione
     */
    public void decInclinazione(){
        inclinazione -= 0.4;
    }
    
    /**
     * @return {@inclinazione}
     */
    public float getInclinazione(){
        return inclinazione;
    }
    
    /**
     * @return valore posizione nell'asse x del primo rettangolo
     */
    public float getPosX1() {
        return posX1;
    }

    
    /**
     * @return valore posizione nell'asse x del secondo rettangolo
     */
    public float getPosX2() {
        return posX2;
    }

    
    /**
     * @return valore posizione nell'asse y del primo rettangolo
     */
    public float getPosY1() {
        return posY1;
    }

    
    /**
     * @return valore posizione nell'asse y del secondo rettangolo
     */
    public float getPosY2() {
        return posY2;
    }
    
    /**
     * @return valore posizione del radiante dei rettangoli
     */
    public float getRadRect() {
        return radRect;
    }

    /**
     * @return valore smussatorua dei rettangoli
     */
    public float getSmussatura() {
        return smussatura;
    }
}
