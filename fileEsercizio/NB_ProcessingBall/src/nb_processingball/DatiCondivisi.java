/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb_processingball;

/**
 *
 * @author scuola
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
     * @brief costruttore con parametri
     * @param numBalls
     * @param width
     * @param height 
     */
    public DatiCondivisi(int numBalls, int width, int height) {

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
