/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.management;

import java.awt.Color;
import java.awt.Graphics2D;
import org.jbt.display.DisplayFrame;
import org.jbt.gameComponentsSynthesized.TileMap;


/**
 *
 * @author jbt
 */
public class Renderer 
{
    Graphics2D g2;
    TileMap tMap;
    int pWidth, pHeight;
    
    DisplayFrame frame;
    public Renderer(TileMap t)//Probably will need gamestate later on to know what to render
    {
        System.out.println("\nMaking New Renderer");
        frame = new DisplayFrame();
        g2 = frame.getG();
        pWidth = frame.getWidth();
        pHeight = frame.getHeight();
        tMap = t;
        System.out.println("New Renderer Made");
        
        //Not sure if I need this, but apparently, it makes sure that java uses opengl
        //System.setProperty("sun.java2d.opengl","True");
        
        //Not sure if I need this either, but it makes java use x11, which could help performance on modern systems
        //It seems to help so far (I have an NVidia GPU, which may effect this)...
        System.setProperty("sun.java2d.xrender", "True");
    }
    
    protected void render()
    {
        frame.prepareDraw();
            g2 = frame.getG();
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, pWidth, pHeight);
            
            tMap.drawTiles(g2, pWidth, pHeight);
        frame.draw();
    }
}
