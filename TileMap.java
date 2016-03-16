package org.jbt.synthesizedGameComponents;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashSet;
import org.jbt.gameComponents.GenericTile;
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
    HashSet <Image> setOfTileImages;
    //Graphics gfx;
    public TileMap(int numLevel)
    {
        LevelLoader loader = new LevelLoader(numLevel);
        loader.loadLevelMap();
        tileArray = loader.getTiles();
        
        
        //gfx = g;
        //loadLevelMap(numLevel);
        setOfTileImages = new HashSet<Image>();
        
        loadTileImages();
        System.out.println("New TileMap For Level " + numLevel + " Made");
    }
    
    public void loadTileImages()
    {
        System.out.println("Loading Map");
        /*
        for (int x = 0; x < tileArray.length; x++)
        {
        for (int y = 0; y < tileArray[x].length; y++)
        {
        Tile tileType = tileArray[x][y];
        if (tileArray[x][y] instanceof GenericTile)
        setOfTileImages.add(tileArray[x][y].loadTileImage("GXXX.png"));
        else if (tileArray[x][y] instanceof GenericTile)
        System.out.println();//Do stuff
        }
        }
         */
        for (Tile[] tileArray1 : tileArray) {
            for (Tile tileType : tileArray1) {
                if (tileType instanceof GenericTile) {
                    setOfTileImages.add(tileType.loadTileImage("GXXX.png"));
                } else if (tileType instanceof GenericTile) {
                    System.out.println();//Do stuff
                }
            }
        }
    }
    
    public void drawTiles(Graphics gfx)
    {
        /*
        for (int x = 0; x < tileArray.length; x++)
        {
        for (int y = 0; y < tileArray[x].length; y++)
        {
        if (tileArray[x][y] == null)
        {
        //System.out.println("Requested Image Is Null");
        }
        else
        {
        //System.out.println("Drawing Tile");
        tileArray[x][y].drawTile(gfx);
        }
        }
        }
         */
        for (Tile[] tileArray1 : tileArray) {
            for (Tile item : tileArray1) {
                if (item == null) {
                    //System.out.println("Requested Image Is Null");
                } else {
                    //System.out.println("Drawing Tile");
                    item.drawTile(gfx);
                }
            }
        }
        
    }
    
    public Tile[][] getTiles()
    {
        return tileArray;
    }
}
