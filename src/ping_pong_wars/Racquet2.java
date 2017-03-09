package ping_pong_wars;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet2 {

    private static final int X = 775;
    private static final int HEIGHT = 60;
    private static final int WIDTH = 10;
    int y = 0;
    int ya = 0;
    private Game game;
    
    public Racquet2(Game game) {
        this.game = game;
    }
    
    public void move() {
        if (y + ya > 0 && y + ya < game.getHeight()-WIDTH)
            y = y + ya;
    }
    
    public void paint (Graphics2D g) {
        g.fillRect(750, y, 10, 60);
    }
    
    public void keyReleased(KeyEvent e) {
        ya = 0;
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
            ya = -1;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            ya = 1;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(X, y, WIDTH, HEIGHT);
    }
    public int getTopX(){
        return X - WIDTH;
    }
}
