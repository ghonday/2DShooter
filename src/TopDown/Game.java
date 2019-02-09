package TopDown;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private boolean isRunning;
    private Thread thread;
    private Handler handle;
    private State state;
    private Menu menu;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 750;

    public Game() {
        isRunning = false;
        handle = new Handler();
        menu = new Menu();
        state = State.Game;
        this.addKeyListener(new KeyControls(handle));
        new Window(WIDTH, HEIGHT, "Shooter", this);
        start();
        beginGame();
    }

    public void beginGame() {
        handle.addObject(new Player(100, 300, Type.player, handle));
        handle.addObject(new Enemy(100, 300, Type.smallEnemy, handle));
        
        // Testing Adding Enemies
     /* handle.addObject(new Enemy(x, y, Type.(object), handle)); */
        handle.addObject(new Enemy(200, 300, Type.mediumEnemy, handle));
        handle.addObject(new Enemy(300, 300, Type.largeEnemy, handle));
    }

    public void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void firstLvl() {
        for (int i = 0; i < WIDTH; i += 10) {
            handle.addObject(new Wall(i, 0, Type.wall, handle));
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning == true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    public void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        if (state == state.Game)
            handle.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics2D g = (Graphics2D) bs.getDrawGraphics();

        if (state == State.Menu) {
            menu.render(g);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.WHITE);
            g.drawString("Health:", 100, 100);
            handle.render(g);
        }
        g.dispose();
        bs.show();
    }

    public static void main(String args[]) {
        new Game();
    }
}
