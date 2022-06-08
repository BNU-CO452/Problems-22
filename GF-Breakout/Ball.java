import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Move the ball around the screen using the 
 * inbuilt tutrle graphics.  Ball has a chosen 
 * image.
 * 
 * @author Derek Peacock 
 * @version 0
 */
public class Ball extends ShapeSprite
{
    private GameWorld game;
    private int speed = 4;
    
    // Current velocity change in x and y
    
    private int dx;
    private int dy;
    
    public Ball(int width, int height)
    {
        super(Shapes.Oval, width, height);
        
        dx = speed; dy = speed;
        turn(45);
    }
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        game = (GameWorld)getWorld();
        
        int x = getX(); int y = getY();
        
        if(x >= game.getWidth() - width) 
        {
            dx = -speed; 
        }
        
        if(y >= game.getHeight() - height)
        {
            dy = -speed;
        }
        
        if(x <= 0)
        {
            dx = 0;
            dy = 0;
            
            game.endGame(false);
        }
        
        if(y <= 0)
        {
            dy = speed;
        }
        
        checkCollisions();
        
        setLocation(x + dx, y + dy);
    }
    
    private void checkCollisions()
    {
        if(getOneIntersectingObject(Paddle.class) != null)
        {
            dx = speed;
            Greenfoot.playSound("pong.wav");
            return;
        }
        
        if(getOneIntersectingObject(Brick.class) != null)
        {
            removeTouching(Brick.class);
            game.increaseScore();
            Greenfoot.playSound("pong.wav");
            
            dx = -dx;
        }
    }
}
