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
    /** vettore con i threads di palline */
    static ThBall[] threadPalline;   
    /** thread di sabbia*/
    static ThSabbia threadSabbia;   
    /** numero di balls e di thread */
    static int numBalls;        
    /** sabbia **/
    static Sabbia sabbia;
    /** matrice di scatole **/
    static Scatola[][] matScatole;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        numBalls = 1;
        dc = new DatiCondivisi(numBalls);
        threadPalline = new ThBall[numBalls];//crea il vettore thread che gestiscono le palline
        threadSabbia = new ThSabbia(dc);//crea il thread che gestisce la sabbia
        threadSabbia.start();
        for (int i = 0; i < threadPalline.length; i++) {
            threadPalline[i] = new ThBall(dc, i);
        }

        sabbia = dc.getSabbia();
        matScatole = new Scatola[dc.getRigheScatole()][dc.getColonneScatole()];
        for(int i = 0; i < dc.getColonneScatole(); i++){
            for(int j = 0; j < dc.getRigheScatole(); j++){
                //imposta le posizioni iniziali
                matScatole[i][j] = new Scatola(i * 115, j * 115);
            }
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
        size(dc.getColonneScatole()*115, dc.getRigheScatole()*115);//imposta la grandezza dello schermo
        dc.setScreen(dc.getColonneScatole()*115, dc.getRigheScatole()*115);//la salva su dati condivisi
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

         /** pulsice lo schermo */
        background(dc.getRed(), dc.getGreen(), dc.getBlue());//imposta il colore di default

         /** fa apparire tutte le palline */
        for (int i = 0; i < dc.numBalls(); i++) {
         /** aggiunge la palline da disegnare */
            display(dc.getBalls(i), sabbia);
        }
    }


    /**
     * @brief disegna le palline
     * @param ball 
     */
    void display(Ball ball, Sabbia s) { //terminare variabili condivise
         // imposta il colore dei rettangoli
        fill(color(200, 200, 200));
         //disegna il primo rettangolo
        for(int i = 0; i < dc.getColonneScatole(); i++){
            for(int j = 0; j < dc.getRigheScatole(); j++){
                rect(matScatole[i][j].getPosX(), matScatole[i][j].getPosY(), 115, 115, 6);
            }
        }
        //imposta il colore della pallina
        //disegna la sabbia
        fill(color(194,178,128));
        //disegna la sabbia
        pushStyle();
        noStroke();
        rect(s.getX(), s.getY(), 115, 115, 6);
        popStyle();
        // disegna le palline
        fill(color(dc.getRed(), dc.getGreen(), dc.getBlue()));
        ellipse(ball.getXpos(), ball.getYpos(), ball.getRad(), ball.getRad());
    }
}
