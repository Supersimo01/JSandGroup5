
/**
 * @version 0.1
 * @author gruppo 5
 */
class Ball {

    int rad;            // Width of the shape
    float xpos, ypos;   // Starting position of shape    
    double xspeed;      // Speed of the shape
    double yspeed;      // Speed of the shape

    int xdirection;     // Left or Right
    int ydirection;     // Top to Bottom
    int widthScreen;    // width of the screen
    int heightScreen;   // height of the screen

    Ball() {
        rad = 20;       // Width of the shape
        xspeed = 4.8;   // Speed of the shape
        yspeed = 2.2;   // Speed of the shape

        if ((int) (Math.random() * 200) % 2 == 0) {
            xdirection = 1;     // Left or Right
        } else {
            xdirection = -1;  //  Right to Left
        }
        if ((int) (Math.random() * 200) % 2 == 0) {
            ydirection = 1;  // Top to Bottom
        } else {
            ydirection = -1;  //  Bottom to Top
        }
        xpos = 0;
        ypos = 0;
        widthScreen = 0;
        heightScreen = 0;
    }

    // Move ball
    public void move() {
        // Update the position of the ball
        xpos = xpos + (float) (xspeed * xdirection);
        ypos = ypos + (float) (yspeed * ydirection);

        // Test to see if the ball exceeds the boundaries of the screen
        // If it does, reverse its direction by multiplying by -1
        if (xpos > widthScreen - rad || xpos < rad) {
            xdirection *= -1;
        }
        if (ypos > heightScreen - rad || ypos < rad) {
            ydirection *= -1;
        }
    }

    public void incVel() {
        xspeed += 0.2;
        yspeed += 0.2;
    }

    public void decVel() {
        xspeed -= 0.2;
        if (xspeed < 0) {
            xspeed = 0;
        }
        yspeed -= 0.2;
        if (yspeed < 0) {
            yspeed = 0;
        }
    }

    void setScreen(int width, int height) {
        widthScreen = width;
        heightScreen = height;
        xpos = widthScreen / 2 + (int) (Math.random() * 50);;
        ypos = heightScreen / 2;
    }

    public float getXpos() {
        return xpos;
    }

    public int getRad() {
        return rad;
    }

    public float getYpos() {
        return ypos;
    }

}
