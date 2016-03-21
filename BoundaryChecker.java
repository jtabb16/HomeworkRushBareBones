/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.boundaryDetection;

/**
 *
 * @author jbt
 */
public class BoundaryChecker 
{
    public BoundaryChecker()
    {
        
    }
    
    public boolean entityBoundaryTouchingTileBoundary(EntityBoundary e, TileBoundary t)
    {
        boolean checker = false;
        if 
            ( 
                ( t.getXCoord() <= (e.getXCoord() + e.getWidth()) ) && //Left side of tile is less than or equal to entity's right side
                ( (t.getXCoord() + t.getWidth()) >= e.getXCoord() ) && //Right side of tile is greater than or equal to entity's left side
                ( t.getYCoord() <= (e.getYCoord() + e.getHeight()) ) && //Top of tile is at or above the entity's feet
                ( t.getYCoord() >= (e.getYCoord() + e.getHeight()/3) )// The top of the tile is at or below the coordinate 1/3 the way up from the entity's feet
            )
        {
            checker = true;
        }
        
        
        /*
        if ( ( (e.getXCoord()+e.getWidth()) >= t.getXCoord()) && //Right side of entity is at or past left side of tile
             ( e.getXCoord() <= (t.getXCoord()+t.getWidth()) ) && //Left side of entity is at or less than right side of tile
             ( (e.getYCoord()+e.getHeight()) <= (t.getYCoord()+t.getHeight()/3)) && //Feet of entity are at or above 1/3 the way down from the tile's surface
             (e.getYCoord()+e.getHeight() >= t.getYCoord() )              //Feet of entity are at or below the surface of the tile
            )
        {
            checker = true;
        }
        */
        return checker;
    }
}
