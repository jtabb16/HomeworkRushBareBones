package org.jbt.gameComponentsSynthesized;

import org.jbt.fileIO.LevelLoader;
import java.awt.Graphics2D;
import org.jbt.gameComponents.Tile;

/**
 *
 * @author jbt
 */
public class TileMap 
{
    //2D array of type Tile. The objects inside will be specific types of tiles
    //This is our "map" of tiles that the player will play inside of
    Tile [][] tileArray;
    public TileMap(String levelName)
    {
        System.out.println("\nMaking New TileMap For Level " + levelName);
        LevelLoader loader = new LevelLoader("org/jbt/resources/levels/" + levelName + ".level");
        loader.readFile();
        tileArray = loader.getTiles();
        System.out.println("New TileMap For Level " + levelName + " Made");
    }
    
    public final void drawTiles(Graphics2D gfx, int frameWidth, int frameHeight)
    {
        for (Tile[] tileArray1 : tileArray) {
            for (Tile item : tileArray1) {
                if (item == null) {
                    System.out.println("Requested Image Is Null");
                } else {
                    //Only Render the tiles that are on the screen and just one tile off of the screen:
                    if ( (item.getXCoord() > (0 - Tile.getTileWidth())) && (item.getXCoord() < (frameWidth + Tile.getTileWidth())) 
                        && (item.getYCoord() > (0 - Tile.getTileHeight())) && (item.getYCoord() < (frameHeight + Tile.getTileHeight())) )
                    {
                        item.drawTile(gfx);
                    }
                }
            }
        }
    }
    
    public Tile[][] getTiles()
    {
        return tileArray;
    }
}
