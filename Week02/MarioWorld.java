import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        DrawPath();
    }
    
    /**
     * Create a path at the bottom of the screen which is
     * 2 tiles high and goes right across the whole widh of
     * the screen.
     */
    private void DrawPath()
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
        
    }
}
