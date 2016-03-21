/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.gameComponents;

import java.awt.Graphics2D;
import org.jbt.boundaryDetection.TileBoundary;
//import org.jbt.synthesizedGameComponents.LevelLoader;
/**
 *
 * @author jbt
 * Purpose: Define all properties that every tile needs and uses.
 *          Instantiable tiles will define their own unique properties, in addition to this class
 * 
 */
public abstract class Tile extends Component//Abstract so that it cannot be instantiated. 
{
    private final float WALK_SPEED = 2.0f;
    private final float RUN_SPEED = 2*WALK_SPEED;
    private final float JUMP_SPEED = 2.5f;
    private static final int TILE_WIDTH = 100;//100
    private static final int TILE_HEIGHT = 100;//100
    
    private TileBoundary boundary;
    public Tile(String tileName, int xC, int yC)
    { 
        //System.out.println("\nMaking New " + tileName + " Tile");
        super(tileName, xC, yC, TILE_WIDTH, TILE_HEIGHT);
        boundary = new TileBoundary(xC, yC, TILE_WIDTH, TILE_HEIGHT);
        //makeBoundary(xC, yC, TILE_WIDTH, TILE_HEIGHT);
        //System.out.println("New " + tileName + " Tile Made");
    }
    
    /*
    @Override
    final void makeBoundary(int x, int y, int w, int h)
    {
        super.setComponentBoundary(new TileBoundary (x,y,w,h));
    }
    */
    
    public final void drawTile(Graphics2D g2, double extrapolationValue)
    {
        //Extrapolate where the image should be...
        float newXVel = super.getXVel()*(float)extrapolationValue;
        float newX = super.getXCoord() + newXVel;
        float newYVel = super.getYVel()*(float)extrapolationValue;
        float newY = super.getYCoord() + newYVel;
        
        //Draw the image...
        super.drawImage(g2, newX, newY);
    }
    
    public static int getTileWidth(){ return TILE_WIDTH; }
    public static int getTileHeight(){ return TILE_HEIGHT; }
    
    public float getWalkSpeed(){ return WALK_SPEED; }
    public float getRunSpeed(){ return RUN_SPEED; }
    public float getJumpSpeed(){ return JUMP_SPEED; } 
    
    public TileBoundary getTileBoundary()
    {
        return boundary;
    }
}
