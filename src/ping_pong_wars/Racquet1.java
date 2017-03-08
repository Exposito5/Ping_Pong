package ping_pong_wars;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Racquet1 {

    int x = 0;
    int xa = 0;
    private Game game;
    
    public Racquet1(Game game) {
        this.game = game;
    }
    
    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth()-60)
            x = x + xa;
    }
    
    public void paint (Graphics2D g) {
        g.fillRect(x, 330, 60, 10);
    }
    
    public void keyReleased(KeyEvent e) {
        xa = 0;
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 1;
    }
}
