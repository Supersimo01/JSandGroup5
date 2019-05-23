/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb_processingball;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamarque_matteo
 */
public class ThSabbia extends Thread{
    
    private DatiCondivisi dc;
    private Sabbia sabbia;

    /**
     * @brief costruttore con parametri
     * @param dati 
     */
    public ThSabbia(DatiCondivisi dati) {
            this.dc = dati;
            sabbia = dc.getSabbia();
    }

    /**
     * @brief muove la sabbia
     */
     public void run() {
        try {
            for (int i = 0; i < 2000; i++) {
                Thread.sleep(10);
                
                if(sabbia.ifBordoOrizz() != 0){//controlla se ha raggiunto il bordo orizzontale
                    if(sabbia.ifBordoOrizz() == -1 && dc.getInclinazioneX() > 0)//se è stato inclinato dall'altra parte
                        sabbia.moveX();
                    else if(sabbia.ifBordoOrizz() == 1 && dc.getInclinazioneX() < 0)
                        sabbia.moveX();
                }
                else//se non l'ha raggiunto muove la pallina
                    sabbia.moveX();
                if(sabbia.ifBordoVert() != 0){//controlla se ha raggiunto il bordo verticale
                    if(sabbia.ifBordoVert() == -1 && dc.getInclinazioneY() > 0)//se è stato inclinato dall'altra parte
                        sabbia.moveY();
                    else if(sabbia.ifBordoVert() == 1 && dc.getInclinazioneY() < 0)
                        sabbia.moveY();
                }
                else//se non l'ha raggiunto muove la pallina
                    sabbia.moveY();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThBall.class.getName()).log(Level.SEVERE, null, ex);
        }
        dc.decRunning();
    }
}
