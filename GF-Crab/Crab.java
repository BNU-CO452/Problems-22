import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingSprite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crab extends Actor
{
    protected int width;
    protected int height;
    
    protected int speed = 3;
    protected int turnAngle = 4;
    
    protected GreenfootImage image;
    
    private CrabWorld world;
    
    public Crab()
    {
        image = getImage();
        
        width = image.getWidth();
        height = image.getHeight();
        image.scale((int)(width * 0.8), (int)(height * 0.8));
        
        setRotation(90);
    }
    
    /**
     * Act - do whatever the MovingSprite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move4Ways();
        
        if(isTouching(Worm.class))
        {
            removeTouching(Worm.class);
            Greenfoot.playSound("slurp.wav");
    
            world = (CrabWorld)getWorld();
            world.score();
        }
    }
    
    public void moveAndTurn()
    {
        int x = getX(); int y = getY();
        int halfWidth = width / 2;
        
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-turnAngle);
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            turn(turnAngle);
        }  
        
        move(speed);
    }
    
    /**
     * This method moves the paddle around in four directions
     * left, right, up and down using coordinate positions.  
     */
    public void move4Ways()
    {
        int x = getX(); int y = getY();
        int halfWidth = width / 2;
        
        if(Greenfoot.isKeyDown("left") && x > halfWidth)
        {
            setRotation(270);
            x -= speed;
        }
        
        if(Greenfoot.isKeyDown("right") && !isAtEdge())
        {
            setRotation(90);
            x += speed;
        }        
        
        if(Greenfoot.isKeyDown("down") && !isAtEdge())
        {
            setRotation(180);
            y += speed;
        } 
        
        if(Greenfoot.isKeyDown("up") && y > speed)
        {
            setRotation(0);
            y -= speed;
        }
        
        setLocation(x, y);
    }
}
