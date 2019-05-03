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

    static DatiCondivisi datiC; // dati condivisi
    /** vettore con i threads */
    static ThBall[] threadPalline;   
    /** numero di balls e di thread */
    static int numBalls;        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        numBalls = 1;
        datiC = new DatiCondivisi(numBalls);
        threadPalline = new ThBall[numBalls];
        for (int i = 0; i < threadPalline.length; i++) {
            threadPalline[i] = new ThBall(datiC, i);
        }

        PApplet.main(new String[]{"nb_processingball.NB_ProcessingBall"});

        SwingGui swingGui = new SwingGui(datiC);
        // shows Swing windows
        swingGui.show();
    }

    /**
     * @brief configura le impostazioni di default del gioco
     */
    public void settings() {
        size(230, 115);//imposta la grandezza dello schermo
        datiC.setScreen(width, height);//la salva su dati condivisi
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
        if (!datiC.isRunning()) {
            exit();
        }

         /** pulsice lo schermo */
        background(datiC.getRed(), datiC.getGreen(), datiC.getBlue());//imposta il colore di default

         /** fa apparire tutte le palline */
        for (int i = 0; i < datiC.numBalls(); i++) {
         /** aggiunge la palline da disegnare */
            display(datiC.getBalls(i));
        }
    }


    /**
     * @brief disegna le palline
     * @param ball 
     */
    void display(Ball ball) {
         /** imposta il colore dei rettangoli */
        fill(color(200, 200, 200));
         /**disegna il rettangolo di sinistra */
        rect(0, 0, 115, 115, 16);
         /** disegna il rettangolo di destra */
        rect(115, 0, 115, 115, 16);
         /** imposta il colore della pallina */
        fill(color(240, 0, 0));
        /**disegna le palline */
        ellipse(ball.getXpos(), ball.getYpos(), ball.getRad(), ball.getRad());
    }
}
