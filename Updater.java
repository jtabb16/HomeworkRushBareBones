package org.jbt.management;


import org.jbt.boundaryDetection.BoundaryChecker;
import org.jbt.gameComponents.TransparentTile;
import org.jbt.gameComponents.Player;
import org.jbt.gameComponents.Tile;
import org.jbt.gameComponentsSynthesized.TileMap;

/**
 *
 * @author jbt
 */
public class Updater 
{
    private final float gravityAccel = -.03f;//Acceleration due to gravity
    TileMap tileMap;
    Player player;
    BoundaryChecker bChecker;
    Tile [][] tiles;
    public Updater(TileMap tMap, Player p)
    {
        System.out.println("\nMaking New Updater");
        tileMap = tMap;
        player = p;
        bChecker = new BoundaryChecker();
        tiles = tileMap.getTiles();
        System.out.println("New Updater Made");
    }
    
    protected void update()
    {
        for (Tile[] tile1 : tiles) {
            for (Tile tile : tile1) {
                updatePhysics(tile);
                updateBoundaryDetection(tile);
            }
        }
    }
    
    private void updatePhysics(Tile tile)
    {
        //player.getEntityBoundary().setXCoord(player.getXCoord());
        //player.getEntityBoundary().setYCoord(player.getYCoord());
        
        tile.setYVel(tile.getYVel() + gravityAccel);
        tile.setYCoord(tile.getYCoord() + tile.getYVel());
        tile.setXCoord(tile.getXCoord() + tile.getXVel());

        tile.getTileBoundary().setXCoord(tile.getXCoord());
        tile.getTileBoundary().setYCoord(tile.getYCoord());
    }
    
    private void updateBoundaryDetection(Tile tile)
    {
        //Prevent entity from going through top of tile...
        if 
        ( 
            ( tile.getXCoord() <= (player.getXCoord() + player.getWidth()) ) && //Left side of tile is less than or equal to entity's right side
            ( (tile.getXCoord() + tile.getWidth()) >= player.getXCoord() ) && //Right side of tile is greater than or equal to entity's left side
            ( tile.getYCoord() <= (player.getYCoord() + player.getHeight()) ) && //Top of tile is at or above the entity's feet
            ( tile.getYCoord() >= (player.getYCoord() + player.getHeight()/3) ) &&// The top of the tile is at or below the coordinate 1/3 the way up from the entity's feet
            !( tile instanceof TransparentTile) //If the tile isn't transparent. (It is an actual tile)
        )
            
        {
            System.out.println("Player Contacting Tiles");
            tile.setYCoord(player.getYCoord()+player.getHeight());
            changeTilesY(player, tiles, tile);
        }
        
        //Prevent entity from going through bottom of tile...
        
        //Prevent entity from going through left of tile...
        
        //Prevent entity from going through right of tile...
        
        
    }
    
    /*
    private void updateBoundaryDetection()
    {
        //Tile [][] tiles = tileMap.getTiles();
        for (Tile[] tile1 : tiles) {
            for (Tile tile : tile1) {
                //System.out.println("Tile is " + tile.toString());
                String tileName = tile.toString();
                if(bChecker.entityBoundaryTouchingTileBoundary(player.getEntityBoundary(), tile.getTileBoundary())
                    && !(tileName.contains("TransparentTile")) )
                {
                    tile.setYCoord(player.getYCoord() + player.getHeight());
                    changeTilesY(player, tiles, tile);
                    System.out.println("Player Touching Non-null Tile: " + tileName);
                    System.out.println("Player X: " + player.getXCoord() + ", Player Y: " + player.getYCoord());
                    System.out.println("Tile X: " + tile.getXCoord() + ", Tile Y: " + tile.getYCoord());
                    System.out.println("TileBoundX: " + tile.getTileBoundary().getXCoord() + ", TileBoundY: " + tile.getTileBoundary().getYCoord());
                }
            }
        }
    }
    */
    
    private void changeTilesY(Player p, Tile[][] tiles, Tile contactedTile)
    {
        float originalY = contactedTile.getOriginalY();
        for (Tile[] tile1 : tiles) {
            for (Tile tile : tile1) {
                tile.setYVel(0);
                //tile.setYCoord(contactedTileOriginalY - (contactedTileOriginalY - tile.getOriginalY()));
                tile.setYCoord(contactedTile.getYCoord() - (originalY - tile.getOriginalY()));
            }
        }
    }
    
    private void updateDamageAndHealth()
    {
        
    }
}
