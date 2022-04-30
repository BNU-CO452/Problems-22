import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;

/**
 * A new version of the Mario Game which just contains
 * a platform for Mario to walk left to right.
 * 
 * @author Derek Peacock 
 * @version 1.0
 */
public class MarioWorld extends World
{
    public static final int MAXN_COLUMNS = 24;
    public static final int MAXN_ROWS = 20;
    public static final int TILE_SIZE = 30;
    
    /**
     * Setup the world with MAXN_COLUMNS x MAXN_ROWS
     * of tiles, with a tiles being squares TILE_SIZE pixels
     * 
     */
    public MarioWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(MAXN_COLUMNS, MAXN_ROWS, TILE_SIZE); 
        
        drawPath();
        
        String reply = Greenfoot.ask("Enter the pyramid height (1-8) > ");
        int height = Integer.parseInt(reply);
        
        drawPyramids(height);
    }
    
    /**
     * Create a path at the bottom of the screen which is
     * 2 tiles high and goes right across the whole widh of
     * the screen.
     */
    private void drawPath()
    {
        int yStart = MAXN_ROWS - 1; // 19
        int yEnd = MAXN_ROWS - 2; // 18
        
        for(int y = yStart; y >= yEnd; y--)
        {
            for(int x = 0; x < MAXN_COLUMNS; x++)
            {
                Brick brick = new Brick();
                addObject(brick, x, y);
            }
        }
    }
    
    /**
     * Draw a pyramid in the middle of the path
     */
    private void drawPyramids(int height)
    {
        int yStart = MAXN_ROWS - 3;
        int yEnd = yStart - height;
        
        int xStart1 = (MAXN_COLUMNS - ((height * 2) + 2))/2;
        int xStart2 = xStart1 + height + 2;
        
        for(int y = yStart; y > yEnd; y--)
        {
            for(int x = xStart1; x < (xStart1 + height); x++)
            {
                Brick brick = new Brick();
                addObject(brick, x, y);
            }
            
            for(int x = xStart2 ; x < (xStart2 + height); x++)
            {
                Brick brick = new Brick();
                addObject(brick, x, y);
            }

            height--;
            xStart1++;
        }
    }
}
