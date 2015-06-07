package kiloboltgame;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

/**
 * Created by maro on 6/7/15.
 */
public class StartingClass extends Applet implements Runnable, KeyListener{

    private Robot robot;
    private Image image;
    private Graphics second;
    private Image character;
    private URL base;

    @Override
    public void init() {
        setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("Q-Bot Alpha");

        try {
            base = getClass().getClassLoader().getResource("kiloboltgame");
            System.out.println("===== base ==== " + base);
        } catch (Exception e) {

        }

        // image setups
        character = getImage(base, "/home/maro/IdeaProjects/KiloboltGame/src/data/character.png");

    }

    @Override
    public void start() {
        robot = new Robot();

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void run() {
        while (true) {
            robot.update();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("move up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("move down");
                break;
            case KeyEvent.VK_LEFT:
                robot.moveLeft();
                System.out.println("move left");
                break;
            case KeyEvent.VK_RIGHT:
                robot.moveRight();
                System.out.println("move right");
                break;
            case KeyEvent.VK_SPACE:
                robot.jump();
                System.out.println("JUMP!!");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("stop moving up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("stop moving down");
                break;
            case KeyEvent.VK_LEFT:
                robot.stop();
                System.out.println("stop moving left");
                break;
            case KeyEvent.VK_RIGHT:
                robot.stop();
                System.out.println("stop moving right");
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("stop jumping!!");
                break;
        }
    }

    @Override
    public void update(Graphics g) {

        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            second = image.getGraphics();
        }

        second.setColor(getBackground());
        second.fillRect(0, 0, getWidth(), getHeight());
        second.setColor(getForeground());
        paint(second);

        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(character, robot.getCenterX() - 61, robot.getCenterY() - 63, this);
    }
}
