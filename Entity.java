/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.gameComponents;

import org.jbt.boundaryDetection.Boundary;
import org.jbt.boundaryDetection.EntityBoundary;

/**
 *
 * @author jbt
 */
public class Entity extends Component
{
    private EntityBoundary boundary;
    private static final int ENTITY_WIDTH = Tile.getTileWidth()/2;
    private static final int ENTITY_HEIGHT = Tile.getTileHeight();
    
    public Entity(String name, int x, int y)
    {
        super(name, x,y, ENTITY_WIDTH, ENTITY_HEIGHT );
        //makeBoundary(x,y,ENTITY_WIDTH, ENTITY_HEIGHT);
        boundary = new EntityBoundary(x,y,ENTITY_WIDTH,ENTITY_HEIGHT);
    }
    
    /*
    @Override
    final void makeBoundary(int x, int y, int w, int h)
    {
        super.setComponentBoundary(new EntityBoundary (x,y,w,h));
    }
    */
    
    public static int getEntityWidth(){ return ENTITY_WIDTH; }
    public static int getEntityHeight(){ return ENTITY_HEIGHT; }
    
    public EntityBoundary getEntityBoundary()
    {
        return boundary;
    }
}
