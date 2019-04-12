/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import processing.core.PApplet;
import javafx.application.Application;

/**
 * @version 0.1
 * @author gruppo 5
 */
public class esercizio extends PApplet{

  static dataStorage datiC; // dati condivisi
  static threadBall[] thBalls;    // vettore con i threads
  static int numBalls;        // numero di balls e di thread

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    numBalls = 2;
    datiC = new dataStorage(numBalls);
    thBalls = new threadBall[numBalls];
    for (int i = 0; i < thBalls.length; i++) {
      thBalls[i] = new threadBall(datiC, i);
    }

    PApplet.main(new String[]{"nb_processingball.NB_ProcessingBall"});

    swingCode swingGui = new swingCode(datiC);
    // shows Swing windows
    swingGui.show();
  }

  public void settings() {
    size(640, 360);
    datiC.setScreen(width, height);
    for (int i = 0; i < thBalls.length; i++) {
      thBalls[i].start();
    }
  }

  public void setup() {
    noStroke();
    frameRate(30);
    ellipseMode(RADIUS);
  }

  public void draw() {
    if (!datiC.isRunning()) {
      exit();
    }

    // clean the screen
    background(datiC.getRed(), datiC.getGreen(), datiC.getBlue());

    // display all "balls"
    for (int i = 0; i < datiC.numBalls(); i++) {
      display(datiC.getBalls(i));
    }
  }

  // Draw ball
  void display(Ball ball) {
    // set the color of the ball
    fill(color(240, 0, 0));
    noStroke();

    // Draw the ball
    ellipse(ball.getXpos(), ball.getYpos(), ball.getRad(), ball.getRad());
  }
}
