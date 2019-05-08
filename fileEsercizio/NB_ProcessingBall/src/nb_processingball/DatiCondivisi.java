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
    private float inclinazioneX;
    private float inclinazioneY;

    /**
     * @brief posizione y dei rettangoli nella prima colonna
     */
    private float posPrimaRiga;
    /**
     * @brief posizione y dei rettangoli nella seconda colonna
     */
    private float posSecondaRiga;
    /**
     * @brief posizione y dei rettangoli nella terza colonna
     */
    private float posTerzaRiga;
    /**
     * @brief posizione x dei rettangoli nella prima riga
     */
    private float posPrimaColonna;
    /**
     * @brief posizione x dei rettangoli nella seconda riga
     */
    private float posSecondaColonna;
    /**
     * @brief posizione x dei rettangoli nella terzza riga
     */
    private float posTerzaColonna;
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
        inclinazioneX = 0;
        inclinazioneY = 0;
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
        posPrimaRiga = 0;
        posSecondaRiga = 115;
        posTerzaRiga = 230;
        posPrimaColonna = 0;
        posSecondaColonna = 115;
        posTerzaColonna = 230;
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
     * @brief incrementa l'inclinazione x
     */
    public void incInclinazioneX(){
        inclinazioneX += 0.4;
    }
    
    /**
     * @brief decrementa l'inclinazione x
     */
    public void decInclinazioneX(){
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
        inclinazioneY += 0.4;
    }
    
    /**
     * @brief decrementa l'inclinazione
     */
    public void decInclinazioneY(){
        inclinazioneY -= 0.4;
    }
    
    /**
     * @return {@inclinazione}
     */
    public float getInclinazioneY(){
        return inclinazioneY;
    }
    
    /**
     * @return valore posizione della prima riga
     */
    public float getPosPrimaRiga() {
        return posPrimaRiga;
    }

    
    /**
     * @return valore posizione della seconda riga
     */
    public float getPosSecondaRiga() {
        return posSecondaRiga;
    }

    
    /**
     * @return valore posizione prima colonna
     */
    public float getPosPrimaColonna() {
        return posPrimaColonna;
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

    /**
     * @return posizione terza riga
     */
    public float getPosTerzaRiga() {
        return posTerzaRiga;
    }
    
    /**
     * @return posizione seconda colonna
     */
    public float getPosSecondaColonna() {
        return posSecondaColonna;
    }

    /**
     * @return posizione terza colonna
     */
    public float getPosTerzaColonna() {
        return posTerzaColonna;
    }
}
