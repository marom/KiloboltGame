package kiloboltgame;

import java.awt.*;

/**
 * Created by maro on 6/7/15.
 */
public class Tile {

    private int tileX, tileY, speedX, type;
    public Image tileImage;
    private Rectangle r;

    private Robot robot = StartingClass.getRobot();
    private Background bg = StartingClass.getBg1();

    public Tile(int x, int y, int typeInt) {
        tileX = x * 40;
        tileY = y * 40;

        type = typeInt;

        r = new Rectangle();

        if (type == 5) {
            tileImage = StartingClass.tiledirt;
        } else if (type == 8) {
            tileImage = StartingClass.tilegrassTop;
        } else if (type == 4) {
            tileImage = StartingClass.tilegrassLeft;

        } else if (type == 6) {
            tileImage = StartingClass.tilegrassRight;

        } else if (type == 2) {
            tileImage = StartingClass.tilegrassBot;
        } else {
            type = 0;
        }

    }

    public void update() {
        speedX = bg.getSpeedX() * 5;
        tileX += speedX;
        r.setBounds(tileX, tileY, 40, 40);

        if (type != 0) {
            checkVerticleCollision(Robot.rect, Robot.rect2);
        }
    }

    public void checkVerticleCollision(Rectangle rtop, Rectangle rbot) {
        if (rtop.intersects(r)) {
            System.out.println("upper collision");
        }
        if (rbot.intersects(r)) {
            System.out.println("lower collision");
        }
    }

    public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }

    public Image getTileImage() {
        return tileImage;
    }

    public void setTileImage(Image tileImage) {
        this.tileImage = tileImage;
    }

}
