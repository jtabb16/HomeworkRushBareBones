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
public abstract class Component//abstract so it can't be instantiated
{
    private Image image;
    private float xCoord, yCoord;
    private int imageWidth, imageHeight;
    
    public Component(String imageName, int xC, int yC, int w, int h)
    {
        //System.out.println("\nMaking New Component");
        loadImage (imageName + ".png");
        xCoord = xC;
        yCoord = yC;
        imageWidth = w;
        imageHeight = h;
        //System.out.println("New Component Made");
    }
    
    public final void loadImage(String nameOfImage)
    {
        URL location = Tile.class.getProtectionDomain().getCodeSource().getLocation();
        URL url = null;
        try {
            url = new URL (location + "images/" + nameOfImage);
        } catch (MalformedURLException | NullPointerException e) {
            Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, e);
            System.out.println ("ERROR Loading Images : Component.java");
        }
        
        ImageIcon ii = new ImageIcon(url);
        image = ii.getImage();
    }
    
    public final void drawImage(Graphics2D g2)
    {   
        if (image != null)
            g2.drawImage(image, Math.round(xCoord), Math.round(yCoord), imageWidth, imageHeight, null);
        else
            System.out.println("Requested Image Is Null");
    }
    
    /*
    public static int getTileWidth()
    {
        return TILE_WIDTH;
    }
    
    public static int getTileHeight()
    {
        return TILE_HEIGHT;
    }
    */
    
    public float getXCoord()
    {
        return xCoord;
    }
    public void setXCoord(float x)
    {
        xCoord = x;
    }
    
    
    public float getYCoord()
    {
        return yCoord;
    }
    public void setYCoord(float y)
    {
        yCoord = y;
    } 
}
