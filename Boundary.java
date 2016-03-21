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
public abstract class Boundary //Abstract so that it can't be instantiated
{
    private float xCoord, yCoord; //The coordinates of the top-left corner
    private int width, height; //The width and height of the boundary / "hit-box"
    
    public Boundary(int x, int y, int w, int h)
    {
        xCoord = x;
        yCoord = y;
        width = w;
        height = h;
    }
    
    public float getXCoord(){ return xCoord; }
    public void setXCoord(float x){ xCoord = x; }
    public float getYCoord(){ return yCoord; }
    public void setYCoord(float y){ xCoord = y; }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
}
