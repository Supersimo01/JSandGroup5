package nb_processingball;

/**
 * @author Turati
 */

/**
 * Class Ball: this class summarizes all the specifications of a ball and his method,
 * wich are used to move it on the screen.
 */
public class Ball {
/**  */
    DatiCondivisi dataC;
/**  Width of the shape */
    int rad;           
/**  Position on the x axis */
    float xpos;
/**  Position on the y axis */
    float ypos;   
/**  Speed of the shape */    
    double xspeed;
    
    //double yspeed;      // Speed of the shape

  /** Direction of the ball on the x axis (Left or Right) */
    int xdirection;   
    
    //int ydirection;     // Top to Bottom
    
    int widthScreen;    
    int heightScreen;   

    /**
     * @brief costruttore con parametri
     * @param datiCondivisi 
     */
    Ball(DatiCondivisi datiCondivisi) {
        dataC = datiCondivisi;
        rad = 20;       // Width of the shape
        xspeed = 4.8;   // Speed of the shape
        //yspeed = 2.2;   // Speed of the shape

        if ((int) (Math.random() * 200) % 2 == 0) {
            xdirection = 1;     // Left to Right
        } else {
            xdirection = -1;  //  Right to Left
        }
        //if ((int) (Math.random() * 200) % 2 == 0) {
            //ydirection = 1;  // Top to Bottom
        //} else {
           // ydirection = -1;  //  Bottom to Top
        //}
        xpos = 35;//imposta la posizione della pallina sull'asse x
        ypos = 57;//imposta la posizione della pallina sull'asse y
        widthScreen = 0;
        heightScreen = 0;
    }

    /**
     * @brief Method used to move the ball, updating the positions on the axis
     */
    public void move() {
        // Aggiornare la posizione della pallina
        xpos = xpos + (float) (xspeed * xdirection * dataC.getInclinazione());
        //ypos = ypos + (float) (yspeed * ydirection);

        
        // Controlla se la pallina ha raggiunto il bordo dello schermo
        //Se l'ha raggiunto si blocca
        if (xpos > widthScreen - rad || xpos < rad) {
            xdirection *= 0;
        }
        
        //if (ypos > heightScreen - rad || ypos < rad) {
          //  ydirection *= -1;
       // }xdirection = 
    }
    
    /**
     * @brief Method that increase the speed 
     */
    public void incVel() {
        xspeed += 0.2;
        //yspeed += 0.2;
    }
    
    /**
     * @brief Method that decrease the speed 
     */
    public void decVel() {
        xspeed -= 0.2;
        if (xspeed < 0) {
            xspeed = 0;
        }
        /*
        yspeed -= 0.2;
        if (yspeed < 0) {
            yspeed = 0;
        }
        */
    }
    
    /**
     * @brief Method that set the width and the height of the screen
     * @param width is the new width
     * @param height is the new height
     */
    void setScreen(int width, int height) {
        widthScreen = width;
        heightScreen = height;
    }

   /**
     * @return xpos the position of the ball on the x axis 
     */
    public float getXpos() {
        return xpos;
    }
    
    /**
     * @return rad the width of the ball
     */
    public int getRad() {
        return rad;
    }
    
    /**
     * @return xpos the position of the ball on the y axis 
     */
    public float getYpos() {
        return ypos;
    }
}
