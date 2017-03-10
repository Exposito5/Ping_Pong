package ping_pong_wars;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

    Ball ball = new Ball(this);
    Racquet1 rack1 = new Racquet1(this);
    Racquet2 rack2 = new Racquet2(this);

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                rack1.keyReleased(e);
                rack2.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                rack1.keyPressed(e);
                rack2.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    private void move() {
        ball.move();
        rack1.move();
        rack2.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        rack1.paint(g2d);
        rack2.paint(g2d);
    }
    
    public void gameOver () {
        JOptionPane.showMessageDialog(this, "GAME OVER","GAME OVER",JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame window = new JFrame("World of War in the Ping Pong");
        Game game = new Game();
        window.add(game);
        window.setSize(800, 500);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
