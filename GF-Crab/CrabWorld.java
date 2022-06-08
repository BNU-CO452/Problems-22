import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{
    public static final int MAXN_WORMS = 20;
    
    private Crab crab;
    private Lobster lobster;
    
    private Worm[] worms;
    private int wormSize;
    private int remainingWorms = MAXN_WORMS;
    
    private Counter score;
    
    private Random generator;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public CrabWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        crab = new Crab();
        addObject(crab, 200, 200);
        
        lobster = new Lobster();
        addObject(lobster, 600, 400);
        
        worms = new Worm[MAXN_WORMS];
        generator = new Random();
        
        wormSize = 30;
        addWorms();
        
        setupScore();
    }
    
    
    public void addWorms()
    {
        for(int index = 0; index < MAXN_WORMS; index++)
        {
            createWorm(index);
        }
    }
    
    private void createWorm(int number)
    {
        Worm worm = new Worm();
        
        int x = generator.nextInt(getWidth());
        int y = generator.nextInt(getHeight());
        
        if(x < wormSize) x = wormSize;
        if(x > getWidth() - wormSize) x = getWidth() - wormSize;
        
        if(y < wormSize) y = wormSize;
        if(y > getHeight() - wormSize) y = getHeight() - wormSize;
        
        addObject(worm, x, y);
    }
    
    public void score()
    {
        score.setValue(score.getValue() + 10);
        remainingWorms--;
        
        if(remainingWorms <= 0)
        {
            showText("Game Over: You Won!", 400, 300);    
        }
    }
    
    private void setupScore()
    {
        score = new Counter("Score: ");
        addObject (score, 60, 30);
    }
    
    public void endGame()
    {
        showText("Game Over: You have Lost!", 400, 300);
    }
}
