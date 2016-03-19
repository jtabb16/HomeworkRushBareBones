/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.gameComponents;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author jbt
 */
public class Player extends Component
{
    private Image image;
    
    private float xCoord, yCoord;
    private float xVel, yVel;
    private final float WALK_SPEED = 2;
    private final float JUMP_SPEED = 1.5f;
    private static final int TILE_WIDTH = 100;//100
    private static final int TILE_HEIGHT = 100;//100
    
    public Player(String tileName, int xC, int yC)
    {
        super (tileName, xC, yC, 10,10);
        //System.out.println("\nMaking New " + tileName + " Tile");
        loadTileImage (tileName + ".png");
        xCoord = xC;
        xVel = 0;
        yCoord = yC;
        yVel = 0;
        //System.out.println("New " + tileName + " Tile Made");
    }
    
    public final void loadTileImage(String nameOfTile)
    {
        URL location = Tile.class.getProtectionDomain().getCodeSource().getLocation();
        URL url = null;
        try {
            url = new URL (location + "images/" + nameOfTile);
        } catch (MalformedURLException | NullPointerException e) {
            Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, e);
            System.out.println ("ERROR Loading Images : Tile.java");
        }
        
        ImageIcon ii = new ImageIcon(url);
        image = ii.getImage();
    }
    
    public final void drawTile(Graphics2D g2)
    {
        if (image == null)
        {
            Color transparent = new Color (255,255,255,0);
            g2.setColor(transparent);
            g2.fillRect(Math.round(xCoord), Math.round(yCoord), TILE_WIDTH, TILE_HEIGHT);
        }
        else
        {
            g2.drawImage(image, Math.round(xCoord), Math.round(yCoord), TILE_WIDTH, TILE_HEIGHT, null);
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
    
    public float getXCoord()
    {
        return xCoord;
    }
    
    public void setXCoord(float x)
    {
        xCoord = x;
    }
    
    public float getXVel()
    {
        return xVel;
    }
    
    public float getWalkSpeed()
    {
        return WALK_SPEED;
    }
    public void setXVel(float vel)
    {
        xVel = vel;
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
    
    public float getJumpSpeed()
    {
        return JUMP_SPEED;
    }
    
    public void setYVel(float vel)
    {
        yVel = vel;
    }
}
