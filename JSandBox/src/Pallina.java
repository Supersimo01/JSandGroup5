/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Marco Turati
 */
public class Pallina {
    
    private float Velocita; 
    
    private Point Posizione; 
    
    private float Dimensioni; 
    
    private Color Colore; 
    
    private boolean Visibilita; 
   
  

    public Pallina(float Velocita, Point Posizione, boolean Visibilita, float Dimensioni, Color Colore) {
      
        this.Velocita = Velocita;
        this.Posizione = Posizione;
        this.Visibilita = Visibilita;
        this.Dimensioni = Dimensioni;
        this.Colore = Colore;
    }

    
    public Pallina() {     
        StatoIniziale();
    }
    
    
    public void StatoIniziale() { //la pallina va spostata al centro
        
        Velocita = 0f;
        
        Visibilita = false;
        
        Posizione = new Point(); 
        
        Dimensioni = 10.0f;
        
        Colore = new Color(0,0, 255);
        
    }
    
    public void sposta(Point pos2) { 
        Posizione = pos2;
    }
    
    
     public void sposta(float inclinazioneAsseX) {
        
        Velocita = Math.abs(inclinazioneAsseX); //abs = absolute | x |

        if(inclinazioneAsseX > 0) //se inclinata destra, va a sinistra
            Posizione.x += (1 * Velocita);
        else
            Posizione.x += (-1 * Velocita);//se inclinata a sinistra, va a adestra
    }
     
           
    public void deletePallina() { 
        
        Visibilita = false;
    }
    
    public void showPallina() { 
        
        Visibilita = true;
    }
    
  
    public boolean Visibile() {
        return Visibilita;
    }

    public Point getPosizione() {
        return Posizione;
    }

    public float getDimensioni() {
        return Dimensioni;
    }

    public Color getColore() {
        return Colore;
    }
    
    public void visualizza() {
    }
}

