/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb_processingball;

/**
 *
 * @author lamarque_matteo
 */
public class Scatola {
    private float posX;//posizione dell'asse y
    private float posY;//posizione dell'asse x
    static float smussatura;
    
    public Scatola(float x, float y){
        posX = x;
        posY = y;
        smussatura = 6;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosizioneY(float y) {
        posY = y;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosizioneX(float x) {
        posX = x;
    }
}
