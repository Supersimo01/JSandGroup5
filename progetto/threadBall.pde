import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;

/**
 * @version 0.1
 * @author gruppo 5
 */
class threadBall extends Thread {

    dataStorage datiC;
    int idBall;

    public threadBall(dataStorage dati, int idBall) {
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
            Logger.getLogger(threadBall.class.getName()).log(Level.SEVERE, null, ex);
        }
        datiC.decRunning();
    }
}
