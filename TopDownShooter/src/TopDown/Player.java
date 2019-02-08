package TopDown;

import java.awt.*;

public class Player extends GameObject {

    private Handler handle;
    private int health;

    public Player(int x, int y, Type type, Handler handle) {
        super(x, y, type);
        this.handle = handle;
        health = 100;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        //Movement
        if (handle.isUp() && y > 0)
            velY = -3;
        else if (!handle.isDown())
            velY = 0;

        if (handle.isDown() && y < Game.HEIGHT - 80)
            velY = 3;
        else if (!handle.isUp())
            velY = 0;

        if (handle.isRight() && x < Game.WIDTH - 55) {
            velX = 3;
        }
        else if (!handle.isLeft())
            velX = 0;

        if (handle.isLeft() && x > 0)
            velX = -3;
        else if (!handle.isRight())
            velX = 0;

        if (handle.isLeft() && handle.isRight())
            velX = 0;

        if (handle.isUp() && handle.isDown())
            velY = 0;

        if (x == Game.WIDTH - 40)
            velX = 0;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 40, 40);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 40, 40);
    }
}
