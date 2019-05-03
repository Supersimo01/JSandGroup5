package nb_processingball;

import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;

public class ThBall extends Thread {

    DatiCondivisi datiC;
    int idBall;

    public ThBall(DatiCondivisi dati, int idBall) {
            this.datiC = dati;
            this.idBall = idBall;
    }

    public void run() {
        try {
            Ball ball = datiC.getBalls(idBall);
            for (int i = 0; i < 2000; i++) {
                Thread.sleep(10);
                ball.move();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThBall.class.getName()).log(Level.SEVERE, null, ex);
        }
        datiC.decRunning();
    }
}
