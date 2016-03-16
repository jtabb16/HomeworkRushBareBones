/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.management;
/*
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import org.jbt.display.GameFrame;
*/
import org.jbt.synthesizedGameComponents.TileMap;

/**
 *
 * @author jbt
 */
public class GameManager 
{
    //GameFrame2 gFrame;
    //GameFrame gFrame;
    Updater updater;
    Renderer renderer;
    TileMap levelMap;
    //Graphics2D g2;
    //public GameManager(int levelNum, Graphics2D graphics)
    public GameManager(int levelNum)
    {
        levelMap = new TileMap(levelNum);
        renderer = new Renderer(levelMap);
        updater = new Updater(levelMap, renderer.getFrame());
        System.out.println("New GameManager Made");
    }
    
    public void startGame()
    {
        boolean runGame = true;
        System.out.println("Game Running");
        /*
        Graphics2D g2D = null;
            BufferStrategy strategy = gFrame.getFrame().getBufferStrategy();
                g2D = (Graphics2D)strategy.getDrawGraphics();
                Point frameLoc = gFrame.getFrame().getLocationOnScreen();
                Point viewLoc = gFrame.getGamePanel().getLocationOnScreen();
                g2D.translate(viewLoc.x - frameLoc.x, viewLoc.y - frameLoc.y);
                */
               
                
                /*g = gFrame.getFrameBufferStrategy().getDrawGraphics();
                
                
                Point frameLoc = gFrame.getLocationOnScreen();
                Point viewLoc = gFrame.getGamePanel().getLocationOnScreen();
                g2D.translate(viewLoc.x - frameLoc.x, viewLoc.y - frameLoc.y);
                */
                
        while (runGame)
        {
            //getGamePanel().
            updater.update();
            renderer.render();
            //}
            //getGamePanel().
                //Graphics g = gFrame.getGamePanel().getGraphics();
                //renderer = new Renderer(g, gFrame.getFrameBufferStrategy(), gFrame.getGamePanel().getWidth(), gFrame.getGamePanel().getHeight(), level);
                //renderer = new Renderer (g, gFrame.getGamePanel().getWidth(), gFrame.getGamePanel().getHeight(), level);
                //renderer.render();
            
            
                //renderer = new Renderer(g2, gFrame.getWidth(), gFrame.getHeight(), level);
            //try{
                
                
                //updater.update( gF2);

                 
                 //gF2.runGameFrame();
                  
            //finally
            //{
                //g2D.dispose();
            //}
            
           
            
            //System.out.println("Game Running");
        }
    }
    
}
