
/**
 * @version 0.1
 * @author gruppo 5
 */
class dataStorage {

    //  An array of balls
    private Ball[] balls;
    private int running;
    private float red;
    private float green;
    private float blue;

    public dataStorage(int numBalls, int width, int height) {

        balls = new Ball[numBalls];
        // Set the starting position of the balls
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball();
        }
        running = numBalls;
        red = 64;
        green = 64;
        blue = 64;
    }

    dataStorage(int numBalls) {
        balls = new Ball[numBalls];
        // Set the starting position of the balls
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball();
        }
        running = numBalls;
        red = 64;
        green = 0;
        blue = 64;
    }

    public Ball getBalls(int i) {
        return balls[i];
    }

    public void decRunning() {
        running--;
    }

    public boolean isRunning() {
        return running > 0;
    }

    public int numBalls() {
        return balls.length;
    }

    public void setColor(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void incVel() {
        for (int i = 0; i < balls.length; i++) {
            balls[i].incVel();
        }
    }

    public void decVel() {
        for (int i = 0; i < balls.length; i++) {
            balls[i].decVel();
        }
    }

    public void setScreen(int width, int height) {
        for (int i = 0; i < balls.length; i++) {
            balls[i].setScreen(width, height);
        }
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }

}
