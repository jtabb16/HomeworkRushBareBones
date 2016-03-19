package org.jbt.management;


import org.jbt.gameComponents.Tile;
import org.jbt.gameComponentsSynthesized.TileMap;

/**
 *
 * @author jbt
 */
public class Updater 
{
    private final float gravityAccel = -.007f;//Acceleration due to gravity
    TileMap tileMap;
    public Updater(TileMap tMap)
    {
        System.out.println("\nMaking New Updater");
        tileMap = tMap;
        System.out.println("New Updater Made");
    }
    
    protected void update()
    {
        updatePhysics();
        //updateBoundaryDetection();
    }
    
    private void updatePhysics()
    {
        Tile [][] tiles = tileMap.getTiles();
        
        for (Tile[] tile1 : tiles) {
            for (Tile tile : tile1) {
                tile.setYVel(tile.getYVel() + gravityAccel);
                tile.setYCoord(tile.getYCoord() + tile.getYVel());
                tile.setXCoord(tile.getXCoord() + tile.getXVel());
            }
        }
    }
    
    private void updateBoundaryDetection()
    {
        
    }
    
    private void updateDamageAndHealth()
    {
        
    }
}
