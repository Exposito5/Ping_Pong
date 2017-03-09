package ping_pong_wars;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {

    private static final int DIAMETER = 30;
    int x = 0;
    int xa = 1;
    int y = 0;
    int ya = 1;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move() {
        if (x + xa < 0) {
            xa = 1;
        }
        if (x + xa > game.getWidth() - DIAMETER) {
            game.gameOver();
        }
        if (y + ya < 0) {
            ya = 1;
        }
        if (y + ya > game.getHeight() - DIAMETER) {
            ya = -1;
        }
        if (collision1()){
            ya = -1;
            y = game.rack1.getTopX() - DIAMETER;
        }
        if (collision2()){
            ya = -1;
            y = game.rack2.getTopX() - DIAMETER;
        }

        x = x + xa;
        y = y + ya;
    }
    
    private boolean collision1() {
        return game.rack1.getBounds().intersects(getBounds());

    }
    
    private boolean collision2(){
        return game.rack2.getBounds().intersects(getBounds());        
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
