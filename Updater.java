package org.jbt.management;

//import org.jbt.display.GameFrame2;
//import org.jbt.display.GameFrame;
import org.jbt.display.GameFrame0;
import org.jbt.gameComponents.Tile;
import org.jbt.synthesizedGameComponents.TileMap;

/**
 *
 * @author jbt
 */
public class Updater 
{
    private final float gravityAccel = -.0009f;//Acceleration due to gravity
    TileMap tileMap;
    InputProcessor input;
    GameFrame0 gFrame;
    public Updater(TileMap tMap, GameFrame0 gf)
    {
        tileMap = tMap;
        gFrame = gf;
        input = new InputProcessor();
        System.out.println("New Updater Made");
    }
    
    protected void update()
    {
        input.performKeys(gFrame);//Check the user input
        updatePhysics();
        //updateBoundaryDetection();
    }
    
    private void updatePhysics()
    {
        Tile [][] tiles = tileMap.getTiles();
        /*
        for (int x = 0; x < tiles.length; x++)
        {
        for (int y = 0; y < tiles[x].length; y++)
        {
        tiles[x][y].setYVel(tiles[x][y].getYVel() + gravityAccel);
        //tiles[x][y].setYVel(gravityAccel);
        tiles[x][y].setYCoord(tiles[x][y].getYCoord() + tiles[x][y].getYVel());
        }
        }
         */
        for (Tile[] tile1 : tiles) {
            for (Tile tile : tile1) {
                tile.setYVel(tile.getYVel() + gravityAccel);
                //tiles[x][y].setYVel(gravityAccel);
                tile.setYCoord(tile.getYCoord() + tile.getYVel());
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
