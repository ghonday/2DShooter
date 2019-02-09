package TopDown;

import java.awt.*;

public class Enemy extends GameObject{

    private Handler handle;
    protected String direction;
    protected Type type;
    protected int size;
    protected Color color;

    public Enemy(int x, int y, Type type, Handler handle){
        super(x, y, type);
        this.handle = handle;
        velX = 10;
        
    	// Based on type of enemy, we resize and recolor enemy size.
    	if( type.equals( Type.smallEnemy )) {
    		setEnemySize(0);
    		setEnemyColor(0);
    	}
    	
    	else if( type.equals( Type.mediumEnemy )) {
    		setEnemySize(1);
    		setEnemyColor(1);
    	}
    	
    	else if( type.equals( Type.largeEnemy )) {
    		setEnemySize(2);
    		setEnemyColor(2);
    	}
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
        g.setColor(getEnemyColor());
        g.fillRect(x, y, getEnemySize(), getEnemySize());
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    
    
    private void setEnemySize(int size) {
    	if( size == 0)
    		this.size = 20;
    	else if( size == 1)
    		this.size = 40;
    	else if( size == 2)
    		this.size = 80;
    }
    
    private int getEnemySize() {
    	return size;
    }
    
    private void setEnemyColor(int color) {
    	if( color == 0)
    		this.color = Color.blue;
    	else if( color == 1)
    		this.color = Color.magenta;
    	else if( color == 2)
    		this.color = Color.red;
    }
    
    private Color getEnemyColor() {
    	return color;
    }
}
