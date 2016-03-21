/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.management;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import org.jbt.display.DisplayFrame;
import org.jbt.gameComponents.Player;
import org.jbt.gameComponentsSynthesized.TileMap;


/**
 *
 * @author jbt
 */
public class Renderer 
{
    Graphics2D g2;
    TileMap tMap;
    Player player;
    int pWidth, pHeight;
    
    DisplayFrame frame;
    public Renderer(TileMap t, Player p)//Probably will need gamestate later on to know what to render
    {
        System.out.println("\nMaking New Renderer");
        frame = new DisplayFrame();
        g2 = frame.getG();
        pWidth = frame.getWidth();
        pHeight = frame.getHeight();
        tMap = t;
        player = p;
        System.out.println("New Renderer Made");
        
        //Good description of what the following commands do and the difference between them:
        //http://stackoverflow.com/questions/22318322/what-is-the-difference-between-opengl-and-xrender-in-kde-desktop-effects
        
        //Not sure if I need this, but apparently, it makes sure that java uses opengl
        System.setProperty("sun.java2d.opengl","True");
        
        //Not sure if I need this either, but it makes java use x11, which could help performance on modern systems
        //It seems to help so far (I have an NVidia GPU, which may effect this)...
        System.setProperty("sun.java2d.xrender", "True");
    }
    
    protected void render(double extrapolationValue)
    {
        //Prepare the double buffer...
        frame.prepareDraw();
        
            //Get the graphics object...
            g2 = frame.getG();
            
            //Rendering Hints:
                RenderingHints renderingHintsMap = g2.getRenderingHints();
                //Enable Anti-Aliasing...
                renderingHintsMap.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                //Change the type of Anti-Aliasing...
                    //Default is NearestNeighbor, BILINEAR has better graphics, BICUBIC has best. BICUBIC is too slow for a game though
                    //BILINEAR AND BICUBIC WERE LOOKING WEIRD, SO DISABLE THIS FOR NOW:
                //renderingHintsMap.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                //Enable text Anti-Aliasing...
                renderingHintsMap.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                g2.setRenderingHints(renderingHintsMap);
            ///////////////////////////////////////////////////
            
            //Draw a white background (Later, this will be an image)...
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, pWidth, pHeight);
            
            //Draw the tiles...
            tMap.drawTiles(g2, pWidth, pHeight, extrapolationValue);
            
            //Draw the player...
            player.drawPlayer(g2, extrapolationValue);
            //Draw the other game Components:
        //Draw the buffer to the screen:
        frame.draw();
    }
}
