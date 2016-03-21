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
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.jbt.boundaryDetection.Boundary;

/**
 *
 * @author jbt
 */
public abstract class Component//abstract so it can't be instantiated
{
    private Image image;
    private float xCoord, yCoord;
    private final float originalX, originalY;
    private float xVel, yVel;
    private int imageWidth, imageHeight;
    
    //Each Component will have a boundary. For example, a Tile will have a Tile Boundary
    //The reason the method, 'makeBoundary', is abstract is so that it will get overriden 
    //and use the correct type of Boundary for the subclass that is extending this Component class
    //private Boundary boundary;
    
    public Component(String imageName, int xC, int yC, int w, int h)
    {
        //System.out.println("\nMaking New Component");
        loadImage (imageName + ".png");
        xCoord = xC;
        originalX = xC;
        yCoord = yC;
        originalY = yC;
        xVel = 0;
        yVel = 0;
        imageWidth = w;
        imageHeight = h;
        //System.out.println("New Component Made");
    }
    
    public final void loadImage(String nameOfImage)
    {
        System.out.println ("Loading " + "'" + nameOfImage +"'");
        //Get the location of the source folder...
        URL location = getClass().getProtectionDomain().getCodeSource().getLocation();
        URL url = null;
        
        try {
            //Get the location of the requested image...
            
            url = new URL (location + "images/" + nameOfImage);
            //url = ClassLoader.getSystemClassLoader().getResource(nameOfImage);
            url.toURI();
        } catch (MalformedURLException | NullPointerException | URISyntaxException e) {
            //If there is an error, log it and print the following statement...
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            System.out.println ("ERROR Loading Images : Component.java");
        }
        //Make a new image icon and store it in memory as a variable called 'image'...
        ImageIcon ii = new ImageIcon(url);
        image = ii.getImage();
    }
    
    public final void drawImage(Graphics2D g2, float newX, float newY)
    {   
        if (image != null)
        {
            g2.drawImage(image, Math.round(newX), Math.round(newY), imageWidth, imageHeight, null);
        }
        else
            System.out.println("Requested Image Is Null");
    }
    
    
    //public void setComponentBoundary (Boundary b){ boundary = b; }
    
    public float getXCoord(){ return xCoord; }
    public float getOriginalX(){ return originalX; }
    public void setXCoord(float x){ xCoord = x; }
    
    public float getXVel(){ return xVel; }
    public void setXVel(float vel){ xVel = vel; }
    
    public float getYCoord(){ return yCoord; }
    public float getOriginalY(){ return originalY; }
    public void setYCoord(float y){ yCoord = y; } 
    
    public float getYVel(){ return yVel; }
    public void setYVel(float vel){ yVel = vel; }
    
    public float getWidth(){ return imageWidth; }
    public float getHeight(){ return imageHeight; }
    
    //abstract void makeBoundary(int x, int y, int w, int h);
}
