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
                
                if(ball.ifBordoOrizz() != 0){//controlla se ha raggiunto il bordo orizzontale
                    if(ball.ifBordoOrizz() == -1 && datiC.getInclinazioneX() > 0)//se è stato inclinato dall'altra parte
                        ball.moveX();
                    else if(ball.ifBordoOrizz() == 1 && datiC.getInclinazioneX() < 0)
                        ball.moveX();
                }
                else//se non l'ha raggiunto muove la pallina
                    ball.moveX();
                if(ball.ifBordoVert() != 0){//controlla se ha raggiunto il bordo verticale
                    if(ball.ifBordoVert() == -1 && datiC.getInclinazioneY() > 0)//se è stato inclinato dall'altra parte
                        ball.moveY();
                    else if(ball.ifBordoVert() == 1 && datiC.getInclinazioneY() < 0)
                        ball.moveY();
                }
                else//se non l'ha raggiunto muove la pallina
                    ball.moveY();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThBall.class.getName()).log(Level.SEVERE, null, ex);
        }
        datiC.decRunning();
    }
}
