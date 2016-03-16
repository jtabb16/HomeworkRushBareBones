/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.management;

import java.awt.Color;
//import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Toolkit;
//import java.awt.image.BufferStrategy;
import org.jbt.display.GameFrame0;
//import javax.swing.JPanel;
//import org.jbt.display.GamePanel;
import org.jbt.synthesizedGameComponents.TileMap;

/**
 *
 * @author jbt
 */
public class Renderer 
{
    Graphics2D g2;
    TileMap tMap;
    int pWidth, pHeight;
    
    GameFrame0 frame;
    public Renderer(TileMap t)//Probably will need gamestate later on to know what to render
    {
        frame = new GameFrame0();
        g2 = frame.getG();
        pWidth = frame.getWidth();
        pHeight = frame.getHeight();
        tMap = t;
        System.out.println("New Renderer Made");
        
        //Not sure if I need this, but apparently, it makes sure that hardware acceleration is on
        System.setProperty("sun.java2d.opengl","True");
    }
    
    protected void render()
    {
        frame.prepareDraw();
            g2 = frame.getG();
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, pWidth, pHeight);
            tMap.drawTiles(g2);
        frame.draw();
    }
    
    protected GameFrame0 getFrame(){ return frame; }
    /*
    private void drawStuff() {
	Graphics g = null;
 
	try {
		g = bf.getDrawGraphics();
 
		// It is assumed that mySprite is created somewhere else.
		// This is just an example for passing off the Graphics object.
		mySprite.draw(g);
 
	} finally {
		// It is best to dispose() a Graphics object when done with it.
		g.dispose();
	}
 
	// Shows the contents of the backbuffer on the screen.
	bf.show();
 
        //Tell the System to do the Drawing now, otherwise it can take a few extra ms until 
        //Drawing is done which looks very jerky
        Toolkit.getDefaultToolkit().sync();	
}
 */
    
    /*
    public Graphics getGraphicsObject()
    {
        return g;
    }
    */
}
