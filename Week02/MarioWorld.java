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
    public static final int TILE_SIZE = 30; // pixels
    
    private int pyramidHeight;
    private Mario mario;
    
    /**
     * Setup the world with MAXN_COLUMNS x MAXN_ROWS
     * of tiles, with a tiles being squares TILE_SIZE pixels
     * 
     */
    public MarioWorld()
    {    
        // Create a new world with 24 x 20 tiles of 30 pixels each
        
        super(MAXN_COLUMNS, MAXN_ROWS, TILE_SIZE); 
        
        drawPath();
        
        mario = new Mario();
        addObject(mario, 1, 17);
        
        createPyramid();
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
                Block Block = new Block();
                addObject(Block, x, y);
            }
        }
    }
    
    private int getPyramidHeight()
    {
        String reply;
        int height = 0;
        boolean isValid = false;

        while(!isValid)
        {
            reply = Greenfoot.ask("Enter the pyramid height (1-8) > ");
            height = Integer.parseInt(reply); 
            
            if((height >= 1) && (height <= 8))
            {
                isValid = true;
            }
        }

        return height;
    } 
    
    public void createPyramid()
    {
        pyramidHeight = getPyramidHeight();
        
        int yStart = MAXN_ROWS - 3;
        int yEnd = yStart - pyramidHeight;
        
        int xStart1 = (MAXN_COLUMNS - ((pyramidHeight * 2) + 2))/2;
        int xStart2 = xStart1 + pyramidHeight + 2;
        
        int width = pyramidHeight;
        
        for(int y = yStart; y > yEnd; y--)
        {
            for(int x = xStart1; x < (xStart1 + width); x++)
            {
                Block Block = new Block();
                addObject(Block, x, y);
            }
            
            for(int x = xStart2 ; x < (xStart2 + width); x++)
            {
                Block Block = new Block();
                addObject(Block, x, y);
            }

            width--;
            xStart1++;
        }
    }
    
}
