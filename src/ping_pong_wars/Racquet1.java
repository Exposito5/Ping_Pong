package ping_pong_wars;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Racquet1 {

    int y = 0;
    int ya = 0;
    private Game game;
    
    public Racquet1(Game game) {
        this.game = game;
    }
    
    public void move() {
        if (y + ya > 0 && y + ya < game.getHeight()-60)
            y = y + ya;
    }
    
    public void paint (Graphics2D g) {
        g.fillRect(25, y, 10, 60);
    }
    
    public void keyReleased(KeyEvent e) {
        ya = 0;
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
            ya = -1;
        if (e.getKeyCode() == KeyEvent.VK_S)
            ya = 1;
    }
}
