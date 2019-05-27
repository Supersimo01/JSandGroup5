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
    
    double yspeed;      // Speed of the shape

    
    
    int widthScreen;    
    int heightScreen;   

    /**
     * @brief costruttore con parametri
     * @param datiCondivisi 
     */
    Ball(DatiCondivisi datiCondivisi) {
        dataC = datiCondivisi;
        rad = 20;       // Width of the shape
        xspeed = 1;   // Speed of the shape
        yspeed = 1;   // Speed of the shape
        xpos = 35;//imposta la posizione della pallina sull'asse x
        ypos = 57;//imposta la posizione della pallina sull'asse y
        widthScreen = 0;
        heightScreen = 0;
    }

    /**
     * @brief muove la pallina in orizzontale
     */
    public void moveX() {
            // Aggiorna la posizione della pallina
            xpos = xpos + (float) (xspeed  * dataC.getInclinazioneX());
    }
    
    /**
     * @brief muove la pallina in verticale
     */
    public void moveY() {
            // Aggiorna la posizione della pallina
            ypos = ypos + (float) (yspeed * dataC.getInclinazioneY());
    }
    
    /**
     * @return -1, se la pallina ha raggiunto il bordo sinistro
     * @return 1, se la pallina ha raggiunto il bordo destro
     * @return 0, se la pallina non ha raggiunto il bordo
     */
    public int ifBordoOrizz(){
        if(xpos > widthScreen - rad)
            return 1;
        else if(xpos < rad)
            return -1;
        return 0;
    }
    
    /**
     * @return -1, se la pallina ha raggiunto il bordo alto
     * @return 1, se la pallina ha raggiunto il bordo basso
     * @return 0, se la pallina non ha raggiunto il bordo
     */
    public int ifBordoVert(){
        if(ypos > heightScreen - rad)
            return 1;
        else if(ypos < rad)
            return -1;
        return 0;
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
