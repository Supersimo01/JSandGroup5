/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb_processingball;

/**
 * @version 0.1
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
    
    private float q1posAsseXRect;
    private float q1posAsseYRect;
    private float q1radRect1;
    private float q1radRect2;
    private float q2posAsseXRect;
    private float q2posAsseYRect;
    private float q2radRect1;
    private float q2radRect2;

    public float getQ1posAsseXRect() {
        return q1posAsseXRect;
    }

    public float getQ1posAsseYRect() {
        return q1posAsseYRect;
    }

    public float getQ1radRect1() {
        return q1radRect1;
    }

    public float getQ1radRect2() {
        return q1radRect2;
    }

    public float getQ2posAsseXRect() {
        return q2posAsseXRect;
    }

    public float getQ2posAsseYRect() {
        return q2posAsseYRect;
    }

    public float getQ2radRect1() {
        return q2radRect1;
    }

    public float getQ2radRect2() {
        return q2radRect2;
    }

    
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
    }

    public Ball getBalls(int i) {
        return palline[i];
    }

    public void decRunning() {
        running--;
    }

    public boolean isRunning() {
        return running > 0;
    }

    public int numBalls() {
        return palline.length;
    }

    public void setColor(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void incVel() {
        for (int i = 0; i < palline.length; i++) {
            palline[i].incVel();
        }
    }

    public void decVel() {
        for (int i = 0; i < palline.length; i++) {
            palline[i].decVel();
        }
    }

    public void setScreen(int width, int height) {
        for (int i = 0; i < palline.length; i++) {
            palline[i].setScreen(width, height);
        }
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

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
}
