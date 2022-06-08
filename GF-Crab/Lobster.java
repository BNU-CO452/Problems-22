import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    private int speed = 2;
    private Random generator = new Random();
    
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        move(speed);
        int number = generator.nextInt(200);
        
        if(number < 20)
        {
            List<Crab> crabs = getObjectsInRange(300, Crab.class);
            
            if(crabs.size() > 0)
            {
                Crab crab = crabs.get(0);
                turnTowards(crab.getX(), crab.getY());
            }
            else
            {
                if(number < 10)
                    turn(-17);
                else
                    turn(17);
            }
        }
        
        if(isAtEdge())
            turn(30);

        if(isTouching(Crab.class))
        {
            removeTouching(Crab.class);
            Greenfoot.playSound("au.wav");
            CrabWorld world = (CrabWorld)getWorld();
            
            speed = 0;
            world.endGame();
        }
        
    }
    
}
