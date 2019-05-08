/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb_processingball;

import processing.core.PApplet;


/**
 * @author Turati
 */

public class NB_ProcessingBall extends PApplet {

    static DatiCondivisi dc; // dati condivisi
    /** vettore con i threads */
    static ThBall[] threadPalline;   
    /** numero di balls e di thread */
    static int numBalls;        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        numBalls = 1;
        dc = new DatiCondivisi(numBalls,0,0,115,115,16,115,115,115,115,16);
        threadPalline = new ThBall[numBalls];
        for (int i = 0; i < threadPalline.length; i++) {
            threadPalline[i] = new ThBall(datiC, i);
        }

        PApplet.main(new String[]{"nb_processingball.NB_ProcessingBall"});

        SwingGui swingGui = new SwingGui(dc);
        // shows Swing windows
        swingGui.show();
    }

    /**
     * @brief configura le impostazioni di default del gioco
     */
    public void settings() {
        size(230, 115);//imposta la grandezza dello schermo
        dc.setScreen(width, height);//la salva su dati condivisi
        for (int i = 0; i < threadPalline.length; i++) {//fa partire ogni thread di palline
            threadPalline[i].start();
        }
    }

    /**
     * @brief configura le impostazioni di resa grafica
     */
    public void setup() {
        /** imposta il frame rate */
        frameRate(30);
        /** imposta gli ellissi come circonferenze */
        ellipseMode(RADIUS); 
    }

    /**
     * @brief classe usata per impostare il colore di sfondo e le palline
     */
    public void draw() {
        if (!dc.isRunning()) {
            exit();
        }

         /** pulsice lo schermo */
        background(dc.getRed(), dc.getGreen(), dc.getBlue());//imposta il colore di default

         /** fa apparire tutte le palline */
        for (int i = 0; i < dc.numBalls(); i++) {
         /** aggiunge la palline da disegnare */
            display(dc.getBalls(i));
        }
    }


    /**
     * @brief disegna le palline
     * @param ball 
     */
    void display(Ball ball) { //terminare variabili condivise
         /** imposta il colore dei rettangoli */
        fill(color(200, 200, 200));
         /**disegna il rettangolo di sinistra */
        rect(dc.getQ1posAsseXRect(), dc.getQ1posAsseYRect(), dc.getQ1radRect1(), dc.getQ1radRect2(), 16);
         /** disegna il rettangolo di destra */
        rect(dc.getQ2posAsseXRect(), dc.getQ2posAsseYRect(), gdc.etQ2radRect1(), getQ2radRect2(), 16);
         /** imposta il colore della pallina */
        fill(color(240, 0, 0));
        /**disegna le palline */
        ellipse(ball.getXpos(), ball.getYpos(), ball.getRad(), ball.getRad());
    }
}
