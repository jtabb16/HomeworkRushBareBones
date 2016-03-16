/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.gameComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.jbt.synthesizedGameComponents.LevelLoader;

/**
 *
 * @author jbt
 */
public abstract class Tile //Abstract so that it cannot be instantiated. 
{
    private Image image;
    
    private float xCoord, yCoord;
    private float xVel, yVel;
    private static final int TILE_WIDTH = 100;
    private static final int TILE_HEIGHT = 100;

    public Tile(String tileName, int xC, int yC)
    {
        //loadTileImage(tileName);
        xCoord = xC;
        xVel = 0;
        yCoord = yC;
        yVel = 0;
        System.out.println("New " + tileName + " Tile Made");
    }
    
    //public final Image getImage() { return image; }
    
    
    public final Image loadTileImage(String nameOfTile)
    {
        URL location = LevelLoader.class.getProtectionDomain().getCodeSource().getLocation();
        URL url = null;
        try {
            url = new URL (location + "images/" + nameOfTile);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageIcon ii = new ImageIcon(url);
        image = ii.getImage();
        return image;
    }
    
    public final void drawTile(Graphics g)
    {
        //g.drawImage(image, xCoord, yCoord, null);
        
        if (image == null)
        {
            g.setColor(Color.WHITE);
            g.fillRect(Math.round(xCoord), Math.round(yCoord), TILE_WIDTH, TILE_HEIGHT);
            //System.out.println("Drawing Null Image");
        }
            
        else
        {
            //System.out.println("Drawing Image");
            g.drawImage(image, Math.round(xCoord), Math.round(yCoord), TILE_WIDTH, TILE_HEIGHT, null);
            //System.out.println("XCOORD: " + xCoord + ", YCOORD: " + yCoord);
            //g.setColor(Color.RED);
            //g.fillRect (xCoord, yCoord, tileWidth, tileHeight);
            //g.fillRect (500,700, 100, 100);
        }
        
    }
    
    public static int getTileWidth()
    {
        return TILE_WIDTH;
    }
    
    public static int getTileHeight()
    {
        return TILE_HEIGHT;
    }
    
    public float getYCoord()
    {
        return yCoord;
    }
    
    public void setYCoord(float y)
    {
        yCoord = y;
    }
    
    public float getYVel()
    {
        return yVel;
    }
    
    public void setYVel(float vel)
    {
        yVel = vel;
    }
}
