package TopDown;

import java.awt.*;

public class Enemy extends GameObject{

    private Handler handle;

    public Enemy(int x, int y, Type type, Handler handle){
        super(x, y, type);
        this.handle = handle;
        velX = 10;
    }

    public void followLogic(){

    }


    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (x > Game.WIDTH){
            x = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(x, y, 20, 20);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
